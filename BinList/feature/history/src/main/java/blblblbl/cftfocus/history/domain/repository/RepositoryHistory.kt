package blblblbl.cftfocus.history.domain.repository

import androidx.paging.PagingData
import blblblbl.cftfocus.history.domain.model.HistoryElement
import kotlinx.coroutines.flow.Flow

interface RepositoryHistory {
    fun getHistoryPagingDataFlow(pageSize:Int): Flow<PagingData<HistoryElement>>
}