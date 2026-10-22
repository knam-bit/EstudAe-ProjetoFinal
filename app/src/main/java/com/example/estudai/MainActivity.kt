
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.estudai.data.AppDatabase
import com.example.estudai.data.Materia
import com.example.estudai.data.MateriaDao
import com.example.estudai.ui.TelaMaterias
import com.example.estudai.ui.TelaRotina
import com.example.estudai.ui.theme.EstudaiTheme
import kotlinx.coroutines.launch
import com.example.estudai.ui.TelaTarefas

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

        val database = AppDatabase.getDatabase(applicationContext)
        val materiaDao = database.materiaDao()
        val horarioDao = database.horarioEstudoDao()

        setContent {
            EstudaiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EstudaiApp(
                        dao = materiaDao,
                        horarioDao = horarioDao,
                        aoInserirMateria = { materia ->
                            lifecycleScope.launch {
                                materiaDao.inserir(materia)
                            }
                        },
                        aoExcluirMateria = { materia ->
                            lifecycleScope.launch {
                                materiaDao.excluir(materia)
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
    dao: MateriaDao,
    horarioDao: com.example.estudai.data.HorarioEstudoDao,
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

                Tela.ROTINA -> TelaRotina(
                    dao = horarioDao,
                    onVoltar = {
                        telaAtual = Tela.MATERIAS
                    }
                )

                Tela.TAREFAS -> TelaTarefas()
            }
        }
    }
}

@Composable
fun TelaTarefas() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Tela de tarefas em desenvolvimento.",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
