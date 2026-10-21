package com.example.estudai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.estudai.data.AppDatabase
import com.example.estudai.data.Materia
import com.example.estudai.ui.TelaMaterias
import com.example.estudai.ui.TelaRotina
import com.example.estudai.ui.TelaTarefas
import com.example.estudai.ui.theme.EstudaiTheme
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

private enum class Tela(
    val titulo: String,
    val simbolo: String
) {
    MATERIAS("Matérias", "📚"),
    ROTINA("Rotina", "🗓"),
    TAREFAS("Tarefas", "✓")
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = AppDatabase
            .getDatabase(applicationContext)
            .materiaDao()

        setContent {
            EstudaiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EstudaiApp(
                        dao = dao,
                        aoInserirMateria = { materia ->
                            lifecycleScope.launch {
                                dao.inserir(materia)
                            }
                        },
                        aoExcluirMateria = { materia ->
                            lifecycleScope.launch {
                                dao.excluir(materia)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EstudaiApp(
    dao: com.example.estudai.data.MateriaDao,
    aoInserirMateria: (Materia) -> Unit,
    aoExcluirMateria: (Materia) -> Unit
) {
    var telaAtual by remember {
        mutableStateOf(Tela.MATERIAS)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                Tela.values().forEach { tela ->
                    NavigationBarItem(
                        selected = telaAtual == tela,
                        onClick = {
                            telaAtual = tela
                        },
                        icon = {
                            Text(tela.simbolo)
                        },
                        label = {
                            Text(tela.titulo)
                        }
                    )
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (telaAtual) {
                Tela.MATERIAS -> TelaMaterias(
                    dao = dao,
                    aoInserir = aoInserirMateria,
                    aoExcluir = aoExcluirMateria
                )

                Tela.ROTINA -> TelaRotina()

                Tela.TAREFAS -> TelaTarefas()
            }
        }
    }
}

@Composable
fun TelaTarefas() {
    TODO("Not yet implemented")
}

@Composable
fun TelaRotina() {
    TODO("Not yet implemented")
}