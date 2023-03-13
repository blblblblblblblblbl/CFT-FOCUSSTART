package blblblbl.cftfocus.binlist.di.database.history

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import blblblbl.cftfocus.binlist.di.database.DataBaseCreator
import blblblbl.cftfocus.binlist.di.database.search.mapToSearch
import blblblbl.cftfocus.history.data.database.DatabaseHistory
import blblblbl.cftfocus.history.data.model.HistoryElement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


@Module
@InstallIn(SingletonComponent::class)
class HistoryDBModule{

    @Provides
    fun provideSearchDB(dbCreator: DataBaseCreator): DatabaseHistory =
        object : DatabaseHistory {
            val db = dbCreator.getDB()
            override fun getHistoryPagingDataFlow(pageSize: Int): Flow<PagingData<HistoryElement>> =
                Pager(
                    config = PagingConfig(pageSize = pageSize),
                    pagingSourceFactory = {db.binDao().getBinInfoPagingSource()}
                ).flow.map { pagingData->
                    pagingData.map { binInfoEntity->
                        HistoryElement(
                            query = binInfoEntity.bin,
                            binInfo = binInfoEntity.binInfo.mapToHistory()
                        )
                    }
                }

        }
}