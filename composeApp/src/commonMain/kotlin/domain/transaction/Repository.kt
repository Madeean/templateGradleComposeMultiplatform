package domain.transaction

import kotlinx.coroutines.flow.Flow
import utils.RequestState

interface Repository {
  suspend fun addTransaction(price: String): Flow<RequestState<String>>

}