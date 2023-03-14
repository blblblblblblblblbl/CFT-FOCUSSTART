package blblblbl.cftfocus.binlist.navigation.graphs

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import blblblbl.cftfocus.binlist.navigation.History
import blblblbl.cftfocus.detailed.ui.DetailedFragmentCompose
import blblblbl.cftfocus.history.ui.HistoryFragmentCompose


fun NavGraphBuilder.historyGraph(navController: NavHostController) {
    navigation(startDestination = History.route, route = "HistoryNested") {
        composable(route = History.route) {
            HistoryFragmentCompose(
                itemOnClick = { bin->
                    navController.navigate("${HistoryNavGraph.DETAILED_ROUTE}/${bin}")
                }
            )
        }
        composable(
            route =  "${HistoryNavGraph.DETAILED_ROUTE}/{${HistoryNavGraph.DETAILED_BIN_KEY}}",
            arguments = listOf(
                navArgument(name = HistoryNavGraph.DETAILED_BIN_KEY){
                    type = NavType.StringType
                }
            )
        ){navBackStackEntry ->
            val bin = navBackStackEntry.arguments?.getString(HistoryNavGraph.DETAILED_BIN_KEY)
            bin?.let {bin->
                DetailedFragmentCompose(bin = bin)
            }
        }
    }
}
private object HistoryNavGraph{
    const val DETAILED_ROUTE = "HistoryNavGraph.DetailedRoute"
    const val DETAILED_BIN_KEY = "HistoryNavGraph.DetailedBinKey"
}
