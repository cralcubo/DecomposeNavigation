package components

import Character
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class CharactersListComponent(
    componentContext: ComponentContext,
    private val onItemSelected: (Character) -> Unit,
    override val elements: List<Character>,
) : ListComponent, ComponentContext by componentContext {


    override fun onClickElement(character: Character) {
        onItemSelected(character)
    }

}