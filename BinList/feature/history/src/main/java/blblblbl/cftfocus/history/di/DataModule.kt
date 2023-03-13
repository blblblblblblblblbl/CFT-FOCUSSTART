package blblblbl.cftfocus.history.di

import blblblbl.cftfocus.history.data.repository.RepositoryHistoryImpl
import blblblbl.cftfocus.history.domain.repository.RepositoryHistory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindRepository(searchRepository: RepositoryHistoryImpl): RepositoryHistory
}