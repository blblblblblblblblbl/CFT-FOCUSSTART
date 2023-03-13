package blblblbl.cftfocus.search.data.datasource

import blblblbl.cftfocus.search.data.model.BinInfo

interface SearchDataSource {
    suspend fun searchBinInfo(bin:String):BinInfo
}