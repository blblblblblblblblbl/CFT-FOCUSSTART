package blblblbl.cftfocus.binlist.di.database

import blblblbl.cftfocus.database.model.BinInfoEntity
import blblblbl.cftfocus.search.data.database.DatabaseSearch
import blblblbl.cftfocus.search.data.model.BinInfo
import blblblbl.cftfocus.search.data.network.SearchApi
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
            override suspend fun saveSearch(bin: String, info: BinInfo) {
                val entity = BinInfoEntity(
                    bin = bin,
                    binInfo = info.toString()
                )
                db.binDao().insert(entity)
            }
        }
}