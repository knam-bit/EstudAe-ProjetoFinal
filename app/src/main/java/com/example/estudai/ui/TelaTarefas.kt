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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.estudai.data.Tarefa
import com.example.estudai.data.TarefaDao
import kotlinx.coroutines.launch

@Composable
fun TelaTarefas(
    dao: TarefaDao,
    modifier: Modifier = Modifier
) {
    val tarefas by dao.listarTarefas().collectAsState(
        initial = emptyList()
    )

    val scope = rememberCoroutineScope()

    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var dataEntrega by remember { mutableStateOf("") }

    var tarefaExcluir by remember {
        mutableStateOf<Tarefa?>(null)
    }

    val concluidas = tarefas.count { it.concluida }
    val pendentes = tarefas.size - concluidas

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Minhas tarefas",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Total: ${tarefas.size} | " +
                    "Pendentes: $pendentes | Concluídas: $concluidas",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título da tarefa") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição (opcional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = dataEntrega,
            onValueChange = { dataEntrega = it },
            label = { Text("Data de entrega (DD/MM/AAAA)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (titulo.isNotBlank()) {
                    val novaTarefa = Tarefa(
                        titulo = titulo.trim(),
                        descricao = descricao.trim(),
                        dataEntrega = dataEntrega.trim(),
                        concluida = false
                    )

                    scope.launch {
                        dao.inserir(novaTarefa)
                    }

                    titulo = ""
                    descricao = ""
                    dataEntrega = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = titulo.isNotBlank()
        ) {
            Text("Cadastrar tarefa")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Lista de tarefas",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (tarefas.isEmpty()) {
            Text(
                text = "Nenhuma tarefa cadastrada ainda.",
                modifier = Modifier.padding(vertical = 16.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = tarefas,
                    key = { it.id }
                ) { tarefa ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = tarefa.concluida,
                                    onCheckedChange = { marcada ->
                                        scope.launch {
                                            dao.atualizar(
                                                tarefa.copy(
                                                    concluida = marcada
                                                )
                                            )
                                        }
                                    }
                                )

                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = tarefa.titulo,
                                        style = MaterialTheme.typography.titleMedium
                                    )

                                    if (tarefa.concluida) {
                                        Text(
                                            text = "Concluída",
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    } else {
                                        Text("Pendente")
                                    }
                                }
                            }

                            if (tarefa.descricao.isNotBlank()) {
                                Text(text = tarefa.descricao)
                            }

                            if (tarefa.dataEntrega.isNotBlank()) {
                                Text(
                                    text = "Entrega: ${tarefa.dataEntrega}"
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                OutlinedButton(
                                    onClick = {
                                        tarefaExcluir = tarefa
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

    tarefaExcluir?.let { tarefa ->
        AlertDialog(
            onDismissRequest = {
                tarefaExcluir = null
            },
            title = {
                Text("Excluir tarefa?")
            },
            text = {
                Text(
                    "Deseja excluir a tarefa \"${tarefa.titulo}\"?"
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        scope.launch {
                            dao.excluir(tarefa)
                        }
                        tarefaExcluir = null
                    }
                ) {
                    Text("Excluir")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        tarefaExcluir = null
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}