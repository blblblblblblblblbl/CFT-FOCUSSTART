package blblblbl.cftfocus.search.data.datasource

import blblblbl.cftfocus.search.data.network.SearchApi
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(
    private var searchApi: SearchApi
) :SearchDataSource {
    override suspend fun searchBinInfo(bin: String) =
        searchApi.searchBinInfo(bin)
}