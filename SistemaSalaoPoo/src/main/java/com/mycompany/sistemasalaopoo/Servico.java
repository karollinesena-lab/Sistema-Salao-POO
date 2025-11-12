/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasalaopoo;

/**
 *
 * @author Lara Paiva
 */
/* Classe de modelo para representar um Servico oferecido pelo salao.
 */

public class Servico {
    private final String nome;
    private final double preco;
    private final  int duracaoEmMinutos;

    public Servico(String nome, double preco, int duracaoEmMinutos) {
        this.nome = nome;
        this.preco = preco;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
}
}