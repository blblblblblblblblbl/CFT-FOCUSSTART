package blblblbl.cftfocus.search.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import blblblbl.cftfocus.search.domain.model.BinInfo
import blblblbl.cftfocus.search.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchFragmentViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
):ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchedBin = MutableStateFlow<BinInfo?>(null)
    val searchedBin = _searchedBin.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    fun errorMessageShown(){
        _errorMessage.value = null
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun search(query: String) {
        viewModelScope.launch {
            try {
                _searchedBin.value = searchUseCase.execute(query = query)
            }
            catch(e:Throwable) {
                _errorMessage.value = e.message
            }

        }
    }
    companion object{
        const val PAGE_SIZE:Int = 10
    }
}