/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.prova.java1.classes;

/**
 *
* @author William Siqueira Nascimento
*/
public abstract class Point {
    private String nome = "";
    private int valConta = 0;
    private Endereco ender = new Endereco();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValConta() {
        return valConta;
    }

    public void setValConta(int valConta) {
        this.valConta = valConta;
    }

    public Endereco getEnder() {
        return ender;
    }

    
    public abstract void calcVal();
    
}
