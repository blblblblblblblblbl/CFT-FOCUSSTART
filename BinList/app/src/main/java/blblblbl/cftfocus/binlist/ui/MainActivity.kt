package blblblbl.cftfocus.binlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import blblblbl.cftfocus.binlist.ui.theming.AppTheme
import blblblbl.cftfocus.search.ui.SearchFragmentCompose
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme() {
                SearchFragmentCompose(closeOnClick = { /*TODO*/ })
            }
        }
    }
}