package components

import Character
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface ListComponent {
    val elements: List<Character>
    fun onClickElement(character: Character)
}
interface DetailsComponent {
    val element: Character
    fun onClickBack()
}
interface RootComponent {
    val stack: Value<ChildStack<*, Child>>
    sealed class Child {
        class CharacterListChild(val listComponent: ListComponent) : Child()
        class CharacterDetailsChild(val detailsComponent: DetailsComponent) : Child()
    }
}

