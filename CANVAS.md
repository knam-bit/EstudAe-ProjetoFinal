# 🎯 Canvas do Projeto Final — App Android

> **Projeto:** Estudae
> **Turma:** 3º ano — Ensino Médio
> **Grupo:** 6
> **Data de preenchimento:** 30/09/2026
> **Entrega final:** 10/12/2026

---

## 🧩 Bloco 1 — Nome e pitch do app

**Nome do app:** Estudae

**Pitch em uma frase:**

> "O **Estudae** ajuda estudantes a organizar seus horários, matérias e tarefas de estudo sem precisar usar anotações espalhadas ou vários aplicativos."

---

## 😖 Bloco 2 — Problema

* Estudantes têm dificuldade para organizar o tempo entre diferentes matérias, atividades e provas.
* Horários e tarefas podem ser esquecidos quando ficam anotados em lugares diferentes.

**Como esse problema é resolvido hoje (sem o app)?**

* Os estudantes utilizam cadernos, agendas, aplicativos de notas ou tentam memorizar seus horários e tarefas.

---

## 👥 Bloco 3 — Público-alvo

* **Perfil principal:** estudantes, principalmente alunos do Ensino Médio, que precisam organizar sua rotina de estudos.
* **Quando/onde usam:** em casa, na escola ou em qualquer momento em que precisem planejar ou consultar seus estudos.
* **Uma pessoa real que testaria o app:** um estudante de fora do grupo, convidado posteriormente para testar o `.apk`.

---

## 💡 Bloco 4 — Solução em uma tela

* **A tela principal lista:** os próximos horários de estudo e as tarefas pendentes.
* **A ação principal do usuário é:** adicionar um horário de estudo ou uma tarefa.
* **Depois de agir, o usuário vê:** o novo item organizado na sua rotina de estudos.

---

## ✅ Bloco 5 — Funcionalidades do MVP

| #  | Funcionalidade                 | Essencial? | Responsável principal   |
| -- | ------------------------------ | ---------- | ----------------------- |
| F1 | Cadastrar matérias             | Sim        | **Ana Beatriz Costa**   |
| F2 | Cadastrar horários de estudo   | Sim        | **Estefani Maria**      |
| F3 | Cadastrar e concluir tarefas   | Sim        | **Ikalimony Helissa**   |
| F4 | Visualizar a rotina de estudos | Sim        | **Ketsoanny Nathielly** |

> **Importante:** o responsável principal coordena e explica aquela parte, mas **todos os integrantes programam e revisam o projeto**.

---

## 🚫 Bloco 6 — Fora do escopo

Para manter o projeto dentro do prazo, o Estudae **não terá nesta versão**:

* ❌ Login ou cadastro de usuários.
* ❌ Notificações e alarmes.
* ❌ Sincronização com Google Agenda ou outros serviços.
* ❌ Inteligência artificial para criar automaticamente o cronograma.
* ❌ Sistema de mensagens ou interação entre usuários.

---

## ⚙️ Bloco 7 — Caminho técnico

### Tecnologia escolhida

* [x] **Opção A — Room:** dados salvos no próprio celular.
* [ ] **Opção B — Retrofit**
* [ ] **Opção C — Desafio**

### Por que Room?

O Estudae precisa armazenar localmente as matérias, horários e tarefas do estudante. O Room permite que esses dados continuem disponíveis no aplicativo depois que ele for fechado.

### Bibliotecas utilizadas

* **Kotlin**
* **Jetpack Compose**
* **Material 3**
* **Navigation Compose**
* **Room**
* **KSP**
* **Kotlin Coroutines**
* **Flow**

### Tratamento de erros

**Pode falhar:**

* Salvamento ou leitura de informações no banco de dados.
* Tentativa de salvar um formulário com campos obrigatórios vazios.

**O usuário vê a mensagem:**

> "Não foi possível salvar. Verifique os dados e tente novamente."

---

## 🎨 Bloco 8 — Identidade visual

| Item                             | Definição do grupo                                                                 |
| -------------------------------- | ---------------------------------------------------------------------------------- |
| **Nome exibido (`strings.xml`)** | Estudae                                                                            |
| **Cor principal (`Color.kt`)**   | `#6C63FF`                                                                          |
| **Ideia do ícone**               | Livro aberto combinado com um relógio, representando estudo e organização do tempo |
| **`applicationId`**              | `br.edu.ifpe.estudae`                                                              |
| **Versão inicial**               | `1.0` (`versionCode 1`)                                                            |

### Identidade

A identidade visual será **jovem, simples e organizada**, utilizando elementos relacionados a estudo, planejamento e tempo.

---

## 👤 Bloco 9 — Equipe, papéis e riscos

### Divisão da equipe

| Integrante              | Papel principal              | Responsável por                                         |
| ----------------------- | ---------------------------- | ------------------------------------------------------- |
| **Ketsoanny Nathielly** | Dev / telas                  | Interface em Compose, navegação e integração das telas  |
| **Ana Beatriz Costa**   | Dev / dados                  | Estrutura de matérias e parte da persistência com Room  |
| **Estefani Maria**      | Dev / funcionalidades        | Horários de estudo e integração com a rotina            |
| **Ikalimony Helissa**   | Dev / tarefas e documentação | Tarefas, conclusão de atividades e apoio à documentação |

> **Todos programam.** A divisão define quem acompanha e responde principalmente por cada parte, não quem trabalha sozinho.

### Riscos e planos B

| Risco                                | Plano B                                                                                   |
| ------------------------------------ | ----------------------------------------------------------------------------------------- |
| Dificuldade na implementação do Room | Reduzir a quantidade de dados e priorizar as funcionalidades essenciais                   |
| Integração das partes causar erros   | Fazer commits pequenos, testar cada funcionalidade e revisar o código antes da integração |
| Alguma funcionalidade ficar atrasada | Priorizar as F1–F4 e retirar qualquer funcionalidade extra                                |
| Problemas no build ou APK            | Manter versões estáveis e testar o projeto a cada marco                                   |

---

## 🤖 Bloco 10 — Acordo de trabalho com IA

A implementação poderá utilizar o **Gemini no Android Studio**, mas os integrantes serão responsáveis por compreender, revisar e testar o código gerado.

### Três regras do nosso `AGENTS.md`

1. **A IA deve seguir o escopo definido no `CANVAS.md` e no `PRD.md` e não criar funcionalidades não aprovadas pelo grupo.**
2. **Nenhum código gerado pela IA será aceito sem que o integrante responsável leia, teste e compreenda a alteração.**
3. **A IA não deve adicionar bibliotecas, modificar a arquitetura ou alterar tecnologias do projeto sem autorização do grupo.**

### Combinados do grupo

* [x] Ninguém clica *Accept* no Agent Mode sem ler a mudança inteira.
* [x] Quem aceitou o código escreve o comentário de fronteira do arquivo.
* [x] Antes de cada marco, revisamos juntos: alguém aqui não entende alguma parte?
* [x] Nenhuma chave de API ou senha vai para o prompt.
* [x] Cada integrante deve testar sua alteração antes do commit.
* [x] Cada integrante deve saber explicar as partes do código pelas quais ficou responsável.

### Como vamos garantir que todos entendem tudo

O integrante responsável por cada funcionalidade deverá apresentar a implementação aos demais integrantes, explicando o funcionamento antes da integração. Os outros integrantes poderão revisar o código e fazer perguntas antes do commit ou merge.

---

## 🗓️ Bloco 11 — Marcos até 10/12

| Marco                                                  | Prazo     | Como se comprova no GitHub                          |
| ------------------------------------------------------ | --------- | --------------------------------------------------- |
| **M1 — Canvas preenchido + repositório criado**        | 16/09     | `CANVAS.md` no `main`                               |
| **M2 — PRD aprovado + telas rascunhadas**              | 30/09     | `PRD.md` + imagens em `docs/`                       |
| **M3 — Funcionalidade base rodando**                   | 21/10     | Tela principal lista dados + 1 ação + `try/catch`   |
| **M4 — Dados completos com Room e erros tratados**     | 11/11     | Commits da camada de dados                          |
| **M5 — Identidade visual + `.apk` de release testado** | 25/11     | Ícone, cores e `.apk` testado por 2 pessoas de fora |
| **M6 — `.aab` + material de loja + `README.md`**       | 02/12     | Pasta `loja/` + `README.md` completo                |
| **Entrega e apresentação**                             | **10/12** | Tag `v1.0` no repositório                           |

---

## 🏁 Bloco 12 — Definição de pronto

O grupo considerará o Estudae pronto quando:

* [ ] O app abre e não fecha sozinho depois de 5 minutos de uso.
* [ ] A tela principal mostra dados reais salvos no Room.
* [ ] O usuário consegue cadastrar e visualizar matérias.
* [ ] O usuário consegue cadastrar horários de estudo.
* [ ] O usuário consegue cadastrar e concluir tarefas.
* [ ] A ação principal funciona e o resultado aparece na tela.
* [ ] Quando algo falha, aparece uma mensagem clara — o app não quebra.
* [ ] O app possui nome, ícone e identidade visual próprios.
* [ ] Duas pessoas de fora do grupo instalaram o `.apk` e conseguiram utilizá-lo sem explicação.
* [ ] O `README.md` explica o que o app faz, como foi desenvolvido e como gerar o build.
* [ ] O `docs/USO_DE_IA.md` e o `AGENTS.md` estão preenchidos.
* [ ] Cada integrante consegue abrir o projeto e fazer uma pequena alteração sozinho.
* [ ] Todo arquivo necessário possui o comentário de fronteira escrito pelo grupo.

---

## ✍️ Validação do professor

|                 |                                                         |
| --------------- | ------------------------------------------------------- |
| **Data**        |                                                         |
| **Situação**    | ( ) Aprovado    ( ) Aprovado com ajustes    ( ) Refazer |
| **Observações** |                                                         |
