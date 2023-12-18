package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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
