package com.example.estudai.ui

sealed interface UiState<out T> {

    // A tela está carregando os dados.
    data object Carregando : UiState<Nothing>

    // A busca terminou, mas não existem dados.
    data object Vazio : UiState<Nothing>

    // Aconteceu algum erro durante a busca.
    data class Erro(
        val mensagem: String
    ) : UiState<Nothing>

    // Os dados foram carregados com sucesso.
    data class Sucesso<T>(
        val itens: List<T>
    ) : UiState<T>
}
