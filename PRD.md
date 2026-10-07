# 📄 PRD — Documento de Requisitos do Produto

|                         |                                                                            |
| ----------------------- | -------------------------------------------------------------------------- |
| **App**                 | Estudae                                                                    |
| **Grupo**               | 6                                                                          |
| **Autores**             | Ketsoanny Nathielly, Ana Beatriz Costa, Estefani Maria e Ikalimony Helissa |
| **Versão do documento** | 1.0                                                                        |
| **Última atualização**  | 30/09/2026                                                                 |
| **Status**              | ( ) Rascunho    ( ) Em revisão    ( ) Aprovado                             |

---

## 1. Visão do produto

**Pitch:**

> O **Estudae** ajuda estudantes a organizar seus horários, matérias e tarefas de estudo sem precisar usar anotações espalhadas ou vários aplicativos.

**Problema:**

Estudantes têm dificuldade para organizar o tempo entre diferentes matérias, atividades e provas. Horários e tarefas podem acabar esquecidos quando ficam anotados em diferentes lugares ou quando o estudante tenta memorizar tudo.

**Por que vale a pena fazer isso:**

O Estudae reúne a organização dos estudos em um único aplicativo, permitindo que o estudante consulte sua rotina, acompanhe seus horários e controle suas tarefas de maneira simples.

---

## 2. Público e cenário de uso

**Usuário-alvo:**

Estudantes, principalmente alunos do Ensino Médio, que precisam organizar melhor seus horários, matérias e tarefas de estudo.

**História de uso:**

> "São 19h, o estudante está em casa e precisa organizar os estudos do dia seguinte. Ele abre o Estudae, consulta sua rotina, adiciona um horário de estudo e registra uma tarefa que precisa realizar. Em menos de 1 minuto, ele consegue visualizar o que precisa estudar e quais tarefas estão pendentes."

---

## 3. Objetivos e não-objetivos

### Objetivos desta versão (v1.0)

1. Permitir que o estudante cadastre e organize suas matérias.
2. Permitir que o estudante registre horários de estudo e tarefas.
3. Permitir que o estudante visualize e acompanhe sua rotina de estudos.

### Não-objetivos

* ❌ Login ou cadastro de usuários.
* ❌ Notificações e alarmes.
* ❌ Sincronização com Google Agenda ou outros serviços.
* ❌ Inteligência artificial para criar automaticamente o cronograma.
* ❌ Sistema de mensagens entre usuários.

---

## 4. Requisitos funcionais

| ID       | História de usuário                                                                   | Critério de aceite                                                                                            | Prioridade |
| -------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ---------- |
| **RF01** | Como estudante, quero cadastrar matérias para organizar meus estudos.                 | Ao preencher o nome de uma matéria e confirmar, ela é salva e aparece na lista de matérias.                   | **Must**   |
| **RF02** | Como estudante, quero cadastrar horários de estudo para organizar minha rotina.       | Ao informar matéria, dia, horário inicial e horário final e confirmar, o horário é salvo e aparece na rotina. | **Must**   |
| **RF03** | Como estudante, quero cadastrar tarefas para saber o que preciso fazer.               | Ao informar a tarefa e a matéria relacionada e confirmar, a tarefa aparece como pendente.                     | **Must**   |
| **RF04** | Como estudante, quero marcar uma tarefa como concluída para acompanhar meu progresso. | Ao tocar na opção de conclusão, a tarefa muda de pendente para concluída visualmente.                         | **Must**   |
| **RF05** | Como estudante, quero visualizar minha rotina de estudos para saber o que devo fazer. | A tela principal apresenta os horários e tarefas cadastrados, indicando os itens pendentes e concluídos.      | **Should** |

> **Observação:** embora o modelo permita cinco requisitos, o MVP continua concentrado nas quatro funcionalidades definidas no Canvas: matérias, horários, tarefas e visualização da rotina.

---

## 5. Requisitos não funcionais

| ID        | Requisito                                                                                     | Como será verificado                                               |
| --------- | --------------------------------------------------------------------------------------------- | ------------------------------------------------------------------ |
| **RNF01** | O app não pode fechar sozinho durante o uso normal.                                           | 5 minutos de uso contínuo sem crash em 2 celulares diferentes.     |
| **RNF02** | Operações que possam gerar exceções devem ser tratadas adequadamente.                         | Revisão do código das operações de banco e entradas do usuário.    |
| **RNF03** | Uma falha não pode resultar em tela branca ou fechamento do aplicativo.                       | Realização dos testes de falha definidos na seção 11.              |
| **RNF04** | O aplicativo deve funcionar a partir do Android definido pelo projeto.                        | Instalação e execução em dispositivo real.                         |
| **RNF05** | Textos visíveis ao usuário devem ficar em `strings.xml`.                                      | Revisão do código.                                                 |
| **RNF06** | Os arquivos do projeto devem possuir comentários de fronteira conforme as regras do grupo.    | Revisão do código.                                                 |
| **RNF07** | Qualquer integrante deve conseguir localizar e realizar uma pequena alteração no projeto.     | Teste de mudança ao vivo.                                          |
| **RNF08** | Os dados cadastrados devem permanecer disponíveis após fechar e abrir novamente o aplicativo. | Fechar o app, abrir novamente e verificar os dados salvos no Room. |

---

## 6. Telas e navegação

### Mapa de navegação

```text
[Tela Principal]
      │
      ├── toca em "Matérias"
      │       └──> [Lista/Cadastro de Matérias]
      │
      ├── toca em "+"
      │       └──> [Cadastro de Horário/Tarefa]
      │
      └── toca em uma tarefa
              └──> [Detalhe/Conclusão da Tarefa]
```

### Telas

| Tela                    | O que mostra                                    | Ações disponíveis                           |
| ----------------------- | ----------------------------------------------- | ------------------------------------------- |
| **Principal**           | Próximos horários de estudo e tarefas pendentes | Visualizar rotina, adicionar horário/tarefa |
| **Matérias**            | Lista das matérias cadastradas                  | Adicionar matéria                           |
| **Cadastro de horário** | Campos de matéria, dia e horário                | Salvar horário                              |
| **Cadastro de tarefa**  | Nome da tarefa e matéria relacionada            | Salvar tarefa                               |
| **Tarefas**             | Tarefas pendentes e concluídas                  | Marcar como concluída                       |

### Estado vazio

Quando ainda não houver dados cadastrados, o aplicativo deverá apresentar uma mensagem explicativa, por exemplo:

> **"Você ainda não possui estudos cadastrados. Adicione seu primeiro horário para começar."**

**Rascunhos das telas:**

Os desenhos das telas serão adicionados posteriormente em:

```text
docs/telas/
```

Arquivos previstos:

```text
docs/telas/01-principal.png
docs/telas/02-materias.png
docs/telas/03-cadastro-horario.png
docs/telas/04-cadastro-tarefa.png
```

---

## 7. Dados

### Opção escolhida: Room

O Estudae utilizará o **Room Database** para armazenar os dados localmente no dispositivo.

### Entidades principais

#### `Subject`

Representa uma matéria cadastrada.

| Campo  | Tipo   | Obrigatório | Observação                 |
| ------ | ------ | ----------- | -------------------------- |
| `id`   | Long   | Sim         | Chave primária, autogerada |
| `name` | String | Sim         | Nome da matéria            |

#### `StudySchedule`

Representa um horário de estudo.

| Campo       | Tipo   | Obrigatório | Observação                 |
| ----------- | ------ | ----------- | -------------------------- |
| `id`        | Long   | Sim         | Chave primária, autogerada |
| `subjectId` | Long   | Sim         | Identifica a matéria       |
| `dayOfWeek` | String | Sim         | Dia da semana              |
| `startTime` | String | Sim         | Horário inicial            |
| `endTime`   | String | Sim         | Horário final              |

#### `StudyTask`

Representa uma tarefa de estudo.

| Campo         | Tipo    | Obrigatório | Observação                 |
| ------------- | ------- | ----------- | -------------------------- |
| `id`          | Long    | Sim         | Chave primária, autogerada |
| `subjectId`   | Long    | Sim         | Matéria relacionada        |
| `description` | String  | Sim         | Descrição da tarefa        |
| `completed`   | Boolean | Sim         | Indica se foi concluída    |

### Operações necessárias

**Matérias:**

* [x] Inserir
* [x] Listar

**Horários:**

* [x] Inserir
* [x] Listar
* [ ] Atualizar
* [ ] Excluir

**Tarefas:**

* [x] Inserir
* [x] Listar
* [x] Atualizar status
* [ ] Excluir

> Exclusão não será prioridade da versão inicial para manter o escopo controlado.

---

## 8. Arquitetura e tecnologias

| Item                         | Escolha                     |
| ---------------------------- | --------------------------- |
| **Linguagem**                | Kotlin                      |
| **Interface**                | Jetpack Compose             |
| **Design**                   | Material 3                  |
| **Navegação**                | Navigation Compose          |
| **Persistência**             | Room                        |
| **Processamento assíncrono** | Coroutines + Flow           |
| **Processador Room**         | KSP                         |
| **Rede**                     | Não utilizada na versão 1.0 |
| **Injeção de dependência**   | Não utilizada               |
| **minSdk / targetSdk**       | 24 / 36                     |

### Organização de pastas

```text
app/src/main/java/br/edu/ifpe/estudae/
├── data/
│   ├── local/
│   ├── remote/
│   └── repository/
│
├── model/
│
├── ui/
│   ├── theme/
│   ├── navigation/
│   └── features/
│
└── MainActivity.kt
```

### Tecnologias que não serão utilizadas

* Hilt
* Koin
* Retrofit
* API externa
* Firebase

Essas tecnologias ficam fora do escopo porque o projeto utilizará **Room como opção técnica**.

---

## 9. Tratamento de erros

| Situação de falha           | O que o app faz                                                 | Mensagem para o usuário                                |
| --------------------------- | --------------------------------------------------------------- | ------------------------------------------------------ |
| Lista vazia                 | Mantém a tela e apresenta estado vazio explicativo              | "Você ainda não possui itens cadastrados."             |
| Campo obrigatório em branco | Impede o salvamento e destaca o preenchimento necessário        | "Preencha todos os campos obrigatórios."               |
| Erro ao salvar no banco     | Mantém o usuário na tela e informa que o salvamento falhou      | "Não foi possível salvar. Tente novamente."            |
| Erro ao carregar dados      | Mantém a tela e informa que os dados não puderam ser carregados | "Não foi possível carregar os dados. Tente novamente." |
| Horário inválido            | Impede o cadastro do horário                                    | "Verifique os horários informados."                    |

> Como o Estudae não utiliza internet na versão 1.0, situações de API fora do ar ou falta de internet não se aplicam.

---

## 10. Identidade visual e publicação

| Item                          | Definição                          | Onde fica            |
| ----------------------------- | ---------------------------------- | -------------------- |
| **Nome do app**               | Estudae                            | `strings.xml`        |
| **Cor principal**             | `#6C63FF`                          | `Color.kt`           |
| **Cor secundária**            | `#EDE7F6`                          | `Color.kt`           |
| **Ícone 512×512**             | Livro aberto combinado com relógio | `loja/icone-512.png` |
| **applicationId**             | `br.edu.ifpe.estudae`              | `build.gradle.kts`   |
| **versionName / versionCode** | `1.0` / `1`                        | `build.gradle.kts`   |

### Material da loja

| Artefato                  | Limite        | Conteúdo                                          |
| ------------------------- | ------------- | ------------------------------------------------- |
| **Título**                | 30 caracteres | Estudae                                           |
| **Descrição curta**       | 80 caracteres | Organize seus estudos de forma simples e prática. |
| **Descrição completa**    | —             | Será escrita em `loja/descricao.md`               |
| **Imagem de destaque**    | 1024×500      | `loja/destaque-1024x500.png`                      |
| **Screenshots**           | Mín. 2        | `loja/screenshots/`                               |
| **Esboço de privacidade** | —             | `loja/privacidade.md`                             |
| **Arquivo `.aab`**        | —             | `loja/app-release.aab`                            |

### Privacidade

Na versão 1.0, os dados de estudo serão armazenados **localmente no dispositivo**.

O aplicativo não terá:

* conta de usuário;
* servidor próprio;
* API externa;
* envio de dados pessoais para serviços externos.

---

## 11. Plano de testes

| #      | O que testar                  | Passos                                      | Resultado esperado                                  | OK? |
| ------ | ----------------------------- | ------------------------------------------- | --------------------------------------------------- | --- |
| **T1** | Abrir o app pela primeira vez | Instalar e abrir                            | Tela principal aparece com estado vazio explicado   |     |
| **T2** | Cadastrar matéria             | Abrir matérias, preencher nome e salvar     | Matéria aparece na lista                            |     |
| **T3** | Cadastrar horário             | Selecionar matéria, dia e horários e salvar | Horário aparece na rotina                           |     |
| **T4** | Cadastrar tarefa              | Informar tarefa e matéria e salvar          | Tarefa aparece como pendente                        |     |
| **T5** | Concluir tarefa               | Tocar na opção de conclusão                 | Tarefa aparece como concluída                       |     |
| **T6** | Campo obrigatório vazio       | Tentar salvar sem preencher campo           | Mensagem de erro aparece e o app não fecha          |     |
| **T7** | Persistência                  | Cadastrar dados, fechar e abrir o app       | Dados continuam disponíveis                         |     |
| **T8** | Erro no banco                 | Simular uma falha durante uma operação      | Mensagem clara aparece e o app continua funcionando |     |
| **T9** | Teste com usuário externo     | Pessoa de fora usa sem explicação           | Consegue cadastrar e consultar um estudo            |     |

**Testado em:**

* Aparelho 1: ______________________________
* Android: _________________________________
* Aparelho 2: ______________________________
* Android: _________________________________

---

## 12. Cronograma

| Marco                                | Prazo     | Responsável                | Status       |
| ------------------------------------ | --------- | -------------------------- | ------------ |
| **M1 — Canvas + repositório**        | 16/09     | Grupo                      | Em andamento |
| **M2 — PRD aprovado + telas**        | 30/09     | Grupo                      | Em andamento |
| **M3 — Funcionalidade base**         | 21/10     | Ketsoanny + Ana            | Pendente     |
| **M4 — Dados e erros tratados**      | 11/11     | Ana + Estefani + Ikalimony | Pendente     |
| **M5 — Identidade + `.apk` testado** | 25/11     | Estefani + Ikalimony       | Pendente     |
| **M6 — `.aab` + loja + README**      | 02/12     | Ketsoanny + grupo          | Pendente     |
| **Entrega e apresentação**           | **10/12** | **Grupo**                  | Pendente     |

---

## 13. Riscos

| Risco                                       | Impacto | Plano B                                                                                     |
| ------------------------------------------- | ------- | ------------------------------------------------------------------------------------------- |
| Dificuldade na implementação do Room        | Alto    | Reduzir a quantidade de operações e manter apenas as funcionalidades essenciais             |
| Integrante ficar sem computador             | Médio   | Outro integrante auxilia na implementação e o responsável revisa a alteração posteriormente |
| Problemas na integração das funcionalidades | Alto    | Fazer commits pequenos e testar cada funcionalidade antes da integração                     |
| Falta de tempo para funcionalidades extras  | Médio   | Priorizar os requisitos classificados como Must                                             |
| Problemas no APK de release                 | Alto    | Gerar builds de teste durante os marcos M3, M4 e M5                                         |

---

## 14. Como vamos orientar a implementação com IA

A implementação poderá utilizar o **Gemini no Android Studio** como ferramenta de apoio.

A IA poderá auxiliar na escrita, explicação, correção e organização do código, mas as decisões sobre o projeto serão tomadas pelos integrantes.

### Recursos que vamos usar

* [x] Chat
* [x] Agent Mode
* [x] Explain Code
* [x] Ask Gemini no Logcat
* [x] Generate Unit Tests
* [ ] Transform UI

### Regras do `AGENTS.md`

1. A IA deve seguir o escopo definido no `CANVAS.md` e no `PRD.md`.
2. Nenhuma alteração deve ser aceita sem que o integrante responsável leia, teste e compreenda o código.
3. A IA não deve adicionar bibliotecas, funcionalidades ou mudanças de arquitetura sem autorização do grupo.

### Divisão do perímetro explicável

| Parte do código                       | Responsável         |
| ------------------------------------- | ------------------- |
| **Telas e navegação (`ui/`)**         | Ketsoanny Nathielly |
| **Dados e Room (`data/` e `model/`)** | Ana Beatriz Costa   |
| **Horários e integração da rotina**   | Estefani Maria      |
| **Tarefas, testes e documentação**    | Ikalimony Helissa   |

> Todos os integrantes devem compreender o projeto inteiro o suficiente para realizar pequenas alterações e explicar as decisões tomadas pelo grupo.

### Decisões tomadas contra sugestões da IA

* O grupo escolheu **Room**, em vez de uma API externa.
* O grupo decidiu não utilizar **Hilt ou Koin**.
* O grupo decidiu não implementar login, notificações ou sincronização em nuvem.
* O grupo decidiu manter apenas as funcionalidades essenciais para cumprir o prazo.

---

## 15. Histórico de versões deste documento

| Versão  | Data       | Autor   | O que mudou                               |
| ------- | ---------- | ------- | ----------------------------------------- |
| **1.0** | 30/09/2026 | Grupo 6 | Criação inicial do PRD a partir do Canvas |
