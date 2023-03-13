package blblblbl.cftfocus.search.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import blblblbl.cftfocus.search.domain.model.BinInfo

@Composable
fun BinInfoView(
    binInfo: BinInfo
){
    Text(text = binInfo.toString())
}