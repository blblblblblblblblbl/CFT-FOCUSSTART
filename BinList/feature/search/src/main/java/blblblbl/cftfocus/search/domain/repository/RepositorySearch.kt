package blblblbl.cftfocus.search.domain.repository

import blblblbl.cftfocus.search.domain.model.BinInfo

interface RepositorySearch {
    suspend fun search(query:String):BinInfo?
}