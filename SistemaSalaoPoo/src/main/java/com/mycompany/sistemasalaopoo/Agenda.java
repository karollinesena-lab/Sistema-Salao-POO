/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasalaopoo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 *
 * @author Karolline Sena
 * Classe de dominio que guarda, gerencia e valida a colecao de agendamentos.
 * Implementa os padroes GRASP Creator e Information Expert.
 */
public class Agenda {
    
    private final List<Agendamento> agendamentos = new ArrayList<>();

    // --- GRASP Creator e Agregacao ---
    /**
     * Padrao: Creator (Criador).
     *
     * Por que foi implementado?
     * A Agenda e a classe que 'contem' (agrega) a lista de Agendamentos. O Creator 
     * determina que a classe que contem um objeto tambem deve ser responsavel por 
     * cria-lo. Isso mantem a logica de criacao centralizada e organizada (Baixo Acoplamento).
     * * Como vai funcionar?
     * O metodo cria o novo objeto Agendamento (new Agendamento(...)) e, em seguida, 
     * tenta adiciona-lo a lista, chamando a validacao de conflito antes.
     *
     * @return Uma mensagem de sucesso ou erro apos a tentativa de agendamento.
     */
    public String criarEAgendar(Cliente cliente, Servico servico, LocalDateTime dataHora) {
        
        // 1. Criacao da instancia (GRASP Creator)
        Agendamento novoAgendamento = new Agendamento(cliente, servico, dataHora);
        
        // 2. Validacao de Conflito (GRASP Information Expert)
        if (verificarConflito(novoAgendamento)) {
            return "Erro: Horario indisponivel! Conflito de agendamento detectado.";
        }

        // 3. Adiciona
        this.agendamentos.add(novoAgendamento);
        return "Sucesso: Agendamento criado. Detalhes: " + novoAgendamento.toString();
    }


    // --- GRASP Information Expert ---
    /**
     * Padrao: Information Expert (Especialista da Informacao).
     *
     * Por que foi implementado?
     * A Agenda e a unica classe que tem a colecao (a lista) de todos os agendamentos ja marcados. 
     * Ela e, portanto, a especialista em 'saber' se o horario esta ocupado. O Expert 
     * atribui a ela a responsabilidade de verificar conflitos.
     * * Como vai funcionar?
     * O metodo itera sobre a lista interna de agendamentos e usa a logica de tempo 
     * (isBefore e isAfter) para checar se o novo agendamento se sobrepoe a qualquer um ja existente.
     *
     * @param novo O agendamento a ser testado.
     * @return true se houver conflito, false caso contrario.
     */
    public boolean verificarConflito(Agendamento novo) {
        for (Agendamento existente : agendamentos) {
            
            // Condicao de sobreposicao: os periodos se cruzam
            boolean comecaAntesDoFim = novo.getInicio().isBefore(existente.getFim());
            boolean terminaDepoisDoInicio = novo.getFim().isAfter(existente.getInicio());
            
            if (comecaAntesDoFim && terminaDepoisDoInicio) {
                return true; // Conflito detectado
            }
        }
        return false; // Sem conflito
    }
    
    /**
     * Imprime a lista de agendamentos para o console.
     */
    public void listarAgendamentos() {
        System.out.println("\n--- VISUALIZACAO DA AGENDA ---");
        if (agendamentos.isEmpty()) {
            System.out.println("Agenda vazia.");
            return;
        }
        // Ordena para uma exibicao clara
        agendamentos.sort(Comparator.comparing(Agendamento::getInicio));
        for (Agendamento a : agendamentos) {
            System.out.println(a);
        }
    }
}
