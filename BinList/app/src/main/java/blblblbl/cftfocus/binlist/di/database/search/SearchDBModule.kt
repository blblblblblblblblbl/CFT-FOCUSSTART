package blblblbl.cftfocus.binlist.di.database.search

import blblblbl.cftfocus.binlist.di.database.DataBaseCreator
import blblblbl.cftfocus.database.model.BinInfo as DBBinInfo
import blblblbl.cftfocus.database.model.BinInfoEntity
import blblblbl.cftfocus.search.data.database.DatabaseSearch
import blblblbl.cftfocus.search.data.model.BinInfo as SearchBinInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class SearchDBModule{

    @Provides
    fun provideSearchDB(dbCreator: DataBaseCreator): DatabaseSearch =
        object :DatabaseSearch{
            val db = dbCreator.getDB()
            override suspend fun saveSearch(bin: String, info: SearchBinInfo) {
                val binInfo = info.mapToDB()?:DBBinInfo()
                val entity = BinInfoEntity(
                    bin = bin,
                    binInfo = binInfo
                )
                db.binDao().insert(entity)
            }
        }
}