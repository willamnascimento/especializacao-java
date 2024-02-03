/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.prova.java1.classes;

import br.utfpr.prova.java1.interfaces.Verifica;

/**
 *
 * @author William Siqueira Nascimento
 */
public final class Cine extends Point implements Verifica{
    private int qtdCad = 0;
    private Lanche lanche = new Lanche();
    
    @Override
    public void validar() {
        int length = this.getEnder().getRua().length();
        if (length >= 10 && length <= 35){
            System.out.println("Nome de rua VALIDO para Cine");
        }else{
            System.out.println("Nome de rua INVALIDO para Cine");
        }
    }

    public int getQtdCad() {
        return qtdCad;
    }

    public void setQtdCad(int qtdCad) {
        this.qtdCad = qtdCad;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    @Override
    public void calcVal() {
        int result = this.getValConta() + 10;
        System.out.println("Valor Acrescido: " + result);
    }

    @Override
    public String toString() {
        System.out.println("================================");
        System.out.println("Nome do Cinema: " + this.getNome());
        System.out.println("Nome da Rua: " + this.getEnder().getRua());
        this.validar();
        this.calcVal();
        System.out.println("Número do Predio: " + this.getEnder().getNum());
        System.out.println("Valor da Conta: " + this.getLanche().getValConta());
        this.getLanche().calcVal();
        this.getLanche().validar();
        System.out.println("================================");

        return null;
    }
    
    
    
    
}
