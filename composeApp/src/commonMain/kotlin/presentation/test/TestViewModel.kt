package presentation.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.transaction.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import utils.RequestState

class TestViewModel(
  private val useCase: UseCase
) : ViewModel() {

  private val _addTransaction: MutableStateFlow<RequestState<String>> = MutableStateFlow(RequestState.Idle)
  val addTransaction: StateFlow<RequestState<String>> = _addTransaction

  suspend fun addTransaction(price: String) {
    viewModelScope.launch {
      useCase.addTransaction(price).collect {
        _addTransaction.value = it
      }
    }
  }
}