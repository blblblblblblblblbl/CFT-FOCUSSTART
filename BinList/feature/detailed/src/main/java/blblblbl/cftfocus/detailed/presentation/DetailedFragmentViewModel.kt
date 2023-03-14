package blblblbl.cftfocus.detailed.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import blblblbl.cftfocus.detailed.domain.model.BinInfo
import blblblbl.cftfocus.detailed.domain.usecase.GetBinInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailedFragmentViewModel @Inject constructor(
    private val getBinInfoUseCase: GetBinInfoUseCase
) : ViewModel() {

    private val _binInfo = MutableStateFlow<BinInfo?>(null)
    val binInfo = _binInfo.asStateFlow()

    fun getInfo(bin: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _binInfo.value = getBinInfoUseCase.execute(bin)
        }
    }
}