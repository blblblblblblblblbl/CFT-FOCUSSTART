package blblblbl.cftfocus.detailed.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import blblblbl.cftfocus.detailed.presentation.DetailedFragmentViewModel

@Composable
fun DetailedFragmentCompose(bin: String) {
    val viewModel: DetailedFragmentViewModel = hiltViewModel()
    viewModel.getInfo(bin)
    val binInfo = viewModel.binInfo.collectAsState()
    Text(text = binInfo.value.toString())
}