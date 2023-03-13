package blblblbl.cftfocus.history.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import blblblbl.cftfocus.history.data.datasource.HistoryDataSource
import blblblbl.cftfocus.history.data.utils.mapToDomain
import blblblbl.cftfocus.history.domain.model.HistoryElement
import blblblbl.cftfocus.history.domain.repository.RepositoryHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryHistoryImpl @Inject constructor(
    private val historyDataSource: HistoryDataSource
):RepositoryHistory {
    override fun getHistoryPagingDataFlow(pageSize: Int): Flow<PagingData<HistoryElement>> =
        historyDataSource.getHistoryPagingDataFlow(pageSize = pageSize).map { pagingData->
            pagingData.map { historyElement->
                historyElement.mapToDomain()?:HistoryElement()
            }
        }
}