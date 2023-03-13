package blblblbl.cftfocus.binlist.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import blblblbl.cftfocus.binlist.navigation.History
import blblblbl.cftfocus.history.ui.HistoryFragmentCompose


fun NavGraphBuilder.historyGraph(navController: NavHostController) {
    navigation(startDestination = History.route, route = "HistoryNested") {
        composable(route = History.route) {
            HistoryFragmentCompose(
            )
        }
    }
}
