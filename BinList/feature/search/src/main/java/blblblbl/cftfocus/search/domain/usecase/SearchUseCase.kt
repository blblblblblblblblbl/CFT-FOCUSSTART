package blblblbl.cftfocus.search.domain.usecase

import blblblbl.cftfocus.search.domain.model.BinInfo
import blblblbl.cftfocus.search.domain.repository.RepositorySearch
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val repositorySearch: RepositorySearch
) {
    suspend fun execute(query:String):BinInfo? =
        repositorySearch.search(query)
}