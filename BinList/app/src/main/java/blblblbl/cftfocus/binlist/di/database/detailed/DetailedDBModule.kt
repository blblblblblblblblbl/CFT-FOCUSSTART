package blblblbl.cftfocus.binlist.di.database.detailed

import blblblbl.cftfocus.binlist.di.database.DataBaseCreator
import blblblbl.cftfocus.detailed.data.database.DataBaseDetailed
import blblblbl.cftfocus.detailed.data.model.BinInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DetailedDBModule {

    @Provides
    fun provideDetailedDB(dbCreator: DataBaseCreator): DataBaseDetailed =
        object : DataBaseDetailed {
            val db = dbCreator.getDB()

            override suspend fun getBinInfo(bin: String): BinInfo =
                db.binDao().getBinInfoByBin(bin).mapToDetailed() ?: BinInfo()

        }
}