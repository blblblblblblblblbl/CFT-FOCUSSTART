package blblblbl.cftfocus.detailed.data.di

import blblblbl.cftfocus.detailed.data.datasource.DetailedDataSource
import blblblbl.cftfocus.detailed.data.datasource.DetailedDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun bindDetailedDataSource(dataSource: DetailedDataSourceImpl): DetailedDataSource
}