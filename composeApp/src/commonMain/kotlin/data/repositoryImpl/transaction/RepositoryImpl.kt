package data.repositoryImpl.transaction

import data.local.transaction.TransactionDao
import data.local.transaction.TransactionLocalModel
import domain.transaction.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import utils.RequestState
import utils.RequestState.Error
import utils.RequestState.Loading
import utils.RequestState.Success

class RepositoryImpl(private val transactionDao: TransactionDao) : Repository {
  override suspend fun addTransaction(price: String): Flow<RequestState<String>> = flow {
    try {
      emit(Loading)
      withContext(Dispatchers.IO) {
        transactionDao.addTransaction(TransactionLocalModel(price = price))
      }
      emit(Success("Success"))
    } catch (e: Exception) {
      emit(Error(e))
    }
  }
}