package blblblbl.cftfocus.search.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import blblblbl.cftfocus.search.domain.model.BinInfo
import blblblbl.cftfocus.search.presentation.SearchFragmentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchFragmentCompose(
    closeOnClick: ()->Unit
){
    val viewModel: SearchFragmentViewModel = hiltViewModel()
    val searchQuery by viewModel.searchQuery
    val searchedBin = viewModel.searchedBin.collectAsState()
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            Box(modifier = Modifier.padding(top = 10.dp)){
                SearchWidget(
                    text = searchQuery,
                    onTextChange = {
                        viewModel.updateSearchQuery(query = it)
                    },
                    onSearchClicked = {
                        viewModel.search(query = it)
                    },
                    onCloseClicked = {
                        closeOnClick()
                    }
                )
            }
        },
        content = {
            searchedBin.value?.let { binInfo->
                Surface(modifier = Modifier.padding(top = it.calculateTopPadding())) {
                    BinInfoView(
                        binInfo = binInfo
                    )
                }
            }
        }
    )

}

