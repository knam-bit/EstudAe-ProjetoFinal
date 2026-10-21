
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class Tarefa(
    val id: Long,
    val descricao: String,
    val concluida: Boolean = false
)

@Composable
fun TelaTarefasScreen() {
    var descricao by remember {
        mutableStateOf("")
    }

    val tarefas = remember {
        mutableStateListOf<Tarefa>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Minhas tarefas ✓",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Organize suas atividades e acompanhe seu progresso."
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Nova tarefa") },
            placeholder = {
                Text("Ex.: Fazer exercícios de História")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                val texto = descricao.trim()

                if (texto.isNotEmpty()) {
                    tarefas.add(
                        Tarefa(
                            id = System.nanoTime(),
                            descricao = texto
                        )
                    )
                    descricao = ""
                }
            },
            enabled = descricao.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar tarefa")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Progresso: ${tarefas.count { it.concluida }} de ${tarefas.size}",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (tarefas.isEmpty()) {
            Text(
                text = "Nenhuma tarefa cadastrada. Adicione uma acima!"
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = tarefas,
                    key = { tarefa -> tarefa.id }
                ) { tarefa ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier.weight(1f)
                            ) {
                                Checkbox(
                                    checked = tarefa.concluida,
                                    onCheckedChange = { marcada ->
                                        val indice = tarefas.indexOfFirst {
                                            it.id == tarefa.id
                                        }

                                        if (indice >= 0) {
                                            tarefas[indice] = tarefa.copy(
                                                concluida = marcada
                                            )
                                        }
                                    }
                                )

                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(
                                            start = 4.dp,
                                            top = 12.dp
                                        )
                                ) {
                                    Text(
                                        text = tarefa.descricao,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = if (tarefa.concluida) {
                                            MaterialTheme.colorScheme.onSurfaceVariant
                                        } else {
                                            MaterialTheme.colorScheme.onSurface
                                        }
                                    )

                                    if (tarefa.concluida) {
                                        Text(
                                            text = "Concluída ✓",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                }
                            }

                            TextButton(
                                onClick = {
                                    tarefas.removeAll {
                                        it.id == tarefa.id
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
