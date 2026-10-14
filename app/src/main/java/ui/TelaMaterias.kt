package com.example.estudai.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.estudai.data.Materia
import com.example.estudai.data.MateriaDao

@Composable
fun TelaMaterias(
    dao: MateriaDao,
    aoInserir: (Materia) -> Unit,
    aoExcluir: (Materia) -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var professor by remember { mutableStateOf("") }
    var erro by remember { mutableStateOf(false) }

    val materias by dao.listarTodas()
        .collectAsState(initial = emptyList())

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "Matérias",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Cadastre e organize suas disciplinas.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = {
                    nome = it
                    erro = false
                },
                label = { Text("Nome da matéria") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = professor,
                onValueChange = {
                    professor = it
                    erro = false
                },
                label = { Text("Nome do professor") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            if (erro) {
                Text(
                    text = "Preencha o nome da matéria e do professor.",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    if (nome.isNotBlank() && professor.isNotBlank()) {
                        aoInserir(
                            Materia(
                                nome = nome.trim(),
                                professor = professor.trim()
                            )
                        )
                        nome = ""
                        professor = ""
                        erro = false
                    } else {
                        erro = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cadastrar matéria")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Minhas matérias (${materias.size})",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (materias.isEmpty()) {
                Text(
                    text = "Nenhuma matéria cadastrada ainda.",
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = materias,
                        key = { it.id }
                    ) { materia ->
                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement =
                                    Arrangement.SpaceBetween
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = materia.nome,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Text(
                                        text = "Professor: ${materia.professor}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }

                                TextButton(
                                    onClick = {
                                        aoExcluir(materia)
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

