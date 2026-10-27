
package com.example.estudai.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow

@Dao
interface MateriaDao {

    @Insert
    suspend fun inserir(materia: Materia)

    @Query("SELECT * FROM materias ORDER BY nome ASC")
    fun listarTodas(): Flow<List<Materia>>

    @Update
    suspend fun atualizar(materia: Materia)

    @Delete
    suspend fun excluir(materia: Materia)
}
