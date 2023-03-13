package blblblbl.cftfocus.search.data.network

import blblblbl.cftfocus.search.data.model.BinInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchApi {
    @GET("{bin}")
    suspend fun searchBinInfo(
        @Path("bin") bin: String
    ): BinInfo
}