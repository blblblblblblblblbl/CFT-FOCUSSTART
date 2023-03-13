package blblblbl.cftfocus.search.di

import blblblbl.cftfocus.search.data.repository.RepositorySearchImpl
import blblblbl.cftfocus.search.domain.repository.RepositorySearch
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindRepository(searchRepository: RepositorySearchImpl): RepositorySearch
}