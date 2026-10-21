
package com.example.estudai.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horarios_estudo")
data class HorarioEstudo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val materia: String,
    val dia: String,
    val horario: String
)


