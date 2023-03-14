package blblblbl.cftfocus.history.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import blblblbl.cftfocus.history.domain.model.HistoryElement
import blblblbl.cftfocus.history.presentation.HistoryFragmentViewModel

@Composable
fun HistoryFragmentCompose(
    itemOnClick: (String) -> Unit
) {
    val viewModel: HistoryFragmentViewModel = hiltViewModel()
    viewModel.getHistory()
    Surface {
        val lazyHistoryItems: LazyPagingItems<HistoryElement> =
            viewModel.pagedHistory.collectAsLazyPagingItems()
        LazyColumn() {
            items(lazyHistoryItems) { item ->
                item?.query?.let{query ->
                    Card(modifier = Modifier.padding(10.dp).fillMaxWidth().clickable { itemOnClick(query) }) {
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
    }
}