
package com.example.estudai.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materias")
data class Materia(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val professor: String,
    val descricao: String = ""
)