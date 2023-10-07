package components

import Character
import characters
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import components.Config.CharacterDetails
import components.Config.CharactersList
import components.RootComponent.Child.CharacterDetailsChild
import components.RootComponent.Child.CharacterListChild

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = CharactersList(characters()), // The initial child component is List
            handleBackButton = true, // Automatically pop from the stack on back button presses
            childFactory = ::childFactory
        )

    private fun childFactory(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when(config) {
            is CharactersList -> CharacterListChild(listComponent(componentContext, config.characters))
            is CharacterDetails -> CharacterDetailsChild(detailsComponent(componentContext, config.character))
        }

    private fun listComponent(componentContext: ComponentContext, characters: List<Character>) =
        CharactersListComponent(
            componentContext = componentContext,
            onItemSelected = { navigation.push(CharacterDetails(it)) },
            elements = characters
        )

    private fun detailsComponent(componentContext: ComponentContext, character: Character) =
        CharacterDetailsComponent(
            componentContext = componentContext,
            onFinished = navigation::pop,
            element = character
        )
}

private sealed interface Config : Parcelable {
    @Parcelize
    data class CharactersList(val characters: List<Character>) : Config
    @Parcelize
    data class CharacterDetails(val character: Character) : Config
}