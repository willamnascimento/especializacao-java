package org.example;

import java.util.ArrayList;
import java.util.List;

public class Java1Atividade5 {
    public static void main(String[] args) {

        // Wrapper Integer
        List<Integer> lista = new ArrayList<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);

        for (Integer numero : lista) {
            System.out.println(numero); // Saída: 10, 20, 30
        }


        // Wrapper Double
        Double valor1 = 10.5;
        Double valor2 = 5.2;

        Double resultado = valor1 + valor2;
        System.out.println("Resultado da soma: " + resultado); // Saída: Resultado da soma: 15.7

        // Wrapper Boolean
        Boolean condicao = true;

        if (condicao) {
            System.out.println("A condição é verdadeira.");
        } else {
            System.out.println("A condição é falsa.");
        }

    }
}