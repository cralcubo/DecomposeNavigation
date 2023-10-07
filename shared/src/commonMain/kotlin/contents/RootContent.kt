package contents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import characters
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import components.RootComponent
import components.RootComponent.Child.CharacterDetailsChild
import components.RootComponent.Child.CharacterListChild

@Composable
fun RootContent(rootComponent: RootComponent) {
    Children(
        stack = rootComponent.stack,
        modifier = Modifier.fillMaxSize(),
        animation = stackAnimation(fade() + scale())
    ) {
        when( val instance = it.instance ){
            is CharacterListChild -> CharactersListContent(instance.listComponent)
            is CharacterDetailsChild -> CharacterDetailsContent(instance.detailsComponent)
        }

    }



}