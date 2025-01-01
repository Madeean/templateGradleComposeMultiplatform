package presentation.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun TestScreen(
  viewModel: TestViewModel
) {

  val state by viewModel.addTransaction.collectAsState()
  val coroutine = rememberCoroutineScope()

  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text("HASIL: $state")
    Button(onClick = {
      coroutine.launch {
        viewModel.addTransaction("200.000")
      }
    }) {
      Text("Add trx")
    }
  }
}