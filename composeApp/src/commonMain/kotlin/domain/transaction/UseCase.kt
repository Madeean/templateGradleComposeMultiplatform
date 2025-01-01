package domain.transaction

import kotlinx.coroutines.flow.Flow
import utils.RequestState

interface UseCase {
  suspend fun addTransaction(price: String): Flow<RequestState<String>>
}