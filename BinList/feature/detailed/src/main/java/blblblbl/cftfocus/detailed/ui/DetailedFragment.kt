package blblblbl.cftfocus.detailed.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import blblblbl.cftfocus.detailed.domain.model.Country
import blblblbl.cftfocus.detailed.presentation.DetailedFragmentViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun DetailedFragmentCompose(bin: String) {
    val viewModel: DetailedFragmentViewModel = hiltViewModel()
    viewModel.getInfo(bin)
    val binInfo = viewModel.binInfo.collectAsState()
    val context = LocalContext.current
    val phonePermissionState = rememberPermissionState(permission = Manifest.permission.CALL_PHONE)
    binInfo.value?.let {binInfo->
        Box(modifier = Modifier.fillMaxSize().padding(10.dp)){
            BinInfoView(
                binInfo = binInfo,
                urlOnClick = { urlAction(context,binInfo.bank?.url) },
                phoneOnClick = {
                    phonePermissionState.launchPermissionRequest()
                    if (phonePermissionState.status.isGranted) phoneAction(context,binInfo.bank?.phone) },
                locationOnClick = { locationAction(context,binInfo.country) }
            )
        }
    }

}
fun urlAction(context: Context,url:String?){
    url?.let {url->
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://$url")
        )
        context.startActivity(intent)
    }
}
fun locationAction(context: Context, country: Country?){
    val latitude = country?.latitude
    val longitude = country?.longitude
    if (latitude!=null &&longitude!=null){
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("geo:$latitude,$longitude")
        )
        context.startActivity(intent)
    }
}
fun phoneAction(context: Context,phone:String?){
    phone?.let {phone->
        val intent = Intent(
            Intent.ACTION_CALL,
            Uri.parse("tel:$phone")
        )
        context.startActivity(intent)
    }
}