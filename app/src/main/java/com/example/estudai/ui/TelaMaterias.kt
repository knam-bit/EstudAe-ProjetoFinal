package com.example.estudai.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        modifier = Modifier.Companion.fillMaxSize()
    ) { padding ->

        Column(
            modifier = Modifier.Companion
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

            Spacer(modifier = Modifier.Companion.height(20.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = {
                    nome = it
                    erro = false
                },
                label = { Text("Nome da matéria") },
                modifier = Modifier.Companion.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.Companion.height(10.dp))

            OutlinedTextField(
                value = professor,
                onValueChange = {
                    professor = it
                    erro = false
                },
                label = { Text("Nome do professor") },
                modifier = Modifier.Companion.fillMaxWidth(),
                singleLine = true
            )

            if (erro) {
                Text(
                    text = "Preencha o nome da matéria e do professor.",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.Companion.height(12.dp))

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
                modifier = Modifier.Companion.fillMaxWidth()
            ) {
                Text("Cadastrar matéria")
            }

            Spacer(modifier = Modifier.Companion.height(24.dp))

            Text(
                text = "Minhas matérias (${materias.size})",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.Companion.height(8.dp))

            if (materias.isEmpty()) {
                Text(
                    text = "Nenhuma matéria cadastrada ainda.",
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                LazyColumn(
                    modifier = Modifier.Companion.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = materias,
                        key = { it.id }
                    ) { materia ->
                        Card(
                            modifier = Modifier.Companion.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.Companion
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement =
                                    Arrangement.SpaceBetween
                            ) {
                                Column(
                                    modifier = Modifier.Companion.weight(1f)
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