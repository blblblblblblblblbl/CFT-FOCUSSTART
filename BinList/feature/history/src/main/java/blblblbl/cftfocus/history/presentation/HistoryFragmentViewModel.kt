package blblblbl.cftfocus.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import blblblbl.cftfocus.history.domain.model.HistoryElement
import blblblbl.cftfocus.history.domain.usecase.GetHistoryUseCse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HistoryFragmentViewModel @Inject constructor(
    private val getHistoryUseCse: GetHistoryUseCse
):ViewModel() {
    lateinit var pagedHistory: Flow<PagingData<HistoryElement>>
    fun getHistory(){
        pagedHistory = getHistoryUseCse.execute(PAGE_SIZE).cachedIn(viewModelScope)
    }
    companion object {
        const val PAGE_SIZE:Int = 10
    }
}