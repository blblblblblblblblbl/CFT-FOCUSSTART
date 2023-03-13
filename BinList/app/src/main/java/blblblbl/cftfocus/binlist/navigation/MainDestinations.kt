package blblblbl.cftfocus.binlist.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

interface AppDestination {
    val icon: ImageVector
    val route: String
}
object Search : AppDestination {
    override val icon = Icons.Default.Search
    override val route = "search"
}
object History : AppDestination {
    override val icon = Icons.Default.History
    override val route = "history"
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