package blblblbl.cftfocus.binlist.di.api

import blblblbl.cftfocus.search.data.network.SearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SearchRetrofitModule{

    @Provides
    fun provideSearchApi(retrofitCreator: RetrofitCreator): SearchApi =
        retrofitCreator.createRetrofit().create(SearchApi::class.java)
}