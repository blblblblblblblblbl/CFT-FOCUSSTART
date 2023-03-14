package blblblbl.cftfocus.detailed.domain.repository

import blblblbl.cftfocus.detailed.domain.model.BinInfo

interface RepositoryDetailed {
    suspend fun getBinInfo(bin:String):BinInfo
}