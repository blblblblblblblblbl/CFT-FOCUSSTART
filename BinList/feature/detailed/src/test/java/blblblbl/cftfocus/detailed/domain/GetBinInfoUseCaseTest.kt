package blblblbl.cftfocus.detailed.domain

import blblblbl.cftfocus.detailed.domain.model.BinInfo
import blblblbl.cftfocus.detailed.domain.repository.RepositoryDetailed
import blblblbl.cftfocus.detailed.domain.usecase.GetBinInfoUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.times

class GetBinInfoUseCaseTest {
    @Test
    fun repositoryUsageIsCorrect() {
        val repository = mock<RepositoryDetailed>()
        val useCase = GetBinInfoUseCase(repository)
        val bin:String = "gefwjhkl"
        val binCaptor = argumentCaptor<String>()
        val binInfo = BinInfo()
        val respose:BinInfo
        runBlocking {
            Mockito.`when`(repository.getBinInfo(bin)).thenReturn(binInfo)
            respose=useCase.execute(bin)
            Mockito.verify(repository, times(1)).getBinInfo(binCaptor.capture())
        }

        Assert.assertEquals( bin.hashCode(),binCaptor.firstValue.hashCode())
        Assert.assertEquals( respose.hashCode(),binInfo.hashCode())
    }
}