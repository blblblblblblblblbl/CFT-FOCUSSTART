package blblblbl.cftfocus.history.data.datasource

import androidx.paging.PagingData
import blblblbl.cftfocus.history.data.database.DatabaseHistory
import blblblbl.cftfocus.history.data.model.HistoryElement
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HistoryDataSourceImpl @Inject constructor(
    private val databaseHistory: DatabaseHistory
):HistoryDataSource {
    override fun getHistoryPagingDataFlow(pageSize: Int): Flow<PagingData<HistoryElement>> =
        databaseHistory.getHistoryPagingDataFlow(pageSize = pageSize)
}