
package com.example.estudai.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estudai.data.HorarioEstudo
import com.example.estudai.data.HorarioEstudoDao
import kotlinx.coroutines.launch

// CORES DO ESTUDAÊ

private val Bege = Color(0xFFF5F1E9)
private val Marrom = Color(0xFF514238)
private val Verde = Color(0xFF77856B)
private val Branco = Color(0xFFFFFEFC)
private val Cinza = Color(0xFF827B72)

@Composable
fun TelaRotina(
    dao: HorarioEstudoDao,
    modifier: Modifier = Modifier
) {

    val horarios by dao.listarTodos()
        .collectAsState(initial = emptyList())

    val scope = rememberCoroutineScope()

    var materia by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var horario by remember { mutableStateOf("") }

    var horarioExcluir by remember {
        mutableStateOf<HorarioEstudo?>(null)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Bege)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        // CABEÇALHO

        Text(
            text = "ESTUDAÊ",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 3.sp,
            color = Marrom
        )

        Text(
            text = "Organize seu tempo de aprendizado.",
            fontSize = 12.sp,
            color = Cinza
        )

        Spacer(modifier = Modifier.height(28.dp))

        // TÍTULO

        Text(
            text = "Minha rotina 🗓️",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Marrom
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Planeje seus horários e mantenha o foco nos estudos.",
            fontSize = 14.sp,
            color = Cinza,
            lineHeight = 21.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // CARD PRINCIPAL

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Marrom
            )
        ) {
            Column(
                modifier = Modifier.padding(22.dp)
            ) {

                Text(
                    text = "SUA ORGANIZAÇÃO COMEÇA AQUI",
                    fontSize = 10.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFD9CDBB)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Um horário de cada vez.",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Branco
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Organize sua rotina, distribua suas matérias e conquiste seus objetivos.",
                    fontSize = 13.sp,
                    color = Color(0xFFE5DED4),
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "✦  Seu progresso começa com planejamento.",
                    color = Color(0xFFD5C5A9),
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // CADASTRO DE HORÁRIOS

        Text(
            text = "Adicionar horário",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Marrom
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Preencha as informações do seu estudo.",
            fontSize = 13.sp,
            color = Cinza
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = materia,
            onValueChange = { materia = it },
            label = { Text("Matéria") },
            placeholder = { Text("Ex.: Matemática") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Verde,
                focusedLabelColor = Verde,
                cursorColor = Verde
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = dia,
            onValueChange = { dia = it },
            label = { Text("Dia da semana") },
            placeholder = { Text("Ex.: Segunda-feira") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Verde,
                focusedLabelColor = Verde,
                cursorColor = Verde
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = horario,
            onValueChange = { horario = it },
            label = { Text("Horário de estudo") },
            placeholder = { Text("Ex.: 14:00 às 15:00") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Verde,
                focusedLabelColor = Verde,
                cursorColor = Verde
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // BOTÃO CADASTRAR

        Button(
            onClick = {

                if (
                    materia.isNotBlank() &&
                    dia.isNotBlank() &&
                    horario.isNotBlank()
                ) {

                    val novoHorario = HorarioEstudo(
                        materia = materia.trim(),
                        dia = dia.trim(),
                        horario = horario.trim()
                    )

                    scope.launch {
                        dao.inserir(novoHorario)
                    }

                    materia = ""
                    dia = ""
                    horario = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            enabled = materia.isNotBlank() &&
                    dia.isNotBlank() &&
                    horario.isNotBlank(),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Marrom,
                contentColor = Branco
            )
        ) {
            Text(
                text = "Adicionar à rotina",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // LISTA DE HORÁRIOS

        Text(
            text = "Meus horários",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Marrom
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "${horarios.size} horário(s) cadastrado(s)",
            fontSize = 13.sp,
            color = Cinza
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (horarios.isEmpty()) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Branco
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "🗓️",
                        fontSize = 32.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Sua rotina está vazia!",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Marrom
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Adicione seus horários para começar a organizar seus estudos.",
                        fontSize = 13.sp,
                        color = Cinza
                    )
                }
            }

        } else {

            // EXIBIÇÃO DOS HORÁRIOS

            horarios.forEach { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Branco
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = Color(0xFFE7E9DE)
                        ) {
                            Text(
                                text = "📚",
                                fontSize = 23.sp,
                                modifier = Modifier.padding(12.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = item.materia,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Marrom
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = item.dia,
                                fontSize = 13.sp,
                                color = Verde
                            )

                            Text(
                                text = item.horario,
                                fontSize = 12.sp,
                                color = Cinza
                            )
                        }

                        TextButton(
                            onClick = {
                                horarioExcluir = item
                            }
                        ) {
                            Text(
                                text = "Excluir",
                                color = Color(0xFF9B5148),
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // FRASE FINAL

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            color = Color(0xFFE7E9DE)
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "✦",
                    fontSize = 22.sp,
                    color = Verde
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Você não precisa fazer tudo hoje.",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Marrom
                )

                Text(
                    text = "Só precisa continuar.",
                    fontSize = 13.sp,
                    color = Cinza
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }

    // DIÁLOGO DE EXCLUSÃO

    horarioExcluir?.let { item ->

        AlertDialog(
            onDismissRequest = {
                horarioExcluir = null
            },
            containerColor = Bege,
            title = {
                Text(
                    text = "Excluir horário?",
                    color = Marrom,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = "Deseja excluir o horário de ${item.materia}?",
                    color = Cinza
                )
            },
            confirmButton = {

                TextButton(
                    onClick = {

                        scope.launch {
                            dao.excluir(item)
                        }

                        horarioExcluir = null
                    }
                ) {
                    Text(
                        text = "Excluir",
                        color = Color(0xFF9B5148)
                    )
                }
            },
            dismissButton = {

                TextButton(
                    onClick = {
                        horarioExcluir = null
                    }
                ) {
                    Text(
                        text = "Cancelar",
                        color = Marrom
                    )
                }
            }
        )
    }
}
