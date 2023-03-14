package blblblbl.cftfocus.detailed.data.repository

import blblblbl.cftfocus.detailed.data.datasource.DetailedDataSource
import blblblbl.cftfocus.detailed.data.utils.mapToDomain
import blblblbl.cftfocus.detailed.domain.model.BinInfo
import blblblbl.cftfocus.detailed.domain.repository.RepositoryDetailed
import javax.inject.Inject

class RepositoryDetailedImpl @Inject constructor(
    private val dataSource: DetailedDataSource
) : RepositoryDetailed {
    override suspend fun getBinInfo(bin: String): BinInfo =
        dataSource.getBinInfo(bin).mapToDomain()?:BinInfo()
}