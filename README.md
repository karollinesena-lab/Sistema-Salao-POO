Sistema de Gerenciamento de Agendamentos (Aplicação Prática dos Padrões GRASP)
=============================================================================

Este projeto de Programação Orientada a Objetos implementa um sistema de agendamentos para salão de beleza focado na aplicação dos Padrões GRASP (Creator e Information Expert). O objetivo é demonstrar a correta atribuição de responsabilidades entre classes de domínio, resultando em um design com Alta Coesão e Baixo Acoplamento.

Padrões GRASP Implementados e Justificativa Acadêmica
------------------------------------------------------

1. Information Expert (Especialista da Informação):
   - Agendamento.java: O agendamento é o especialista em seus próprios dados (hora de início e duração do serviço). Por isso, é responsável por calcular o horário exato de término (método calcularHorarioFinal()). Isso garante que a lógica fique perto da informação que ela precisa.
   - Agenda.java: A Agenda é a especialista porque contém a coleção de TODOS os agendamentos. Assim, ela é a única que pode verificar se um novo horário tem conflito com os já existentes (método verificarConflito()).

2. Creator (Criador):
   - Agenda.java: A Agenda é a classe agregadora, pois ela 'guarda' todos os objetos Agendamento. O Creator determina que a classe que contém um objeto também deve ser responsável por criá-lo (método criarEAgendar()). Isso evita que a classe principal (SalaoApp) se ocupe de criar objetos, mantendo o sistema organizado (Baixo Acoplamento).

Prova de Conceito (Simulação em SalaoApp.java)
----------------------------------------------

A classe SalaoApp.java executa testes diretos para validar os padrões GRASP:

- Teste do Creator e Information Expert (Conflito de Horário):
  - Um agendamento válido (Maria 10:00-11:00) é criado pelo padrão Creator.
  - Uma tentativa de agendamento subsequente (Carla 10:30-11:15) é rejeitada pelo padrão Information Expert da classe Agenda.
  - O conflito é testado unicamente pela sobreposição de tempo, provando que a lógica de validação não depende da identidade da cliente.

Contribuicão e Divisão de Tarefas na Dupla
------------------------------------------

- Karolline de Sena: Responsável pela Lógica de Domínio (Agenda.java) e Simulação (SalaoApp.java). Foco nos padrões Creator e Information Expert (Validação de Conflito).
- Lara Gomes Paiva: Responsável pelas Classes de Modelo (Cliente.java, Servico.java, Agendamento.java). Foco no padrão Information Expert (Cálculo de tempo).

Como Executar
--------------

Execute a classe principal SalaoApp.java em qualquer IDE Java.
