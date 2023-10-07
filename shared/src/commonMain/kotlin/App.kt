import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.DefaultComponentContext
import components.DefaultRootComponent
import contents.RootContent
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

@Composable
fun App() {
    val lifecycle = LifecycleRegistry()

    val root = DefaultRootComponent(componentContext = DefaultComponentContext(lifecycle))
    MaterialTheme {
        RootContent(root)
    }
}
