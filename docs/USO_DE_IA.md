# Registro de Uso de IA — EstudAê

Este registro é obrigatório. Cada vez que a equipe usar IA de forma relevante, anote uma linha na tabela.

As regras gerais estão em [`AGENTS.md`](../AGENTS.md).

## Ferramentas usadas

| Ferramenta | Para quê |
|---|---|
| Gemini (Android Studio / Agent Mode) | Ajuda na escrita e organização do código |
| ChatGPT | Auxílio na criação, organização, explicação e correção de código do aplicativo |
| Claude | Ferramenta disponível para auxiliar no desenvolvimento, quando utilizada |

## Como a equipe usa a IA

- A IA ajuda a escrever código, mas **a equipe revisa, testa no celular e entende** tudo antes de aceitar.
- Pedimos tarefas pequenas, uma por vez.
- Cada bloco aceito vira um commit próprio.
- Nenhuma chave ou senha é enviada para a IA (ver `.aiexclude`).

## Registro

Data	Integrante	O que pedimos à IA	O que a IA gerou	O que aceitamos / mudamos	Testado?	Commit
07/10/2026	Ketsoanny	Auxiliar na elaboração do PRD do EstudAe.	Apoio na organização dos requisitos e objetivos do aplicativo.	Elaborei e organizei o documento conforme a proposta do projeto.	Não se aplica	Não se aplica
07/10/2026	Ketsoanny	Auxiliar na elaboração do Canvas do projeto.	Apoio na estruturação das informações e do planejamento.	Organizei o Canvas conforme a proposta do EstudAe.	Não se aplica	Não se aplica
07/10/2026	Ketsoanny	Auxiliar na elaboração do README.	Sugestões de estrutura e descrição do aplicativo.	Elaborei e ajustei a documentação do projeto.	Não se aplica	Não se aplica
07/10/2026	Ketsoanny	Auxiliar na criação do AGENTS.md.	Apoio na organização das instruções do projeto.	Organizei o arquivo conforme as necessidades do repositório.	Não se aplica	Não se aplica
07/10/2026	Ketsoanny	Criar o projeto no Android Studio.	Orientações para configuração e organização inicial.	Criei o projeto e iniciei sua estrutura no Android Studio.	Sim	Verificar no Git
07/10/2026	Ketsoanny	Organizar os pacotes e a estrutura inicial do aplicativo.	Orientações para estruturar os componentes do projeto.	Iniciei a organização, mas parte do boilerplate permaneceu pendente.	Parcial	Verificar no Git
07/10/2026	Ketsoanny	Planejar a entidade de tarefas e horários.	Apoio na definição da estrutura de dados.	Desenvolvi a entidade, mas preciso confirmar o commit correspondente.	Verificar	Verificar no Git
21/10/2026	Ketsoanny	Configurar Room, Retrofit, Navigation, NavTarget e os pacotes do projeto.	Orientações e trechos de código para configurar a arquitetura.	A configuração do boilerplate não foi totalmente concluída.	Parcial	Verificar no Git
21/10/2026	IKALIMONY HELISSA MELO DA SILVA	Criar a tela de tarefas e horários.	Estrutura da interface em Kotlin para organizar tarefas e horários.	Desenvolvi e adaptei a tela de tarefas à estrutura do EstudAe.	Verificar	Verificar no Git
21/10/2026	Ketsoanny	Criar ou ajustar a entidade de tarefas e horários.	Estrutura de dados para representar tarefas e horários.	Desenvolvi a entidade, mas preciso confirmar se foi registrada em um commit.	Verificar	Verificar no Git
21/10/2026	IKALIMONY HELISSA MELO DA SILVA	Testar o aplicativo EstudAe.	Orientações para verificar o funcionamento das telas e identificar possíveis erros.	Fui responsável por testar o aplicativo, verificar seu funcionamento e identificar possíveis problemas.	Sim	Verificar no Git
21/10/2026	Ana Beatriz	Criar a entidade Materia com Room.	Classe Materia.kt com ID, nome, professor e descrição.	Aceitamos a estrutura da entidade para armazenar as matérias.	Sim	Verificar no Git
21/10/2026	Ana Beatriz	Criar o DAO para gerenciar as matérias.	Classe MateriaDao.kt com operações para inserir, consultar, atualizar e excluir matérias.	Utilizamos as operações necessárias para gerenciar as matérias no banco de dados.	Sim	Verificar no Git
21/10/2026	Ana Beatriz	Configurar o banco de dados Room.	Classe AppDatabase.kt e configuração das dependências no Gradle.	Mantivemos a configuração compatível com a estrutura do aplicativo.	Sim	Verificar no Git
21/10/2026	Ana Beatriz	Criar e integrar a tela de matérias.	Tela TelaMaterias.kt integrada ao MainActivity.kt.	Adaptamos a tela à estrutura existente do aplicativo.	Sim	f659125
21/10/2026	Larissa Vitoria da Silva	Criar a tela inicial do EstudAe.	Arquivo TelaInicial.kt com a interface inicial do aplicativo.	Criamos um arquivo separado para organizar a tela inicial.	Verificar	Verificar no Git
21/10/2026	Larissa Vitoria da Silva	Organizar o MainActivity.kt.	Código para inicializar o aplicativo e organizar a exibição das telas.	Adaptamos a atividade principal para integrar as telas.	Verificar	Verificar no Git
21/10/2026	Larissa Vitoria da Silva	Separar as telas do aplicativo em arquivos Kotlin.	Arquivos TelaRotina.kt e TelaTarefas.kt.	Organizamos as telas separadamente para facilitar a manutenção.	Verificar	Verificar no Git
21/10/2026	Larissa Vitoria da Silva	Implementar a navegação entre as telas.	Estrutura de navegação entre Matérias, Rotina e Tarefas.	Adaptamos a navegação à organização do projeto.	Verificar	Verificar no Git
21/10/2026	Larissa Vitoria da Silva	Organizar e enviar as alterações do Android Studio para o GitHub.	Orientações e comandos Git para adicionar arquivos, criar commits e sincronizar a branch main.	Preparamos e enviamos alterações ao repositório remoto.	Verificar	Verificar no Git
22/10/2026	Larissa Vitoria da Silva	Verificar o estado das alterações e sincronizar o projeto com o GitHub.	Orientações para conferir o Git, atualizar as alterações remotas e enviar os commits.	Sincronizamos as alterações com o repositório remoto e confirmamos o envio pelo terminal.	Parcial	25303ad
22/10/2026	Larissa Vitoria da Silva	Revisar a organização das telas e a navegação do EstudAe.	Orientações para verificar MainActivity.kt, TelaInicial.kt, TelaRotina.kt e TelaTarefas.kt.	Identificamos a necessidade de confirmar se as telas de rotina e tarefas estão implementadas e se os arquivos duplicados foram removidos.	Pendente	Verificar no Git
22/10/2026	Larissa Vitoria da Silva	Atualizar o registro de uso de IA do projeto.	Sugestões para documentar as atividades realizadas, os resultados e os testes pendentes.	Organizamos os registros das atividades e identificamos o que ainda precisa ser validado.	Parcial	Verificar no Git
27/10/2026	Ana Beatriz	Implementar a edição de matérias.	Inclusão da opção de editar uma matéria, alterar os campos e salvar as modificações.	Integramos a atualização dos dados ao DAO e à tela de matérias.	Sim	d18e693
27/10/2026	Ana Beatriz	Integrar a atualização de matérias ao MainActivity.kt.	Encaminhamento da função de atualização para o DAO utilizando lifecycleScope e corrotinas.	Adaptamos a atividade principal para permitir a atualização das matérias no banco de dados.	Sim	d18e693
27/10/2026	Ana Beatriz	Resolver conflito de integração entre as alterações locais e as atualizações do GitHub.	Orientações para revisar o conflito no MainActivity.kt durante o rebase da branch main.	Mantivemos a integração das telas de Matérias, Rotina e Tarefas e a função de atualização de matérias.	Parcial	Rebase em andamento; confirmar no Git
27/10/2026	IKALIMONY HELISSA MELO DA SILVA	Criar e organizar a tela inicial do EstudAe.	Auxílio na criação da TelaInicial.kt com imagem de capa, mensagem de boas-vindas e opções para Matérias, Horários, Tarefas e Rotina.	Desenvolvemos e organizamos a interface inicial conforme a estrutura do projeto.	Parcial	Verificar no Git
27/10/2026	IKALIMONY HELISSA MELO DA SILVA	Adicionar a imagem de capa do EstudAe.	Orientações para adicionar a imagem na pasta res/drawable e utilizá-la na TelaInicial.kt.	Adicionamos a imagem de capa e corrigimos o nome do arquivo para capa_estudae.png.	Parcial	Verificar no Git
27/10/2026	IKALIMONY HELISSA MELO DA SILVA	Corrigir a TelaInicial.kt para evitar erros de compilação.	Revisão do código, correção de imports e substituição dos ícones por componentes mais simples.	Ajustamos o código da tela inicial para facilitar a compilação e integração com o projeto.	Parcial	Verificar no Git
27/10/2026	IKALIMONY HELISSA MELO DA SILVA	Criar uma tela de Rotinas funcional para o EstudAe.	Orientações e estrutura de código para implementar a tela de Rotinas de acordo com a organização do projeto.	Adaptamos a tela de Rotinas para funcionar com a estrutura existente do aplicativo.	Verificar	Verificar no Git
27/10/2026	Ana Beatriz	Atualizar o registro de uso de IA do projeto.	Organização das atividades realizadas, resultados obtidos e decisões tomadas durante o desenvolvimento.	Registramos as tarefas realizadas com auxílio de IA e mantivemos os commits para conferência.	Sim	Verificar no Git
27/10/2026	Ketsoanny	Conferir a integração da função de tarefas com a branch principal do EstudAe.	Orientações para verificar o histórico de commits, o estado do repositório e a integração do Pull Request.	Confirmamos que o commit a52bf4a, referente à integração da tela de tarefas ao Room, está no histórico e que o Pull Request nº 1 foi integrado à main.	Sim	a52bf4a e 6800b7d
27/10/2026	Ketsoanny	Verificar o estado atual do repositório Git e identificar alterações pendentes.	Orientações para utilizar git status, git log e git diff.	Confirmamos que a branch main está sincronizada com origin/main. Identificamos uma alteração local em .idea/misc.xml, que não foi incluída em um novo commit.	Sim	Não se aplica
27/10/2026	Ketsoanny	Conferir a estrutura dos arquivos Kotlin do aplicativo.	Orientações para listar os arquivos e identificar as entidades, os DAOs, as telas e a atividade principal.	Identificamos os arquivos de matérias, horários, tarefas, rotina, tela inicial e banco de dados.	Sim	Não se aplica
27/10/2026	Ketsoanny	Revisar a configuração do banco de dados Room.	Análise do arquivo AppDatabase.kt, incluindo as entidades registradas, os DAOs e as migrações entre as versões do banco.	Confirmamos a presença das entidades Materia, HorarioEstudo e Tarefa, além dos respectivos acessos aos DAOs. Identificamos a necessidade de verificar a compatibilidade das migrações com o histórico do banco.	Parcial	Não se aplica
27/10/2026	Ketsoanny	Revisar a entidade Tarefa.kt e o TarefaDao.kt.	Análise dos campos da entidade e das operações de inserção, consulta, atualização e exclusão.	Confirmamos que a estrutura contempla o título, a descrição, a data de entrega e o estado de conclusão das tarefas, além das operações necessárias para gerenciá-las.	Sim	a52bf4a
27/10/2026	Ketsoanny	Verificar a configuração do Retrofit no projeto.	Orientações para procurar interfaces de API, anotações de requisição e configuração da URL-base.	Confirmamos que as dependências do Retrofit e do conversor Gson estão declaradas no Gradle. A implementação e a utilização de uma interface de API ainda precisam ser confirmadas.	Parcial	Não se aplica
27/10/2026	Ketsoanny	Identificar os erros de compilação em MainActivity.kt e TelaInicial.kt.	Análise da captura do Android Studio, que apresentou quatro erros de compilação, incluindo três parâmetros inexistentes na chamada de TelaInicial().	Identificamos uma incompatibilidade entre os parâmetros utilizados na chamada da tela inicial e sua implementação. Foi proposta a criação de uma tela inicial com botões para Matérias, Horários, Tarefas e Rotina. A correção ainda precisava ser aplicada e testada.	Não	Verificar no Git
27/10/2026	Ketsoanny	Criar uma interface inicial funcional para o EstudAe.	Proposta de código para TelaInicial.kt utilizando Jetpack Compose, com o nome do aplicativo, uma mensagem de boas-vindas e botões para acessar as funcionalidades.	A proposta foi apresentada para corrigir a incompatibilidade dos parâmetros e estruturar a tela inicial. A aplicação e a compilação do código ainda precisavam ser confirmadas.	Não	Verificar no Git
27/10/2026	Ketsoanny	Identificar as próximas etapas necessárias para a conclusão do EstudAe.	Checklist para conferir as funcionalidades de matérias, horários, tarefas, rotina, navegação, Retrofit e documentação.	Organizamos as próximas verificações para evitar duplicação de trabalho e identificar as pendências reais antes da entrega final.	Parcial	Não se aplica
28/10/2026	Larissa Vitoria da Silva	Corrigir e finalizar as telas de Rotina, Tarefas e Tela Inicial do EstudAe, revisar a organização dos pacotes e registrar o uso de IA.	Orientações para integrar a tela de Rotina ao HorarioEstudoDao, corrigir a implementação da TelaTarefas, remover a declaração indevida annotation class TelaTarefas, organizar os pacotes e implementar a TelaInicial.	Corrigimos e organizamos os arquivos do projeto, ajustamos a integração da tela de Rotina com o HorarioEstudoDao, corrigimos a utilização do TarefaDao na tela de Tarefas, removemos a declaração indevida annotation class TelaTarefas, implementamos a TelaInicial e registramos o uso de IA.	Sim	Verificar no Git

## O que aprendemos

_Preencham ao final (M6): o que a IA fez bem, onde errou, o que cada integrante aprendeu e conseguiria fazer sozinho._

## Mudança pequena feita sem IA (treino para 10/12)

| Integrante | O que mudou no app | Data |
|---|---|---|
| Larissa | | |
| Ana Beatriz | | |
| Ketsoanny | | |
| ikalimony | | |
