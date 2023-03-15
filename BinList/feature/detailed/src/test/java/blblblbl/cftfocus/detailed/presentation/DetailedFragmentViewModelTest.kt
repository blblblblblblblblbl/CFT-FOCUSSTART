package blblblbl.cftfocus.detailed.presentation

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import blblblbl.cftfocus.detailed.domain.model.BinInfo
import blblblbl.cftfocus.detailed.domain.usecase.GetBinInfoUseCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class DetailedFragmentViewModelTest {
    val getBinInfoUseCase = mock<GetBinInfoUseCase>()
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    lateinit var viewModel: DetailedFragmentViewModel
    @After
    fun afterEach(){
        Mockito.reset(getBinInfoUseCase)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }
    @Before
    fun beforeEach(){
        viewModel = DetailedFragmentViewModel(getBinInfoUseCase)
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor(){
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }
        })
    }
    @Test
    fun getBinInfo(){
        val bin:String = "gefwjhkl"
        val binCaptor = argumentCaptor<String>()
        val binInfo = BinInfo()
        val respose: BinInfo
        runBlocking {
            Mockito.`when`(getBinInfoUseCase.execute(bin)).thenReturn(binInfo)
            getBinInfoUseCase.execute(bin)
            verify(getBinInfoUseCase, times(1)).execute(binCaptor.capture())
            Assert.assertEquals(bin.hashCode(),binCaptor.firstValue.hashCode())
            Assert.assertEquals(binInfo.hashCode(),viewModel.binInfo.value.hashCode())
        }

    }
}