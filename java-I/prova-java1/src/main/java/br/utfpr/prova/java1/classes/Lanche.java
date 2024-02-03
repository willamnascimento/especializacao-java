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
public final  class Lanche extends Point implements Verifica{
    private String prato = "";

    @Override
    public void validar() {
        String primeiraLetra = this.getPrato().substring(0,1);
        System.out.println(primeiraLetra);
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    @Override
    public void calcVal() {
        if (this.getValConta() % 2 == 0){
            System.out.println("Valor Par");
        }else{
            System.out.println("Valor Impar");
        }
    }
    
    
    
}
