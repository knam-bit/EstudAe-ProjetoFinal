# Registro de Uso de IA — Estudae

Este registro é obrigatório. Cada vez que a equipe usar IA de forma relevante, anote uma linha na tabela.
As regras gerais estão em [`AGENTS.md`](../AGENTS.md).

## Ferramentas usadas

| Ferramenta | Para quê |
|---|---|
| Gemini (Android Studio / Agent Mode) | Ajuda na escrita e organização do código |
| _ChatGpt_ | |
|Claude ||

## Como a equipe usa a IA

- A IA ajuda a escrever código, mas **a equipe revisa, testa no celular e entende** tudo antes de aceitar.
- Pedimos tarefas pequenas, uma por vez.
- Cada bloco aceito vira um commit próprio.
- Nenhuma chave ou senha é enviada para a IA (ver `.aiexclude`).

## Registro

#
# Guia de Uso da IA — EstudAe

| Data | Integrante | O que pedimos à IA | O que a IA gerou | O que aceitamos / mudamos | Testado? | Commit |
|---|---|---|---|---|---|---|
| 07/10/2026 | Ketsoanny | Auxiliar na elaboração do PRD do EstudAe. | Apoio na organização dos requisitos e objetivos do aplicativo. | Elaborei e organizei o documento conforme a proposta do projeto. | Não se aplica | Não se aplica |
| 07/10/2026 | Ketsoanny | Auxiliar na elaboração do Canvas do projeto. | Apoio na estruturação das informações e do planejamento. | Organizei o Canvas conforme a proposta do EstudAe. | Não se aplica | Não se aplica |
| 07/10/2026 | Ketsoanny | Auxiliar na elaboração do README. | Sugestões de estrutura e descrição do aplicativo. | Elaborei e ajustei a documentação do projeto. | Não se aplica | Não se aplica |
| 07/10/2026 | Ketsoanny | Auxiliar na criação do AGENTS.md. | Apoio na organização das instruções do projeto. | Organizei o arquivo conforme as necessidades do repositório. | Não se aplica | Não se aplica |
| 07/10/2026 | Ketsoanny | Criar o projeto no Android Studio. | Orientações para configuração e organização inicial. | Criei o projeto e iniciei sua estrutura no Android Studio. | Sim | Verificar no Git |
| 07/10/2026 | Ketsoanny | Organizar os pacotes e a estrutura inicial do aplicativo. | Orientações para estruturar os componentes do projeto. | Iniciei a organização, mas parte do boilerplate permaneceu pendente. | Parcial | Verificar no Git |
| 07/10/2026 | Ketsoanny | Planejar a entidade de tarefas e horários. | Apoio na definição da estrutura de dados. | Desenvolvi a entidade, mas preciso confirmar o commit correspondente. | Verificar | Verificar no Git |
| 21/10/2026 | Ketsoanny | Configurar Room, Retrofit, Navigation, NavTarget e os pacotes do projeto. | Orientações e trechos de código para configurar a arquitetura. | A configuração do boilerplate não foi totalmente concluída. | Parcial | Verificar no Git |
| 21/10/2026 | iKALIMONY HELISSA MELO DA SILVA | Criar a tela de tarefas e horários. | Estrutura da interface em Kotlin para organizar tarefas e horários. | Desenvolvi e adaptei a tela de tarefas à estrutura do EstudAe. | Verificar | Verificar no Git |
| 21/10/2026 | Ketsoanny | Criar ou ajustar a entidade de tarefas e horários. | Estrutura de dados para representar tarefas e horários. | Desenvolvi a entidade, mas preciso confirmar se foi registrada em um commit. | Verificar | Verificar no Git |
| 21/10/2026 | iKALIMONY HELISSA MELO DA SILVA | Testar o aplicativo EstudAe. | Orientações para verificar o funcionamento das telas e identificar possíveis erros. | Fui responsável por testar o aplicativo, verificar seu funcionamento e identificar possíveis problemas. | Sim | Verificar no Git |
| 21/10/2026 | Ana Beatriz | Criar a entidade `Materia` com Room. | Classe `Materia.kt` com ID, nome, professor e descrição. | Aceitamos a estrutura da entidade. | Sim | Verificar no Git |
| 21/10/2026 | Ana Beatriz | Criar o DAO para gerenciar as matérias. | Classe `MateriaDao.kt` com operações para inserir, consultar e excluir. | Utilizamos as operações necessárias para gerenciar as matérias. | Sim | Verificar no Git |
| 21/10/2026 | Ana Beatriz | Configurar o banco de dados Room. | Classe `AppDatabase.kt` e configuração das dependências no Gradle. | Mantivemos a configuração compatível com o projeto. | Sim | Verificar no Git |
| 21/10/2026 | Ana Beatriz | Criar e integrar a tela de matérias. | Tela `TelaMaterias.kt` integrada ao `MainActivity.kt`. | Adaptamos o código à estrutura existente do aplicativo. | Sim | `f659125` |
| 21/10/2026 | Larissa Vitoria da Silva | Criar a tela inicial do EstudAe. | Arquivo `TelaInicial.kt` com a interface inicial do aplicativo. | Criamos um arquivo separado para organizar a tela inicial. | Verificar | Verificar no Git |
| 21/10/2026 | Larissa Vitoria da Silva | Organizar o `MainActivity.kt`. | Código para inicializar o aplicativo e organizar a exibição das telas. | Adaptamos a atividade principal para integrar as telas. | Verificar | Verificar no Git |
| 21/10/2026 | Larissa Vitoria da Silva | Separar as telas do aplicativo em arquivos Kotlin. | Arquivos `TelaRotina.kt` e `TelaTarefas.kt`. | Organizamos as telas separadamente para facilitar a manutenção. | Verificar | Verificar no Git |
| 21/10/2026 | Larissa Vitoria da Silva | Implementar a navegação entre as telas. | Estrutura de navegação entre Matérias, Rotina e Tarefas. | Adaptamos a navegação à organização do projeto. | Verificar | Verificar no Git |
| 21/10/2026 | Larissa Vitoria da Silva | Organizar e enviar as alterações do Android Studio para o GitHub. | Orientações e comandos Git para adicionar arquivos, criar commits e sincronizar a branch `main`. | Preparamos e enviamos alterações ao repositório remoto. | Verificar | Verificar no Git |
| 22/10/2026 | Larissa Vitoria da Silva | Verificar o estado das alterações e sincronizar o projeto com o GitHub. | Orientações para conferir o Git, atualizar as alterações remotas e enviar os commits. | Sincronizamos as alterações com o repositório remoto e confirmamos o envio pelo terminal. | Parcial | `25303ad` |
| 22/10/2026 | Larissa Vitoria

**Observação:** os commits das alterações de Larissa devem ser confirmados com `git log --oneline`. O teste de compilação e a integração final das telas devem ser marcados como concluídos somente após a verificação no Android Studio.

## O que aprendemos

_Preencham ao final (M6): o que a IA fez bem, onde errou, o que cada integrante aprendeu e conseguiria fazer sozinho._

## Mudança pequena feita sem IA (treino para 10/12)

| Integrante | O que mudou no app | Data |
|---|---|---|
| Larissa | | |
| Ana Beatriz | | |
| Ketsoanny | | |
| ikalimony | | |
