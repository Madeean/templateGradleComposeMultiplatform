import androidx.compose.ui.window.ComposeUIViewController
import sharedFunction.KoinInitializer

fun MainViewController() = ComposeUIViewController(
  configure = {
    KoinInitializer().init()
  }
) {
  App()
}