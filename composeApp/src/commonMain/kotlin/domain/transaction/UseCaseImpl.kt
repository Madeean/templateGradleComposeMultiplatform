package domain.transaction

import kotlinx.coroutines.flow.Flow
import utils.RequestState

class UseCaseImpl(private val repository: Repository) : UseCase  {
  override suspend fun addTransaction(price: String): Flow<RequestState<String>> {
    return repository.addTransaction(price)
  }

}