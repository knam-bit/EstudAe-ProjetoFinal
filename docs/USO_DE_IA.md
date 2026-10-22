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

## Registro de Uso de Inteligência Artificial

#Guia de Uso da IA — EstudAe

Data	Integrante	O que pedimos à IA	O que a IA gerou	O que aceitamos / mudamos	Testado?	Commit
Anterior a 21/10/2026 (data exata a confirmar)	Ketsoanny	Auxiliar na elaboração do PRD do EstudAe.	Apoio textual para organizar os requisitos e objetivos do aplicativo.	Elaborei e organizei o documento conforme a proposta do projeto.	Não se aplica	Não se aplica
Anterior a 21/10/2026 (data exata a confirmar)	Ketsoanny	Auxiliar na organização do Canvas do projeto.	Apoio para estruturar as informações e os elementos do planejamento.	Organizei o Canvas de acordo com a proposta do EstudAe.	Não se aplica	Não se aplica
Anterior a 21/10/2026 (data exata a confirmar)	Ketsoanny	Auxiliar na documentação do projeto no README.	Sugestões de estrutura e descrição para apresentar o aplicativo.	Elaborei e ajustei a documentação do projeto.	Não se aplica	Não se aplica
Anterior a 21/10/2026 (data exata a confirmar)	Ketsoanny	Auxiliar na criação do AGENTS.md.	Apoio na estruturação das instruções e orientações do projeto.	Organizei o arquivo conforme as necessidades do repositório.	Não se aplica	Não se aplica
Anterior a 21/10/2026 (data exata a confirmar)	Ketsoanny	Criar a estrutura inicial do projeto no Android Studio.	Orientações para configuração inicial e organização do projeto.	Criei o projeto no Android Studio.	Sim, criação do projeto	Verificar no Git
Anterior a 21/10/2026 (data exata a confirmar)	Ketsoanny	Organizar a estrutura inicial de pacotes e componentes.	Orientações para estruturar os pacotes e preparar a arquitetura.	Iniciei a organização do projeto, mas parte do boilerplate permaneceu pendente.	Parcial	Verificar no Git
Anterior a 21/10/2026 (data exata a confirmar)	Ketsoanny	Planejar a entidade de tarefas e horários.	Apoio na definição da estrutura de dados necessária para representar tarefas e horários.	Desenvolvi a entidade, mas preciso confirmar o registro do commit.	Verificar	Verificar no Git
21/10/2026	Ketsoanny	Configurar o boilerplate com Room, Retrofit, Navigation, NavTarget e pacotes.	Orientações e trechos de código para configurar os componentes da arquitetura.	A configuração não foi totalmente concluída; os componentes pendentes precisam ser conferidos.	Parcial	Verificar no Git
21/10/2026	Ketsoanny	Criar e organizar a tela de tarefas e horários.	Estrutura de interface em Kotlin para apresentar e organizar tarefas e horários.	Desenvolvi e adaptei a tela à estrutura existente do EstudAe.	Verificar	Verificar no Git
21/10/2026	Ketsoanny	Criar ou ajustar a entidade de tarefas e horários.	Estrutura de dados para representar as informações das tarefas e dos horários.	Desenvolvi a entidade, mas preciso confirmar se foi registrada em um commit.	Verificar	Verificar no Git
21/10/2026	Ana Beatriz	Criar a entidade Materia com Room.	Classe Materia.kt com ID, nome, professor e descrição.	Aceitamos a estrutura da entidade.	Sim	Verificar no Git
21/10/2026	Ana Beatriz	Criar o DAO para gerenciar as matérias.	Classe MateriaDao.kt com operações para inserir, consultar e excluir.	Utilizamos as operações necessárias para gerenciar as matérias.	Sim	Verificar no Git
21/10/2026	Ana Beatriz	Configurar o banco de dados Room.	Classe AppDatabase.kt e configuração das dependências no Gradle.	Mantivemos a configuração compatível com o projeto.	Sim	Verificar no Git
21/10/2026	Ana Beatriz	Criar e integrar a tela de matérias.	Tela TelaMaterias.kt integrada ao MainActivity.kt.	Adaptamos o código à estrutura existente do aplicativo.	Sim	f659125
21/10/2026	Larissa Vitoria da Silva	Criar a tela inicial do EstudAe.	Arquivo TelaInicial.kt com a interface inicial do aplicativo.	Criamos um arquivo separado para organizar a tela inicial e facilitar a manutenção.	Verificar	Verificar no Git
21/10/2026	Larissa Vitoria da Silva	Organizar o MainActivity.kt.	Código para inicializar o aplicativo e organizar a exibição das telas.	Adaptamos a atividade principal para integrar as telas do projeto.	Verificar	Verificar no Git
21/10/2026	Larissa Vitoria da Silva	Separar as telas do aplicativo em arquivos Kotlin.	Arquivos independentes para TelaRotina.kt e TelaTarefas.kt.	Organizamos as telas separadamente para facilitar a leitura e a manutenção do código.	Verificar	Verificar no Git
21/10/2026	Larissa Vitoria da Silva	Implementar a navegação entre as telas.	Estrutura de navegação para alternar entre Matérias, Rotina e Tarefas.	Adaptamos a navegação à organização do projeto.	Verificar	Verificar no Git
21/10/2026	Larissa Vitoria da Silva	Organizar e enviar as alterações do Android Studio para o GitHub.	Comandos Git para adicionar arquivos, criar commits e sincronizar a branch main.	Preparamos as alterações locais para envio ao repositório remoto.	Verificar	Verificar no Git

**Observação:** os commits das alterações de Larissa devem ser confirmados com `git log --oneline`. O teste de compilação e a integração final das telas devem ser marcados como concluídos somente após a verificação no Android Studio.

## O que aprendemos

_Preencham ao final (M6): o que a IA fez bem, onde errou, o que cada integrante aprendeu e conseguiria fazer sozinho._

## Mudança pequena feita sem IA (treino para 10/12)

| Integrante | O que mudou no app | Data |
|---|---|---|
| Larissa | | |
| Ana Beatriz | | |
| Ketsoanny | | |
