# AGENTS.md — Regras para a IA no projeto EstudAê

Este arquivo orienta o Gemini e qualquer outra ferramenta de inteligência artificial sobre como trabalhar neste repositório. **Leia todas as regras antes de gerar ou modificar código.**

## Sobre o projeto

- **App:** EstudAê — aplicativo Android para estudantes do Ensino Médio organizarem sua rotina de estudos.
- **Objetivo:** facilitar a organização das matérias, dos horários e das tarefas escolares em um único aplicativo.
- **MVP:** cadastro de matérias, cadastro de horários de estudo, cadastro de tarefas, marcação de tarefas como concluídas e visualização da rotina de estudos.
- **Entrega final:** 10/12/2026.

### Equipe e responsabilidades

- **Larissa Vitoria da Silva B3:** desenvolvimento das telas, interface com Jetpack Compose e navegação entre as funcionalidades.
- **Ana Beatriz Costa:** cadastro de matérias, banco de dados Room e persistência dos dados das matérias.
- **Ketsoanny Nathielly:** cadastro e gerenciamento de tarefas, horários de estudo e documentação do projeto.
- **Ikalimony Helissa:** cadastro, organização e visualização dos horários de estudo, em integração com o banco de dados Room.
- **Estefani Maria:** desenvolvimento da visualização da rotina de estudos, integração das funcionalidades, testes e registro de problemas encontrados.

Todas as integrantes devem participar da revisão do código, dos testes, da documentação e da preparação da entrega final. As responsabilidades podem ser ajustadas de acordo com as necessidades do projeto e os acordos da equipe.

## Stack tecnológica — não alterar sem autorização

- Kotlin.
- Jetpack Compose.
- Material 3.
- Navigation Compose.
- Room Database com KSP.
- Kotlin Coroutines e Flow.
- Arquitetura organizada em `data/` (local e repository), `model/` e `ui/` (theme, navigation e features).
- Pacote base previsto: `br.edu.ifpe.estudae`. Confirmar se corresponde ao `namespace` e ao `applicationId` reais do projeto.

Não adicione bibliotecas novas nem altere as tecnologias definidas sem autorização explícita da equipe.

## Como trabalhar

1. **Faça uma tarefa pequena por vez.** Trabalhe em uma tela, função, DAO ou outra parte específica. Não gere o aplicativo inteiro de uma só vez.
2. **Explique as alterações.** Use linguagem simples para que todas as integrantes compreendam o código e os arquivos modificados.
3. **Respeite o escopo.** Não altere arquivos que não estejam relacionados à tarefa solicitada. Se outra alteração for necessária, explique o motivo e peça autorização.
4. **Preserve o código existente.** Não apague nem reescreva implementações sem autorização.
5. **Escreva código simples e legível.** Mantenha os padrões de nomenclatura e organização já utilizados no projeto.
6. **Trate erros adequadamente.** Operações de banco de dados, rede e entradas do usuário devem receber tratamento de erros apropriado. Utilize `try/catch` quando necessário e apresente mensagens claras ao usuário. Não use `try/catch` indiscriminadamente nem esconda erros.
7. **Adicione comentários de fronteira.** No início dos arquivos, inclua um comentário curto indicando sua finalidade e a integrante responsável, conforme a exigência do professor.
8. **Mantenha a interface em português.** Os textos da interface devem ser definidos em `strings.xml`, evitando textos fixos diretamente no código das telas.
9. **Respeite a arquitetura.** Evite duplicar funcionalidades, regras de negócio ou estruturas de dados que já existam.
10. **Teste as alterações.** Oriente a equipe a compilar e testar a funcionalidade antes de considerá-la concluída.

## Segredos e arquivos protegidos

- Nunca coloque senhas, tokens ou chaves de API diretamente no código.
- Mantenha configurações locais e informações sensíveis fora do versionamento.
- Utilize `local.properties` para configurações locais quando apropriado e confirme que o arquivo está protegido pelo `.gitignore`.
- Respeite as exclusões definidas no `.aiexclude`.
- Não leia, exponha, modifique ou sugira incluir no Git arquivos protegidos pelo `.aiexclude`.

## Git e GitHub

- Não faça commits diretamente na branch `main`.
- Crie branches específicas para novas funcionalidades, correções e documentação.
- Utilize mensagens de commit curtas, claras e em português, seguindo os padrões:
  - `feat:` nova funcionalidade.
  - `fix:` correção de erro.
  - `docs:` alteração na documentação.
  - `chore:` manutenção e ajustes gerais.
  - `test:` adição ou alteração de testes.
- Cada commit deve descrever uma alteração realmente realizada pela equipe.
- Faça commits pequenos e frequentes, correspondentes a mudanças identificáveis.
- Revise as alterações antes de enviá-las ao GitHub.
- Quando aplicável, abra um Pull Request para revisão antes de integrar as alterações à `main`.
- Não afirme que um commit, push ou Pull Request foi concluído sem verificar o resultado.

## O que a IA não deve fazer

- Gerar várias funcionalidades independentes em uma única tarefa sem solicitação.
- Alterar arquivos `build.gradle.kts`, versões de dependências ou o `applicationId` sem autorização.
- Apagar ou substituir código existente sem aprovação.
- Escrever documentos oficiais como se fossem produzidos e revisados pela equipe sem validação das integrantes.
- Inventar testes, resultados, contribuições ou registros de uso de inteligência artificial.
- Afirmar que uma funcionalidade funciona sem que a equipe tenha realizado os testes necessários.
- Registrar como contribuição de uma integrante um trabalho que ela não realizou.
- Criar commits ou descrever alterações como se fossem executados pelas integrantes quando isso não aconteceu.

## Registro obrigatório de uso de IA

Todo uso relevante de inteligência artificial deve ser registrado em `docs/USO_DE_IA.md`.

O registro deve refletir o uso real da ferramenta, indicando sua finalidade e as alterações realizadas. Cada integrante deve revisar, compreender e validar as contribuições antes de incorporá-las ao projeto.

## Regra final

O objetivo da inteligência artificial é auxiliar a equipe no desenvolvimento do EstudAê, sem substituir a participação, a compreensão, a revisão e a responsabilidade das integrantes pelo código e pela entrega.
