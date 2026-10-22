package com.example.estudai.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.estudai.data.HorarioEstudo
import com.example.estudai.data.HorarioEstudoDao
import kotlinx.coroutines.launch

annotation class TelaRotina

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaRotina(
    dao: HorarioEstudoDao,
    onVoltar: () -> Unit
) {
    val horarios by dao.listarTodos().collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()

    var materia by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("Segunda-feira") }
    var horario by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Minha rotina") },
                navigationIcon = {
                    TextButton(onClick = onVoltar) {
                        Text("Voltar")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.Companion
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = materia,
                onValueChange = { materia = it },
                label = { Text("Matéria") },
                modifier = Modifier.Companion.fillMaxWidth()
            )

            OutlinedTextField(
                value = dia,
                onValueChange = { dia = it },
                label = { Text("Dia da semana") },
                modifier = Modifier.Companion.fillMaxWidth()
            )

            OutlinedTextField(
                value = horario,
                onValueChange = { horario = it },
                label = { Text("Horário (ex.: 14:00)") },
                modifier = Modifier.Companion.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (
                        materia.isNotBlank() &&
                        dia.isNotBlank() &&
                        horario.isNotBlank()
                    ) {
                        scope.launch {
                            dao.inserir(
                                HorarioEstudo(
                                    materia = materia.trim(),
                                    dia = dia.trim(),
                                    horario = horario.trim()
                                )
                            )
                            materia = ""
                            horario = ""
                        }
                    }
                },
                modifier = Modifier.Companion.fillMaxWidth()
            ) {
                Text("Salvar horário")
            }

            Text(
                text = "Horários cadastrados",
                style = MaterialTheme.typography.titleMedium
            )

            if (horarios.isEmpty()) {
                Text("Nenhum horário cadastrado.")
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(horarios, key = { it.id }) { item ->
                        Card(
                            modifier = Modifier.Companion.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.Companion.padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = item.materia,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text("Dia: ${item.dia}")
                                Text("Horário: ${item.horario}")

                                TextButton(
                                    onClick = {
                                        scope.launch {
                                            dao.excluir(item)
                                        }
                                    }
                                ) {
                                    Text("Excluir")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}