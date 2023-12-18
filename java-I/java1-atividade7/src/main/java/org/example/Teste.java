package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {

    public static Leitura ler = new Leitura();
    public static BDVeiculos bd = new BDVeiculos();
    public static int menu = 0;

    public static void main(String[] args) {
        while (menu < 9) {
            System.out.println("Sistema de Gestão de Veiculos - Menu Inicial");
            System.out.println("1) Cadastrar Veiculo de Passeio");
            System.out.println("2) Cadastrar Veiculo de Carga");
            System.out.println("3) Imprimir Veiculos de Passeio");
            System.out.println("4) Imprimir Veiculos de Carga");
            System.out.println("5) Imprimir Veiculos de Passeio pela Placa");
            System.out.println("6) Imprimir Veiculos de Carga pela Placa");
            System.out.println("7) Excluir Veiculos de Passeio pela Placa");
            System.out.println("8) Excluir Veiculos de Carga pela Placa");
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


            if (menu <= 0 || menu > 7) {
                System.out.println("Opção inválida!");
                menu = 0;
            }

            switch (menu) {
                case 1:
                    String novoCadastro = "s";
                    while (novoCadastro.equals("s")) {
                        try {
                            boolean retorno = CadastrarVeiculoPasseio();
                            if (!retorno)
                                break;
                        }catch (VelocException ve){

                        }

                        novoCadastro = ler.entDados("Você deseja cadastrar um novo veiculo de passeio");
                    }
                    break;
                case 2:
                    novoCadastro = "s";
                    while (novoCadastro.equals("s")) {
                        try {
                            boolean retorno = CadastrarVeiculoCarga();
                            if (!retorno)
                                break;
                        }catch (VelocException ve){

                        }
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
                case 7:
                    placa = ler.entDados("Informe a Placa para exclusão: ");
                    ExcluirVeiculosPasseioPorPlaca(placa);
                    break;
            }

        }
    }

    private static boolean CadastrarVeiculoPasseio() throws VelocException {
        Passeio passeio = new Passeio();
        System.out.println("=============== CADASTRO DE VEICULO PASSEIO =====================");
        System.out.println("Insira os dados e valores solicitados abaixo");
        System.out.println("=================================================================");

        boolean existePlaca = true;
        String placa = "";

        placa = ler.entDados("Placa: ");
        try {
            existePlaca = ValidarPlacaExistente(placa);
        }catch (VeicExistException vee){
            return false;
        }

        passeio.setPlaca(placa);

        passeio.setMarca(ler.entDados("Marca: "));
        passeio.setModelo(ler.entDados("Modelo: "));
        passeio.setCor(ler.entDados("Cor: "));
        passeio.setQtdRodas(Integer.parseInt(ler.entDados("Quantidade de Rodas: ")));
        passeio.setQtdPassageiros(Integer.parseInt(ler.entDados("Capacidade de Passageiros: ")));
        try {
            passeio.setVelocMax(Float.parseFloat(ler.entDados("Velocidade Máxima: ")));
        }catch (VelocException ve){
            passeio.setVelocMax(100);
        }
        passeio.getMotor().setPotencia(Integer.parseInt(ler.entDados("Potencia do Motor: ")));
        passeio.getMotor().setQtdPist(Integer.parseInt(ler.entDados("Qtd Pistoes do Motor: ")));

        bd.getListaPasseio().add(passeio);

        return true;
    }

    private static boolean CadastrarVeiculoCarga() throws VelocException{
        Carga carga = new Carga();
        System.out.println("=============== CADASTRO DE VEICULO CARGA =====================");
        System.out.println("Insira os dados e valores solicitados abaixo");
        System.out.println("=================================================================");

        boolean existePlaca = true;
        String placa = "";

        placa = ler.entDados("Placa: ");
        try {
            existePlaca = ValidarPlacaExistente(placa);

        }catch (VeicExistException vee){
            return false;
        }

        carga.setPlaca(placa);

        carga.setMarca(ler.entDados("Marca: "));
        carga.setModelo(ler.entDados("Modelo: "));
        carga.setCor(ler.entDados("Cor: "));
        carga.setQtdRodas(Integer.parseInt(ler.entDados("Quantidade de Rodas: ")));
        carga.setCargaMax(Integer.parseInt(ler.entDados("Carga Maxima: ")));
        carga.setTara(Integer.parseInt(ler.entDados("Tara: ")));
        try {
            carga.setVelocMax(Float.parseFloat(ler.entDados("Velocidade Maxima: ")));

        }catch (VelocException ve){
            carga.setVelocMax(90);
        }
        carga.getMotor().setPotencia(Integer.parseInt(ler.entDados("Potencia do Motor: ")));
        carga.getMotor().setQtdPist(Integer.parseInt(ler.entDados("Qtd Pistoes do Motor: ")));

        bd.getListaCarga().add(carga);

        return true;
    }

    private static boolean ValidarPlacaExistente(String placa) throws VeicExistException{
        for (Passeio p : bd.getListaPasseio()) {
            if (p.getPlaca().equals(placa)){
                throw new VeicExistException();
            }
        }

        for (Carga c : bd.getListaCarga()) {
            if (c.getPlaca().equals(placa)){
                throw new VeicExistException();
            }
        }
        return false;
    }

    private static void ImprimirVeiculosPasseio(){
        for (Passeio p : bd.getListaPasseio()){
            p.toString();
        }
    }

    private static void ImprimirVeiculosCarga(){
        for (Carga c : bd.getListaCarga()){
            c.toString();
        }
    }

    private static void ImprimirVeiculosPasseioPorPlaca(String placa){
        for (Passeio p : bd.getListaPasseio()){
            if (p.getPlaca().equals(placa)) {
                p.toString();
            }
        }
    }

    private static void ExcluirVeiculosPasseioPorPlaca(String placa){
        for (Passeio p : bd.getListaPasseio()){
            if (p.getPlaca().equals(placa)) {
                bd.getListaPasseio().remove(p);
                return;
            }
        }
    }

    private static void ImprimirVeiculosCargaPorPlaca(String placa){
        for (Carga c : bd.getListaCarga()){
            if (c.getPlaca().equals(placa)) {
                c.toString();
            }
        }
    }

    private static void ExcluirVeiculosCargaPorPlaca(String placa){
        for (Carga c : bd.getListaCarga()){
            if (c.getPlaca().equals(placa)) {
                bd.getListaCarga().remove(c);
                return;
            }
        }
    }
}