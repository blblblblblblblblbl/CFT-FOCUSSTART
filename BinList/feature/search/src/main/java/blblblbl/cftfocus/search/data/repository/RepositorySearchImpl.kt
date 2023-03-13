package blblblbl.cftfocus.search.data.repository

import blblblbl.cftfocus.search.data.database.DatabaseSearch
import blblblbl.cftfocus.search.data.datasource.SearchDataSource
import blblblbl.cftfocus.search.data.utils.mapToDomain
import blblblbl.cftfocus.search.domain.model.BinInfo
import blblblbl.cftfocus.search.domain.repository.RepositorySearch
import javax.inject.Inject

class RepositorySearchImpl @Inject constructor(
    private val dataSource: SearchDataSource,
    private val database:DatabaseSearch
):RepositorySearch {
    override suspend fun search(query: String): BinInfo? {
        val info = dataSource.searchBinInfo(query)
        database.saveSearch(query,info)
        return info.mapToDomain()
    }


}