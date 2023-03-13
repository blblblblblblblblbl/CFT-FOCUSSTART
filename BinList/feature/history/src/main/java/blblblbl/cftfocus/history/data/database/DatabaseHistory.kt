package blblblbl.cftfocus.history.data.database

import androidx.paging.PagingData
import blblblbl.cftfocus.history.data.model.HistoryElement
import kotlinx.coroutines.flow.Flow

interface DatabaseHistory {
    fun getHistoryPagingDataFlow(pageSize: Int): Flow<PagingData<HistoryElement>>
}