import androidx.compose.ui.window.ComposeUIViewController
import com.mrfatworm.goodnightforest.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
