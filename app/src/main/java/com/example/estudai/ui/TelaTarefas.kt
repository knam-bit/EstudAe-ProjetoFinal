package com.example.estudai.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.estudai.data.HorarioEstudo
import com.example.estudai.data.HorarioEstudoDao
import kotlinx.coroutines.launch

annotation class TelaTarefas

@Composable
fun TelaRotina(
    dao: HorarioEstudoDao,
    modifier: Modifier = Modifier.Companion
) {
    val horarios by dao.listarTodos().collectAsState(
        initial = emptyList()
    )
    val scope = rememberCoroutineScope()
    var horarioExcluir by remember {
        mutableStateOf<HorarioEstudo?>(null)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Minha rotina de estudos",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.Companion.padding(4.dp))

        Text(
            text = "Horários cadastrados: ${horarios.size}",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.Companion.padding(8.dp))

        if (horarios.isEmpty()) {
            Text(
                text = "Nenhum horário cadastrado ainda.",
                modifier = Modifier.Companion.padding(vertical = 16.dp)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    items = horarios,
                    key = { it.id }
                ) { horario ->
                    Card(
                        modifier = Modifier.Companion.fillMaxWidth(),
                        colors = CardDefaults.cardColors()
                    ) {
                        Row(
                            modifier = Modifier.Companion
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.Companion.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.Companion.weight(1f)
                            ) {
                                Text(
                                    text = horario.materia,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(text = horario.dia)
                                Text(text = horario.horario)
                            }

                            OutlinedButton(
                                onClick = {
                                    horarioExcluir = horario
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

    horarioExcluir?.let { horario ->
        AlertDialog(
            onDismissRequest = {
                horarioExcluir = null
            },
            title = {
                Text("Excluir horário?")
            },
            text = {
                Text(
                    "Deseja remover o horário de ${horario.materia}?"
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        scope.launch {
                            dao.excluir(horario)
                            horarioExcluir = null
                        }
                    }
                ) {
                    Text("Excluir")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        horarioExcluir = null
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}