package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static List<Passeio> listaPasseio = new ArrayList<>();
    public static List<Carga> listaCarga = new ArrayList<>();
    public static Leitura ler = new Leitura();
    public static int menu = 0;

    public static void main(String[] args) {



        while (menu < 7) {
            System.out.println("Sistema de Gestão de Veiculos - Menu Inicial");
            System.out.println("1) Cadastrar Veiculo de Passeio");
            System.out.println("2) Cadastrar Veiculo de Carga");
            System.out.println("3) Imprimir Veiculos de Passeio");
            System.out.println("4) Imprimir Veiculos de Carga");
            System.out.println("5) Imprimir Veiculos de Passeio pela Placa");
            System.out.println("6) Imprimir Veiculos de Carga pela Placa");
            System.out.println("7) Sair do Sistema");
            System.out.println("====================================");
            System.out.println();
            try {
                menu = Integer.parseInt(ler.entDados("Digite uma das opções acima"));
            }catch  (NumberFormatException ex){
                System.out.println("Digite um número");
                ler.entDados("");
                continue;
            }


            if (menu <= 0 || menu > 7) {
                System.out.println("Opção inválida!");
                menu = 0;
            }

            switch (menu) {
                case 1:
                    String novoCadastro = "s";
                    if (listaPasseio.stream().count() == 5){
                        System.out.println("Lista ja estah cheia!");
                        break;
                    }
                    while (novoCadastro.equals("s")) {
                        CadastrarVeiculoPasseio();
                        novoCadastro = ler.entDados("Você deseja cadastrar um novo veiculo de passeio");
                    }
                    break;
                case 2:
                    novoCadastro = "s";
                    if (listaCarga.stream().count() == 5){
                        System.out.println("Lista ja estah cheia!");
                        break;
                    }
                    while (novoCadastro.equals("s")) {
                        CadastrarVeiculoCarga();
                        novoCadastro = ler.entDados("Você deseja cadastrar um novo veiculo de carga");
                    }
                    break;
                case 3:
                    ImprimirVeiculosPasseio();
                    break;
                case 4:
                    ImprimirVeiculosCarga();
                    break;
                case 5:
                    String placa = ler.entDados("Informe a Placa para busca: ");
                    ImprimirVeiculosPasseioPorPlaca(placa);
                    break;
                case 6:
                    placa = ler.entDados("Informe a Placa para busca: ");
                    ImprimirVeiculosCargaPorPlaca(placa);
                    break;
            }

        }
    }

    private static void CadastrarVeiculoPasseio(){
        Passeio passeio = new Passeio();
        System.out.println("=============== CADASTRO DE VEICULO PASSEIO =====================");
        System.out.println("Insira os dados e valores solicitados abaixo");
        System.out.println("=================================================================");

        boolean existePlaca = true;
        String placa = "";
        while (existePlaca){
            placa = ler.entDados("Placa: ");
            existePlaca = ValidarPlacaExistente(placa);
            if (existePlaca){
                System.out.println("=========== ATENCAO ===========");
                System.out.println("Ja existe um veiculo de passeio com essa placa");
                System.out.println("===============================");
            }
        }
        passeio.setPlaca(placa);

        passeio.setMarca(ler.entDados("Marca: "));
        passeio.setModelo(ler.entDados("Modelo: "));
        passeio.setCor(ler.entDados("Cor: "));
        passeio.setQtdRodas(Integer.parseInt(ler.entDados("Quantidade de Rodas: ")));
        passeio.setQtdPassageiros(Integer.parseInt(ler.entDados("Capacidade de Passageiros: ")));
        passeio.setVelocMax(Float.parseFloat(ler.entDados("Velocidade Máxima: ")));
        passeio.getMotor().setPotencia(Integer.parseInt(ler.entDados("Potencia do Motor: ")));
        passeio.getMotor().setQtdPist(Integer.parseInt(ler.entDados("Qtd Pistoes do Motor: ")));

        listaPasseio.add(passeio);
    }

    private static void CadastrarVeiculoCarga(){
        Carga carga = new Carga();
        System.out.println("=============== CADASTRO DE VEICULO CARGA =====================");
        System.out.println("Insira os dados e valores solicitados abaixo");
        System.out.println("=================================================================");

        boolean existePlaca = true;
        String placa = "";
        while (existePlaca){
            placa = ler.entDados("Placa: ");
            existePlaca = ValidarPlacaExistente(placa);
            if (existePlaca){
                System.out.println("=========== ATENCAO ===========");
                System.out.println("Ja existe um veiculo de carga com essa placa");
                System.out.println("===============================");
            }
        }
        carga.setPlaca(placa);

        carga.setMarca(ler.entDados("Marca: "));
        carga.setModelo(ler.entDados("Modelo: "));
        carga.setCor(ler.entDados("Cor: "));
        carga.setQtdRodas(Integer.parseInt(ler.entDados("Quantidade de Rodas: ")));
        carga.setCargaMax(Integer.parseInt(ler.entDados("Carga Maxima: ")));
        carga.setTara(Integer.parseInt(ler.entDados("Tara: ")));
        carga.getMotor().setPotencia(Integer.parseInt(ler.entDados("Potencia do Motor: ")));
        carga.getMotor().setQtdPist(Integer.parseInt(ler.entDados("Qtd Pistoes do Motor: ")));

        listaCarga.add(carga);
    }

    private static boolean ValidarPlacaExistente(String placa){
        for (Passeio p : listaPasseio) {
            if (p.getPlaca().equals(placa)){
                return true;
            }
        }

        for (Carga c : listaCarga) {
            if (c.getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }

    private static void ImprimirVeiculosPasseio(){
        for (Passeio p : listaPasseio){
            p.toString();
        }
    }

    private static void ImprimirVeiculosCarga(){
        for (Carga c : listaCarga){
            c.toString();
        }
    }

    private static void ImprimirVeiculosPasseioPorPlaca(String placa){
        for (Passeio p : listaPasseio){
            if (p.getPlaca().equals(placa)) {
                p.toString();
            }
        }
    }

    private static void ImprimirVeiculosCargaPorPlaca(String placa){
        for (Carga c : listaCarga){
            if (c.getPlaca().equals(placa)) {
                c.toString();
            }
        }
    }
}