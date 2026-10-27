
package com.example.estudai.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.weight
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.estudai.data.Materia
import com.example.estudai.data.MateriaDao

@Composable
fun TelaMaterias(
    dao: MateriaDao,
    aoInserir: (Materia) -> Unit,
    aoExcluir: (Materia) -> Unit,
    aoAtualizar: (Materia) -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var professor by remember { mutableStateOf("") }
    var erro by remember { mutableStateOf(false) }

    var materiaEditando by remember {
        mutableStateOf<Materia?>(null)
    }

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
                        val materiaAtual = materiaEditando

                        if (materiaAtual == null) {
                            aoInserir(
                                Materia(
                                    nome = nome.trim(),
                                    professor = professor.trim()
                                )
                            )
                        } else {
                            aoAtualizar(
                                materiaAtual.copy(
                                    nome = nome.trim(),
                                    professor = professor.trim()
                                )
                            )
                        }

                        nome = ""
                        professor = ""
                        erro = false
                        materiaEditando = null
                    } else {
                        erro = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    if (materiaEditando == null) {
                        "Cadastrar matéria"
                    } else {
                        "Salvar alterações"
                    }
                )
            }

            if (materiaEditando != null) {
                TextButton(
                    onClick = {
                        nome = ""
                        professor = ""
                        erro = false
                        materiaEditando = null
                    }
                ) {
                    Text("Cancelar edição")
                }
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
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp)
                            ) {
                                Text(
                                    text = materia.nome,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = "Professor: ${materia.professor}",
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    TextButton(
                                        onClick = {
                                            materiaEditando = materia
                                            nome = materia.nome
                                            professor = materia.professor
                                            erro = false
                                        }
                                    ) {
                                        Text("Editar")
                                    }

                                    TextButton(
                                        onClick = {
                                            aoExcluir(materia)

                                            if (materiaEditando?.id == materia.id) {
                                                materiaEditando = null
                                                nome = ""
                                                professor = ""
                                                erro = false
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
}
