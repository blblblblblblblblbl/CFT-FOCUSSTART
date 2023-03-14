package blblblbl.cftfocus.history.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoveUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import blblblbl.cftfocus.history.domain.model.HistoryElement
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun HistoryScreen(
    pagedHistory: Flow<PagingData<HistoryElement>>,
    itemOnClick: (String) -> Unit
){
    Surface {
        val lazyHistoryItems: LazyPagingItems<HistoryElement> = pagedHistory.collectAsLazyPagingItems()
        val listState = rememberLazyListState()
        LazyColumn(state = listState) {
            items(lazyHistoryItems) { item ->
                item?.query?.let{query ->
                    Card(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable { itemOnClick(query) }) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(text = query, style = MaterialTheme.typography.bodyMedium)
                            item.binInfo?.bank?.name?.let { name ->
                                Text(text = name, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }
        }
        val showButton = remember {
            derivedStateOf {
                listState.firstVisibleItemIndex > 0
            }
        }

        AnimatedVisibility (
            visible = showButton.value,
            enter = slideInHorizontally( initialOffsetX = {fullWidth -> fullWidth }),
            exit = slideOutHorizontally( targetOffsetX = {fullWidth -> fullWidth })
        ) {
            Box(Modifier.fillMaxSize()) {
                val coroutineScope = rememberCoroutineScope()
                FloatingActionButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 8.dp, end = 8.dp),
                    shape = CircleShape,
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    }
                ) {
                    Icon(Icons.Default.MoveUp, contentDescription = "up button")
                }
            }
        }
    }

}