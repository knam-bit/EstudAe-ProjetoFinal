
package com.example.estudai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.estudai.data.AppDatabase
import com.example.estudai.data.Materia
import com.example.estudai.ui.theme.EstudaiTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = AppDatabase.getDatabase(applicationContext).materiaDao()

        setContent {
            EstudaiTheme {
                TelaMaterias(
                    dao = dao,
                    aoInserir = { materia ->
                        lifecycleScope.launch {
                            dao.inserir(materia)
                        }
                    },
                    aoExcluir = { materia ->
                        lifecycleScope.launch {
                            dao.excluir(materia)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun TelaMaterias(
    dao: com.example.estudai.data.MateriaDao,
    aoInserir: (Materia) -> Unit,
    aoExcluir: (Materia) -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var professor by remember { mutableStateOf("") }

    val materias by dao.listarTodas().collectAsState(initial = emptyList())

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
                text = "Matérias do Estudai",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome da matéria") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = professor,
                onValueChange = { professor = it },
                label = { Text("Nome do professor") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

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
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar matéria")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Matérias cadastradas",
                style = MaterialTheme.typography.titleMedium
            )

            LazyColumn {
                items(materias, key = { it.id }) { materia ->
                    ListItem(
                        headlineContent = { Text(materia.nome) },
                        supportingContent = { Text("Professor: ${materia.professor}") },
                        trailingContent = {
                            TextButton(onClick = { aoExcluir(materia) }) {
                                Text("Excluir")
                            }
                        }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}