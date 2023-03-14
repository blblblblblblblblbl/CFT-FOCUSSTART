package blblblbl.cftfocus.search.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import blblblbl.cftfocus.search.domain.model.BinInfo
import blblblbl.cftfocus.search.domain.model.Country
import blblblbl.cftfocus.search.presentation.SearchFragmentViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun SearchFragmentCompose(
    closeOnClick: ()->Unit
){
    val viewModel: SearchFragmentViewModel = hiltViewModel()
    val searchQuery by viewModel.searchQuery
    val searchedBin = viewModel.searchedBin.collectAsState()
    val context = LocalContext.current
    val phonePermissionState = rememberPermissionState(permission = Manifest.permission.CALL_PHONE)
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
    )

}
fun urlAction(context: Context, url:String?){
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
fun phoneAction(context: Context, phone:String?){
    phone?.let {phone->
        val intent = Intent(
            Intent.ACTION_CALL,
            Uri.parse("tel:$phone")
        )
        context.startActivity(intent)
    }
}

