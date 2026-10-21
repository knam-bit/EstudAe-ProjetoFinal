
package com.example.estudai.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.estudai.data.HorarioEstudo
import com.example.estudai.data.HorarioEstudoDao
import com.example.estudai.data.MateriaDao

private val diasDaSemana = listOf(
    "Segunda-feira",
    "Terça-feira",
    "Quarta-feira",
    "Quinta-feira",
    "Sexta-feira",
    "Sábado",
    "Domingo"
)

@Composable
fun TelaHorarios(
    materiaDao: MateriaDao,
    horarioDao: HorarioEstudoDao,
    aoInserir: (HorarioEstudo) -> Unit,
    aoAtualizar: (HorarioEstudo) -> Unit,
    aoExcluir: (HorarioEstudo) -> Unit
) {
    val materias by materiaDao.listarTodas()
        .collectAsState(initial = emptyList())

    val horarios by horarioDao.listarTodos()
        .collectAsState(initial = emptyList())

    var materiaSelecionada by remember { mutableStateOf("") }
    var diaSelecionado by remember { mutableStateOf("") }
    var horarioTexto by remember { mutableStateOf("") }

    var menuMateriasAberto by remember { mutableStateOf(false) }
    var menuDiasAberto by remember { mutableStateOf(false) }
    var horarioEmEdicao by remember {
        mutableStateOf<HorarioEstudo?>(null)
    }
    var erro by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Horários de estudo",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = "Cadastre e organize seus horários de estudo.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(Modifier.height(20.dp))

        Box(Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = materiaSelecionada,
                onValueChange = {},
                readOnly = true,
                enabled = materias.isNotEmpty(),
                label = { Text("Matéria") },
                placeholder = { Text("Selecione uma matéria") },
                trailingIcon = {
                    Text(if (menuMateriasAberto) "▲" else "▼")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable(enabled = materias.isNotEmpty()) {
                        menuMateriasAberto = true
                    }
            )

            DropdownMenu(
                expanded = menuMateriasAberto,
                onDismissRequest = { menuMateriasAberto = false }
            ) {
                materias.forEach { materia ->
                    DropdownMenuItem(
                        text = { Text(materia.nome) },
                        onClick = {
                            materiaSelecionada = materia.nome
                            menuMateriasAberto = false
                            erro = ""
                        }
                    )
                }
            }
        }

        if (materias.isEmpty()) {
            Text(
                text = "Cadastre uma matéria na aba Matérias antes de criar um horário.",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(Modifier.height(12.dp))

        Box(Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = diaSelecionado,
                onValueChange = {},
                readOnly = true,
                label = { Text("Dia da semana") },
                placeholder = { Text("Selecione o dia") },
                trailingIcon = {
                    Text(if (menuDiasAberto) "▲" else "▼")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable {
                        menuDiasAberto = true
                    }
            )

            DropdownMenu(
                expanded = menuDiasAberto,
                onDismissRequest = { menuDiasAberto = false }
            ) {
                diasDaSemana.forEach { dia ->
                    DropdownMenuItem(
                        text = { Text(dia) },
                        onClick = {
                            diaSelecionado = dia
                            menuDiasAberto = false
                            erro = ""
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = horarioTexto,
            onValueChange = {
                horarioTexto = it
                erro = ""
            },
            label = { Text("Horário") },
            placeholder = { Text("Ex.: 14:30") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = "Use o formato de 24 horas: 08:00, 14:30 ou 19:00.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        if (erro.isNotBlank()) {
            Spacer(Modifier.height(6.dp))
            Text(
                text = erro,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = {
                val horarioValido = Regex(
                    "^([01]\\d|2[0-3]):[0-5]\\d$"
                ).matches(horarioTexto.trim())

                when {
                    materiaSelecionada.isBlank() -> {
                        erro = if (materias.isEmpty()) {
                            "Cadastre uma matéria antes de continuar."
                        } else {
                            "Selecione uma matéria."
                        }
                    }

                    diaSelecionado.isBlank() -> {
                        erro = "Selecione o dia da semana."
                    }

                    horarioTexto.isBlank() -> {
                        erro = "Informe o horário de estudo."
                    }

                    !horarioValido -> {
                        erro = "Informe um horário válido, como 14:30."
                    }

                    else -> {
                        val registro = HorarioEstudo(
                            id = horarioEmEdicao?.id ?: 0,
                            materia = materiaSelecionada,
                            dia = diaSelecionado,
                            horario = horarioTexto.trim()
                        )

                        if (horarioEmEdicao == null) {
                            aoInserir(registro)
                        } else {
                            aoAtualizar(registro)
                        }

                        materiaSelecionada = ""
                        diaSelecionado = ""
                        horarioTexto = ""
                        horarioEmEdicao = null
                        erro = ""
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = materias.isNotEmpty()
        ) {
            Text(
                if (horarioEmEdicao == null) {
                    "Cadastrar horário"
                } else {
                    "Salvar alterações"
                }
            )
        }

        if (horarioEmEdicao != null) {
            TextButton(
                onClick = {
                    materiaSelecionada = ""
                    diaSelecionado = ""
                    horarioTexto = ""
                    horarioEmEdicao = null
                    erro = ""
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Cancelar edição")
            }
        }

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Meus horários (${horarios.size})",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(8.dp))

        if (horarios.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Nenhum horário cadastrado ainda.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    items = horarios,
                    key = { it.id }
                ) { item ->
                    Card(Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(14.dp)) {
                            Text(
                                text = item.materia,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(4.dp))

                            Text(
                                text = item.dia,
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = item.horario,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                TextButton(
                                    onClick = {
                                        horarioEmEdicao = item
                                        materiaSelecionada = item.materia
                                        diaSelecionado = item.dia
                                        horarioTexto = item.horario
                                        erro = ""
                                    }
                                ) {
                                    Text("Editar")
                                }

                                TextButton(
                                    onClick = {
                                        aoExcluir(item)

                                        if (horarioEmEdicao?.id == item.id) {
                                            materiaSelecionada = ""
                                            diaSelecionado = ""
                                            horarioTexto = ""
                                            horarioEmEdicao = null
                                            erro = ""
                                        }
                                    }
                                ) {
                                    Text(
                                        text = "Excluir",
                                        color = MaterialTheme.colorScheme.error
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
