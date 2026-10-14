# 📚 EstudAê — Canvas da Equipe

> Divisão de atividades entre as cinco integrantes, de forma equilibrada, para que todas tenham participação real no código, no GitHub, nos testes e na entrega final.

Como o professor avalia também o histórico de commits, **cada integrante deve fazer suas próprias alterações e registrá-las no GitHub**.

---

## 1. Divisão de atividades

### 1. Larissa Vitoria da Silva B3 — Interface e navegação

- Desenvolver a tela inicial do EstudAê.
- Criar a navegação entre as telas.
- Padronizar cores, botões, campos e cartões com Jetpack Compose e Material 3.
- Garantir que as telas tenham aparência consistente.
- Testar a navegação entre as funcionalidades.

**Entregas:** tela inicial, componentes visuais e navegação.

### 2. Ana Beatriz Costa — Matérias e banco de dados

- Criar o cadastro de matérias.
- Implementar a entidade, o DAO e o banco Room das matérias.
- Permitir cadastrar, listar e excluir matérias, conforme os requisitos definidos.
- Integrar os dados à interface.
- Tratar erros de persistência.

**Entregas:** cadastro funcional de matérias e persistência local.

### 3. Ketsoanny Nathielly — Tarefas e documentação

- Desenvolver o cadastro de tarefas.
- Permitir marcar tarefas como concluídas.
- Implementar a persistência das tarefas, em conjunto com a arquitetura Room.
- Atualizar `README.md`, `PRD.md` e `docs/USO_DE_IA.md`.
- Acompanhar os commits e a organização da entrega.

**Entregas:** tarefas funcionais e documentação atualizada.

### 4. Ikalimony Helissa — Horários de estudo

- Desenvolver o cadastro dos horários de estudo.
- Criar os campos para matéria, dia e horário.
- Implementar a listagem dos horários cadastrados.
- Integrar os horários ao banco de dados Room, alinhando a implementação com Ana.
- Testar cadastro, edição e exclusão, se essas operações estiverem previstas no PRD.

**Entregas:** horários cadastrados e exibidos corretamente.

### 5. Estefani Maria — Rotina e testes

- Desenvolver a tela de visualização da rotina de estudos.
- Reunir os horários, as matérias e as tarefas nas telas de consulta.
- Integrar a rotina com as funcionalidades desenvolvidas pelas colegas.
- Testar os fluxos principais e registrar os erros encontrados.
- Preparar capturas de tela para `docs/telas/` e ajudar nos testes finais.

**Entregas:** visualização da rotina integrada e testes documentados.

> Essas responsabilidades são uma proposta inicial: ajustem conforme o que cada uma já implementou, para não duplicar trabalho nem descartar código existente.

---

## 2. Quem depende de quem?

| Grupo | Dependência |
| ----- | ----------- |
| Ana Beatriz + Ketsoanny + Ikalimony | Matérias, tarefas, horários e armazenamento no Room |
| Larissa | Integração das telas e navegação |
| Estefani + toda a equipe | Rotina integrada, testes e correções |

A divisão não significa que as responsáveis precisam esperar todas as outras terminarem. Vocês podem desenvolver interfaces e modelos em paralelo, combinando antecipadamente os nomes das classes e os dados que cada tela vai receber.

---

## 3. Cronograma até a entrega

Considerando o prazo de 14/10/2026 e os marcos do professor:

| Período | Prioridade | Responsáveis |
| ------- | ---------- | ------------ |
| 14–18/10 | Finalizar tarefas, matérias, horários e telas principais | Todas |
| Até 21/10 | App compilando, lista de dados, ação do usuário e tratamento de erros | Todas |
| 22/10–11/11 | Consolidar Room e mensagens de erro | Ana, Ketsoanny e Ikalimony |
| 12–25/11 | Identidade visual, testes do APK e correções | Larissa e Estefani, com todas |
| 26/11–02/12 | Documentação, ícone, AAB e materiais da loja | Ketsoanny e Estefani, com todas |
| 03–10/12 | Correções finais, tag `v1.0`, Release e apresentação | Todas |

---

## 4. Como registrar as atividades no GitHub

Cada integrante deve criar **Issues** para suas tarefas, com uma responsável definida, e trabalhar em uma **branch própria**.

| Integrante | Branch sugerida |
| ---------- | --------------- |
| Larissa | `feat/tela-inicial` |
| Ana Beatriz | `feat/cadastro-materias` |
| Ketsoanny | `feat/cadastro-tarefas` |
| Ikalimony | `feat/horarios-estudo` |
| Estefani | `feat/visualizar-rotina` |

Ao terminar cada parte, a responsável deve:

1. Testar a funcionalidade.
2. Fazer um commit com mensagem clara.
3. Enviar a branch para revisão.
