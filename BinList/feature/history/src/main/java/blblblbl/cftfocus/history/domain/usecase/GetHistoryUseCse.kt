package blblblbl.cftfocus.history.domain.usecase

import androidx.paging.PagingData
import blblblbl.cftfocus.history.domain.model.HistoryElement
import blblblbl.cftfocus.history.domain.repository.RepositoryHistory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistoryUseCse @Inject constructor(
    private val repository: RepositoryHistory
) {
    fun execute(pageSize:Int): Flow<PagingData<HistoryElement>> =
        repository.getHistoryPagingDataFlow(pageSize)
}