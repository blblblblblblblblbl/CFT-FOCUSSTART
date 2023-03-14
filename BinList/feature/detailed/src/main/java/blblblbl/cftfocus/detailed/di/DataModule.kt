package blblblbl.cftfocus.detailed.di

import blblblbl.cftfocus.detailed.data.repository.RepositoryDetailedImpl
import blblblbl.cftfocus.detailed.domain.repository.RepositoryDetailed
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindRepository(searchRepository: RepositoryDetailedImpl): RepositoryDetailed
}