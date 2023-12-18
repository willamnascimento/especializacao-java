package org.example;

public class Teste {
    public static void main(String[] args) {

        // Veiculo 1
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setPlaca("AAA-1A11");
        veiculo1.setMarca("Honda");
        veiculo1.setModelo("Civic");
        veiculo1.setCor("Dourada");
        veiculo1.setVelocMax(220);
        veiculo1.setQtdRodas(4);
        veiculo1.getMotor().setPotencia(130);
        veiculo1.getMotor().setQtdPist(4);
        System.out.println("***** VEICULO 1 ******");
        System.out.println(veiculo1.toString());

        // Veiculo 2
        Veiculo veiculo2 = new Veiculo();
        veiculo2.setPlaca("BBB-1A11");
        veiculo2.setMarca("Honda");
        veiculo2.setModelo("CB250");
        veiculo2.setCor("Cinza");
        veiculo2.setVelocMax(140);
        veiculo2.setQtdRodas(2);
        veiculo2.getMotor().setPotencia(160);
        veiculo2.getMotor().setQtdPist(2);
        System.out.println("***** VEICULO 2 ******");
        System.out.println(veiculo2.toString());

        // Veiculo 3
        Veiculo veiculo3 = new Veiculo();
        veiculo3.setPlaca("BCA-1A11");
        veiculo3.setMarca("BMW");
        veiculo3.setModelo("220i");
        veiculo3.setCor("Branca");
        veiculo3.setVelocMax(240);
        veiculo3.setQtdRodas(4);
        veiculo3.getMotor().setPotencia(180);
        veiculo3.getMotor().setQtdPist(4);
        System.out.println("***** VEICULO 3 ******");
        System.out.println(veiculo3.toString());

        // Veiculo 4
        Veiculo veiculo4 = new Veiculo();
        veiculo4.setPlaca("CCA-1A11");
        veiculo4.setMarca("Dodge");
        veiculo4.setModelo("Journey");
        veiculo4.setCor("Preta");
        veiculo4.setVelocMax(260);
        veiculo4.setQtdRodas(4);
        veiculo4.getMotor().setPotencia(360);
        veiculo4.getMotor().setQtdPist(6);
        System.out.println("***** VEICULO 4 ******");
        System.out.println(veiculo4.toString());

        // Veiculo 5
        Veiculo veiculo5 = new Veiculo();
        veiculo5.setPlaca("CDA-1A12");
        veiculo5.setMarca("Hyundai");
        veiculo5.setModelo("i30");
        veiculo5.setCor("Preta");
        veiculo5.setVelocMax(200);
        veiculo5.setQtdRodas(4);
        veiculo5.getMotor().setPotencia(170);
        veiculo5.getMotor().setQtdPist(4);
        System.out.println("***** VEICULO 5 ******");
        System.out.println(veiculo5.toString());
    }
}