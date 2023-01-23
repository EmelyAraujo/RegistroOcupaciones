package edu.ucne.registroocupaciones.ui.ocupaciones.ui

import androidx.compose.animation.expandVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text as Text

@Composable
fun OcupacionesScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Ocupaciones(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Ocupaciones(modifier: Modifier) {
    Column(modifier = Modifier) {
        Spacer(modifier = Modifier.padding(90.dp))
        Text(
            text = "Registro de ocupaciones",
            fontSize = 25.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(16.dp))
        DescripcionField()
        Spacer(modifier = Modifier.padding(16.dp))
        SalarioField()
        Spacer(modifier = Modifier.padding(4.dp))
        GuardarButton()
        Spacer(modifier = Modifier.padding(16.dp))
        MyRadioButtons()
    }
}

@Composable
fun GuardarButton() {

    ExtendedFloatingActionButton(onClick = { /* ... */ },
        modifier = Modifier
            .padding(110.dp, 4.dp, 16.dp, 0.dp)
            .height(48.dp),
        contentColor = Color.White,
        backgroundColor = Color(0xFF3F51B5),

        icon = {
            Icon(
                Icons.Filled.Done, contentDescription = "Guardar"
            )
        },
        text = { Text("Guardar") })

}


@Composable
fun DescripcionField() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Descripcion") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,

        )
}

@Composable
fun SalarioField() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Salario") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,

        )
}

@Composable
fun MyRadioButtons() {
    val opciones = listOf("Todos", "Hombres", "Mujeres")
    var seleccionado by remember { mutableStateOf("") }

    Row(verticalAlignment = Alignment.CenterVertically) {
        opciones.forEach { item ->
            RadioButton(
                selected = item == seleccionado,
                onClick = { seleccionado = item }
            )
            Text(text = item)
        }

    }

}