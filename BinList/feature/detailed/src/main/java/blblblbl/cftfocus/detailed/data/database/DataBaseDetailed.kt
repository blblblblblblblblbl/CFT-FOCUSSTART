package blblblbl.cftfocus.detailed.data.database

import blblblbl.cftfocus.detailed.data.model.BinInfo


interface DataBaseDetailed {
    suspend fun getBinInfo(bin: String): BinInfo
}