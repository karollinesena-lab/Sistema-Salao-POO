/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemasalaopoo;

import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author Karolline Sena
 * Classe principal (Main) para simular a execucao e as interacoes do sistema.
 * Interage diretamente com a Agenda para simular as operacoes do usuario.
 */
public class SalaoApp {

    public static void main(String[] args) {
        
        // O Main interage diretamente com a Agenda, que contem a logica de GRASP.
        Agenda agendaDoSalao = new Agenda();

        // 1. Definicao de objetos de dados (simulando dados de entrada)
        Cliente maria = new Cliente("Maria Silva", "0101-0202");
        Cliente joana = new Cliente("Joana Santos", "0303-0404");
        Cliente carla = new Cliente("Carla Oliveira", "0505-0606"); // Cliente para o teste de CONFLITO
        
        Servico corte = new Servico("Corte Feminino", 50.00, 60); // 60 minutos
        Servico manicure = new Servico("Manicure", 30.00, 45);   // 45 minutos

        // --- SIMULACAO DE AGENDAMENTOS ---
        
        // 2. Agendamento Valido 1 (Maria: 10:00 - 11:00)
        LocalDateTime hora10_00 = LocalDateTime.of(2025, Month.DECEMBER, 15, 10, 0);
        System.out.println("\n--- TENTATIVA 1: AGENDAMENTO VALIDO (Maria) ---");
        System.out.println("Solicitando: Maria (10:00h | Servico: Corte - 60 min)");
        String resultado1 = agendaDoSalao.criarEAgendar(maria, corte, hora10_00);
        System.out.println("RESULTADO: " + resultado1);
        
        // 3. Agendamento Valido 2 (Joana: 11:30 - 12:15)
        LocalDateTime hora11_30 = LocalDateTime.of(2025, Month.DECEMBER, 15, 11, 30); 
        System.out.println("\n--- TENTATIVA 2: AGENDAMENTO VALIDO (Joana) ---");
        System.out.println("Solicitando: Joana (11:30h | Servico: Manicure - 45 min)");
        String resultado2 = agendaDoSalao.criarEAgendar(joana, manicure, hora11_30);
        System.out.println("RESULTADO: " + resultado2);

        // 4. Agendamento INVALIDO (Carla: Conflito 10:30 - 11:15)
        // O horario se sobrepoe ao agendamento de Maria (10:00 a 11:00).
        LocalDateTime hora10_30_conflito = LocalDateTime.of(2025, Month.DECEMBER, 15, 10, 30); 
        System.out.println("\n--- TENTATIVA 3: AGENDAMENTO INVALIDO (Carla) ---");
        System.out.println("Solicitando: Carla (10:30h | Servico: Manicure - 45 min)");
        String resultado3 = agendaDoSalao.criarEAgendar(carla, manicure, hora10_30_conflito);
        System.out.println("RESULTADO: " + resultado3); 

        // 5. Listagem da Agenda
        agendaDoSalao.listarAgendamentos();
    }
}
