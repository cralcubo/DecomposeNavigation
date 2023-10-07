package components

import Character
import com.arkivanov.decompose.ComponentContext

class CharacterDetailsComponent(
    componentContext: ComponentContext,
    private val onFinished: () -> Unit,
    override val element: Character,
) : DetailsComponent, ComponentContext by componentContext {

    override fun onClickBack() {
        onFinished()
    }
}