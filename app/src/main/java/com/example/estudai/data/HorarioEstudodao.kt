
package com.example.estudai.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HorarioEstudoDao {

    @Query(
        """
        SELECT * FROM horarios_estudo
        ORDER BY
            CASE dia
                WHEN 'Segunda-feira' THEN 1
                WHEN 'Terça-feira' THEN 2
                WHEN 'Quarta-feira' THEN 3
                WHEN 'Quinta-feira' THEN 4
                WHEN 'Sexta-feira' THEN 5
                WHEN 'Sábado' THEN 6
                WHEN 'Domingo' THEN 7
                ELSE 8
            END,
            horario ASC
        """
    )
    fun listarTodos(): Flow<List<HorarioEstudo>>

    @Insert
    suspend fun inserir(horario: HorarioEstudo)

    @Update
    suspend fun atualizar(horario: HorarioEstudo)

    @Delete
    suspend fun excluir(horario: HorarioEstudo)
}


