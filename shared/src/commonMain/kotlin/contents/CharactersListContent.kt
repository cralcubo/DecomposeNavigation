package contents

import Character
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import components.ListComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun CharactersListContent(
    listComponent: ListComponent,
) {
    LazyColumn {
        items(listComponent.elements) { character ->
            CharacterCard(character){ listComponent.onClickElement(character) }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CharacterCard(character: Character, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.clickable { onClick() }
    )
    {
        Image(
            painter = painterResource(res = character.img),
            contentDescription = character.name,
            contentScale = ContentScale.Inside,
            modifier = Modifier.height(150.dp).width(150.dp)
        )
        Text(character.name)
    }
}