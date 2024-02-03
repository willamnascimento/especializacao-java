/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.prova.java1.classes;

import br.utfpr.prova.java1.exception.NumException;
import java.util.ArrayList;
import java.util.List;

/**
 *
* @author William Siqueira Nascimento
 */
public class TstPoint {
    public static Leitura ler = new Leitura();
    public static List<Cine> listaCinemas = new ArrayList<>();
    public static int menu = 0;
    
    
    public static void main(String[] args) {
        while (menu < 9) {
            System.out.println("Sistema de Cinema - Menu Inicial");
            System.out.println("1) Cadastrar Cinema");
            System.out.println("2) Imprimir Cinema");
            System.out.println("9) Sair do Sistema");
            System.out.println("====================================");
            System.out.println();
            try {
                menu = Integer.parseInt(ler.entDados("Digite uma das opções acima"));
            }catch  (NumberFormatException ex){
                System.out.println("Digite um número");
                ler.entDados("");
                continue;
            }

            switch (menu) {
                case 1:
                    String novoCadastro = "s";
                    while (novoCadastro.equals("s")) {
                        try {
                            boolean retorno = CadastrarCinema();
                            if (!retorno)
                                break;
                        }catch (NumException ve){

                        }

                        novoCadastro = ler.entDados("Você deseja cadastrar um novo ");
                    }
                    break;
                case 2:
                    ImprimirCinemas();
                    break;
                
            }

        }
        
    }
    
    private static boolean CadastrarCinema() throws NumException {
        Cine cinema = new Cine();
        System.out.println("=============== CADASTRO DE CINEMA =====================");
        System.out.println("Insira os dados e valores solicitados abaixo");
        System.out.println("=================================================================");

        cinema.setNome(ler.entDados("Nome do Cinema: "));
        cinema.getEnder().setRua(ler.entDados("Nome da Rua: "));
        int numero = 0;
        try {
            numero = Integer.parseInt(ler.entDados("Número do Prédio: "));
            cinema.getEnder().setNum(numero);

        } catch (NumException e) {
            e.impMsg();
            cinema.getEnder().setNum(numero);
        }
        cinema.getLanche().setPrato(ler.entDados("Nome do Prato: "));
        cinema.getLanche().setValConta(Integer.parseInt(ler.entDados("Valor da Conta: ")));
        
        listaCinemas.add(cinema);
        
        return true;
    }
    
    private static void ImprimirCinemas(){
        for (Cine c : listaCinemas){
            c.toString();
        }
    }
    
}
