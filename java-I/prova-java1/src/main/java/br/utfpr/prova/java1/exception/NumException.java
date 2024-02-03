/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.prova.java1.exception;

/**
 *
* @author William Siqueira Nascimento
 */
public class NumException extends Exception{

    public void impMsg() {
        System.out.println("Valor maior que 1000!");
    }
    
}
