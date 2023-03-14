package blblblbl.cftfocus.detailed.data.datasource

import blblblbl.cftfocus.detailed.data.model.BinInfo


interface DetailedDataSource {
    suspend fun getBinInfo(bin: String): BinInfo
}