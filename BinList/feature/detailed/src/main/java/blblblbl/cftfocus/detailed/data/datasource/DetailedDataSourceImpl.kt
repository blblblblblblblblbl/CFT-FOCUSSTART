package blblblbl.cftfocus.detailed.data.datasource

import blblblbl.cftfocus.detailed.data.database.DataBaseDetailed
import blblblbl.cftfocus.detailed.data.model.BinInfo
import javax.inject.Inject

class DetailedDataSourceImpl @Inject constructor(
    private val dataBase: DataBaseDetailed
):DetailedDataSource {
    override suspend fun getBinInfo(bin: String): BinInfo =
        dataBase.getBinInfo(bin)
}