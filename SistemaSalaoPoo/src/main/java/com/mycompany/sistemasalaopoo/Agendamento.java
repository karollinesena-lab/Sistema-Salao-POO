/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasalaopoo;

import java.time.LocalDateTime;


/**
 *
 * @author Lara Paiva
 /* Representa um unico agendamento realizado. Implementa o padrao GRASP Information Expert.
 */

public class Agendamento {
    private final Cliente cliente;
    private final Servico servico;
    private final LocalDateTime inicio;

    public Agendamento(Cliente cliente, Servico servico, LocalDateTime inicio) {
        this.cliente = cliente;
        this.servico = servico;
        this.inicio = inicio;
    }

    // --- GRASP Information Expert ---
    /**
     * Padrao: Information Expert.
     * * Por que foi implementado?
     * A responsabilidade de calcular o fim do agendamento pertence a esta classe,
     * pois ela ja possui as duas informacoes essenciais para o calculo: a 'hora de inicio' 
     * e a 'duracao' do servico. Isso e o principio da Alta Coesao, mantendo a logica 
     * perto dos dados.
     * * Como vai funcionar?
     * Usa o metodo 'plusMinutes' do Java para somar a duracao do servico (em minutos) 
     * a hora de inicio, retornando o horario de termino exato.
     *
     * @return O objeto LocalDateTime representando a hora de termino.
     */
    public LocalDateTime calcularHorarioFinal() {
        return inicio.plusMinutes(servico.getDuracaoEmMinutos());
    }

    // Getters
    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        // Usa o metodo do Information Expert
        return calcularHorarioFinal();
    }

    /**
     * @return Representacao textual formatada do agendamento.
     */
    @Override
    public String toString() {
        return String.format("%s - %s | Cliente: %s | Servico: %s", 
                             inicio.toLocalTime(), getFim().toLocalTime(), 
                             cliente.getNome(), servico.getNome());
    }
}
