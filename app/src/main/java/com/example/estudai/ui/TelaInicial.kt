
package com.example.estudai.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Bege = Color(0xFFF5F1E9)
private val Marrom = Color(0xFF514238)
private val Verde = Color(0xFF77856B)
private val Branco = Color(0xFFFFFEFC)
private val Cinza = Color(0xFF827B72)

@Composable
fun TelaInicial() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Bege)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        // CABEÇALHO

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "ESTUDAÊ",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 3.sp,
                    color = Marrom
                )

                Text(
                    text = "Seu espaço de aprendizado.",
                    fontSize = 12.sp,
                    color = Cinza
                )
            }

            Surface(
                shape = RoundedCornerShape(50),
                color = Verde
            ) {
                Text(
                    text = "✦",
                    color = Branco,
                    modifier = Modifier.padding(
                        horizontal = 15.dp,
                        vertical = 10.dp
                    ),
                    fontSize = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // BOAS-VINDAS

        Text(
            text = "Olá, estudante! 👋",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Marrom
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Que tal dar mais um passo em direção aos seus objetivos hoje?",
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
                    text = "SEU FUTURO COMEÇA AGORA",
                    fontSize = 10.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFD9CDBB)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Pequenos passos,\ngrandes conquistas.",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Branco,
                    lineHeight = 32.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Organize seu tempo, mantenha o foco e respeite seu ritmo.",
                    fontSize = 13.sp,
                    color = Color(0xFFE5DED4),
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "✦  Um dia de cada vez.",
                    color = Color(0xFFD5C5A9),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // SEÇÃO DE ORGANIZAÇÃO

        Text(
            text = "Organize seus estudos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Marrom
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Tudo o que você precisa em um só lugar.",
            fontSize = 13.sp,
            color = Cinza
        )

        Spacer(modifier = Modifier.height(16.dp))

        // MATÉRIAS

        Card(
            modifier = Modifier.fillMaxWidth(),
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
                Text(
                    text = "📚",
                    fontSize = 29.sp
                )

                Spacer(modifier = Modifier.width(15.dp))

                Column {
                    Text(
                        text = "Minhas matérias",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Marrom
                    )

                    Text(
                        text = "Organize suas disciplinas.",
                        fontSize = 12.sp,
                        color = Cinza
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ROTINA

        Card(
            modifier = Modifier.fillMaxWidth(),
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
                Text(
                    text = "🗓️",
                    fontSize = 29.sp
                )

                Spacer(modifier = Modifier.width(15.dp))

                Column {
                    Text(
                        text = "Minha rotina",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Marrom
                    )

                    Text(
                        text = "Planeje seus horários de estudo.",
                        fontSize = 12.sp,
                        color = Cinza
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // TAREFAS

        Card(
            modifier = Modifier.fillMaxWidth(),
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
                Text(
                    text = "✓",
                    fontSize = 29.sp,
                    color = Verde
                )

                Spacer(modifier = Modifier.width(15.dp))

                Column {
                    Text(
                        text = "Minhas tarefas",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Marrom
                    )

                    Text(
                        text = "Acompanhe suas atividades.",
                        fontSize = 12.sp,
                        color = Cinza
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(26.dp))

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
}
