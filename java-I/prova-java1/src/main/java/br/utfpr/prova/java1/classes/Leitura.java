/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.prova.java1.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
* @author William Siqueira Nascimento
 */
public class Leitura {
    public String entDados(String mensagem){
        System.out.println(mensagem);
        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(teclado);

        String retorno = "";
        try {
            retorno = buffer.readLine();
        }catch (IOException ex){
            System.out.println("Erro no sistema");
        }
        return retorno;
    }
}
