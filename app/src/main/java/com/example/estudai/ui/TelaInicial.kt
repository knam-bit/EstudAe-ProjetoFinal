package com.example.estudai.ui

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaInicial() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Bem-vindo ao EstudAe!")
        Text(text = "Organize seus estudos e acompanhe sua rotina.")
    }
}