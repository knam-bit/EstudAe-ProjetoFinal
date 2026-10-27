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
import androidx.lifecycle.lifecycleScope
import com.example.estudai.data.AppDatabase
import com.example.estudai.data.HorarioEstudoDao
import com.example.estudai.data.Materia
import com.example.estudai.data.MateriaDao
import com.example.estudai.data.TarefaDao
import com.example.estudai.ui.TelaMaterias
import com.example.estudai.ui.TelaRotina
import com.example.estudai.ui.TelaTarefas
import com.example.estudai.ui.theme.EstudaiTheme
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

        // Obtém o banco de dados
        val database = AppDatabase.getDatabase(applicationContext)

        // Obtém os DAOs
        val materiaDao = database.materiaDao()
        val horarioDao = database.horarioEstudoDao()
        val tarefaDao = database.tarefaDao()

        setContent {
            EstudaiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EstudaiApp(
                        dao = materiaDao,
                        horarioDao = horarioDao,
                        tarefaDao = tarefaDao,

                        aoInserirMateria = { materia ->
                            lifecycleScope.launch {
                                materiaDao.inserir(materia)
                            }
                        },

                        aoExcluirMateria = { materia ->
                            lifecycleScope.launch {
                                materiaDao.excluir(materia)
                            }
                        },
                        aoAtualizarMateria = { materia ->
                            lifecycleScope.launch {
                                materiaDao.atualizar(materia)
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
    horarioDao: HorarioEstudoDao,
    tarefaDao: TarefaDao,
    aoInserirMateria: (Materia) -> Unit,
    aoExcluirMateria: (Materia) -> Unit,
    aoAtualizarMateria: (Materia) -> Unit
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
                Tela.MATERIAS -> {
                    TelaMaterias(
                        dao = dao,
                        aoInserir = aoInserirMateria,
                        aoExcluir = aoExcluirMateria,
                        aoAtualizar = aoAtualizarMateria
                    )
                }

                Tela.ROTINA -> {
                    TelaRotina(
                        dao = horarioDao,
                        onVoltar = {
                            telaAtual = Tela.MATERIAS
                        }
                    )
                }

                Tela.TAREFAS -> {
                    TelaTarefas(
                        dao = tarefaDao
                    )
                }
            }