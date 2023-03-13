package blblblbl.cftfocus.history.data.datasource

import androidx.paging.PagingData
import blblblbl.cftfocus.history.data.model.HistoryElement
import kotlinx.coroutines.flow.Flow

interface HistoryDataSource {
    fun getHistoryPagingDataFlow(pageSize: Int): Flow<PagingData<HistoryElement>>
}