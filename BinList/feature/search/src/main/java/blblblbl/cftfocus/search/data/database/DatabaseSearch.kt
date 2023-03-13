package blblblbl.cftfocus.search.data.database

import blblblbl.cftfocus.search.data.model.BinInfo

interface DatabaseSearch {
    suspend fun saveSearch(bin:String,info:BinInfo)
}