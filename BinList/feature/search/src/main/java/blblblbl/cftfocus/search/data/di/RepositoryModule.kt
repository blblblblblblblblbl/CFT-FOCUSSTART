package blblblbl.cftfocus.search.data.di

import blblblbl.cftfocus.search.data.datasource.SearchDataSource
import blblblbl.cftfocus.search.data.datasource.SearchDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun bindSearchDataSource(searchDataSource: SearchDataSourceImpl): SearchDataSource
}