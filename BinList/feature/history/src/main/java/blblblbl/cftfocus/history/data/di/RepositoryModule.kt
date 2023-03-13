package blblblbl.cftfocus.history.data.di

import blblblbl.cftfocus.history.data.datasource.HistoryDataSource
import blblblbl.cftfocus.history.data.datasource.HistoryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun bindHistoryDataSource(searchDataSource: HistoryDataSourceImpl): HistoryDataSource
}