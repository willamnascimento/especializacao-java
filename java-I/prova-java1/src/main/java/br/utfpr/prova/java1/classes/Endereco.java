/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.prova.java1.classes;

import br.utfpr.prova.java1.exception.NumException;

/**
 *
* @author William Siqueira Nascimento
*/
public final class Endereco {
    private int num = 0;
    private String rua = "";

    public int getNum() {
        return num;
    }

    public void setNum(int num) throws NumException{
        if (num > 1000){
            throw new NumException();
        }
        this.num = num;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
