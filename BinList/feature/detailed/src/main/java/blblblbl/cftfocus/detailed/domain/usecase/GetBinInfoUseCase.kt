package blblblbl.cftfocus.detailed.domain.usecase

import blblblbl.cftfocus.detailed.domain.model.BinInfo
import blblblbl.cftfocus.detailed.domain.repository.RepositoryDetailed
import javax.inject.Inject

class GetBinInfoUseCase @Inject constructor(
    private val repository: RepositoryDetailed
) {
    suspend fun execute(bin:String): BinInfo =
        repository.getBinInfo(bin)

}