package com.example.estudai.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estudai.data.HorarioEstudo
import com.example.estudai.data.HorarioEstudoDao
import kotlinx.coroutines.launch

private val Bege = Color(0xFFF5F1E9)
private val Marrom = Color(0xFF514238)
private val Verde = Color(0xFF77856B)
private val Branco = Color(0xFFFFFEFC)
private val Cinza = Color(0xFF827B72)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaRotina(
    dao: HorarioEstudoDao,
    onVoltar: () -> Unit
) {
    val horarios by dao.listarTodos().collectAsState(
        initial = emptyList()
    )

    val scope = rememberCoroutineScope()

    var materia by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("Segunda-feira") }
    var horario by remember { mutableStateOf("") }

    Scaffold(
        containerColor = Bege,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "ESTUDAÊ",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 3.sp,
                            color = Marrom
                        )
                        Text(
                            text = "Minha rotina",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Marrom
                        )
                    }
                },
                navigationIcon = {
                    TextButton(onClick = onVoltar) {
                        Text(
                            text = "Voltar",
                            color = Verde
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Bege
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            // CABEÇALHO

            Text(
                text = "Organize seu tempo. ✦",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Marrom
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Planeje seus horários e construa uma rotina de estudos equilibrada.",
                fontSize = 13.sp,
                color = Cinza,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(22.dp))



            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Branco
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        text = "Novo horário",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Marrom
                    )

                    Text(
                        text = "Adicione um momento para estudar.",
                        fontSize = 12.sp,
                        color = Cinza
                    )

                    OutlinedTextField(
                        value = materia,
                        onValueChange = { materia = it },
                        label = { Text("Matéria") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    OutlinedTextField(
                        value = dia,
                        onValueChange = { dia = it },
                        label = { Text("Dia da semana") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    OutlinedTextField(
                        value = horario,
                        onValueChange = { horario = it },
                        label = { Text("Horário (ex.: 14:00)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    Button(
                        onClick = {
                            if (
                                materia.isNotBlank() &&
                                dia.isNotBlank() &&
                                horario.isNotBlank()
                            ) {
                                scope.launch {
                                    dao.inserir(
                                        HorarioEstudo(
                                            materia = materia.trim(),
                                            dia = dia.trim(),
                                            horario = horario.trim()
                                        )
                                    )

                                    materia = ""
                                    horario = ""
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        enabled = materia.isNotBlank() &&
                                dia.isNotBlank() &&
                                horario.isNotBlank(),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Verde
                        )
                    ) {
                        Text(
                            text = "Salvar horário  +",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // LISTA DE HORÁRIOS

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Minha programação",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = Marrom
                )

                Text(
                    text = "${horarios.size} horários",
                    fontSize = 12.sp,
                    color = Verde,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            if (horarios.isEmpty()) {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE7E9DE)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "✦",
                            fontSize = 30.sp,
                            color = Verde
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Sua rotina começa aqui!",
                            fontWeight = FontWeight.Bold,
                            color = Marrom
                        )

                        Text(
                            text = "Cadastre seu primeiro horário de estudo.",
                            fontSize = 12.sp,
                            color = Cinza
                        )
                    }
                }

            } else {

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(
                        items = horarios,
                        key = { it.id }
                    ) { item ->

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Branco
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Surface(
                                    shape = RoundedCornerShape(14.dp),
                                    color = Color(0xFFE7E9DE)
                                ) {
                                    Text(
                                        text = "◷",
                                        fontSize = 24.sp,
                                        color = Verde,
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

                                    Text(
                                        text = item.dia,
                                        fontSize = 12.sp,
                                        color = Cinza
                                    )

                                    Text(
                                        text = item.horario,
                                        fontSize = 13.sp,
                                        color = Verde,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                TextButton(
                                    onClick = {
                                        scope.launch {
                                            dao.excluir(item)
                                        }
                                    }
                                ) {
                                    Text(
                                        text = "Excluir",
                                        color = Color(0xFF9B6258),
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}