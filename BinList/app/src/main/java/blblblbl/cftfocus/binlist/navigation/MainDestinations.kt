package blblblbl.cftfocus.binlist.navigation


import android.app.Application
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import blblblbl.cftfocus.binlist.R
import blblblbl.cftfocus.binlist.app.MyApp

interface AppDestination {
    val icon: ImageVector
    val route: String
    val name: String
}
object Search : AppDestination {
    override val icon = Icons.Default.Search
    override val route = "search"
    override val name = MyApp.appContext.getString(R.string.search)
}
object History : AppDestination {
    override val icon = Icons.Default.History
    override val route = "history"
    override val name = MyApp.appContext.getString(R.string.history)
}

val appTabRowScreens = listOf(Search, History)
@Preview
@Composable
fun MainSearchIcon(){
    Icon(Icons.Default.Search,contentDescription = null)
}
@Preview
@Composable
fun HistoryIcon(){
    Icon(Icons.Default.History,contentDescription = null)
}