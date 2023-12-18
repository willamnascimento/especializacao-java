package org.example;

public class Teste {
    public static void main(String[] args) {

        // Passeio1 1
        Passeio passeio1 = new Passeio();
        passeio1.setPlaca("AAA-1A11");
        passeio1.setMarca("Honda");
        passeio1.setModelo("Civic");
        passeio1.setCor("Dourada");
        passeio1.setVelocMax(220);
        passeio1.setQtdRodas(4);
        passeio1.getMotor().setPotencia(130);
        passeio1.getMotor().setQtdPist(4);
        passeio1.setQtdPassageiros(5);
        System.out.println("***** PASSEIO 1 ******");
        System.out.println(passeio1.toString());

        // Passeio 2
        Passeio passeio2 = new Passeio();
        passeio2.setPlaca("BBB-1A11");
        passeio2.setMarca("Honda");
        passeio2.setModelo("CB250");
        passeio2.setCor("Cinza");
        passeio2.setVelocMax(140);
        passeio2.setQtdRodas(2);
        passeio2.getMotor().setPotencia(160);
        passeio2.getMotor().setQtdPist(2);
        passeio2.setQtdPassageiros(2);
        System.out.println("***** PASSEIO 2 ******");
        System.out.println(passeio2.toString());

        // Passeio 3
        Passeio passeio3 = new Passeio();
        passeio3.setPlaca("BCA-1A11");
        passeio3.setMarca("BMW");
        passeio3.setModelo("220i");
        passeio3.setCor("Branca");
        passeio3.setVelocMax(240);
        passeio3.setQtdRodas(4);
        passeio3.getMotor().setPotencia(180);
        passeio3.getMotor().setQtdPist(4);
        passeio3.setQtdPassageiros(4);
        System.out.println("***** PASSEIO 3 ******");
        System.out.println(passeio3.toString());

        // Passeio 4
        Passeio passeio4 = new Passeio();
        passeio4.setPlaca("CCA-1A11");
        passeio4.setMarca("Dodge");
        passeio4.setModelo("Journey");
        passeio4.setCor("Preta");
        passeio4.setVelocMax(260);
        passeio4.setQtdRodas(4);
        passeio4.getMotor().setPotencia(360);
        passeio4.getMotor().setQtdPist(6);
        passeio4.setQtdPassageiros(7);
        System.out.println("***** PASSEIO 4 ******");
        System.out.println(passeio4.toString());

        // Passeio 5
        Passeio passeio5 = new Passeio();
        passeio5.setPlaca("CDA-1A12");
        passeio5.setMarca("Hyundai");
        passeio5.setModelo("i30");
        passeio5.setCor("Preta");
        passeio5.setVelocMax(200);
        passeio5.setQtdRodas(4);
        passeio5.getMotor().setPotencia(170);
        passeio5.getMotor().setQtdPist(4);
        passeio5.setQtdPassageiros(5);
        System.out.println("***** PASSEIO 5 ******");
        System.out.println(passeio5.toString());

        System.out.println("***********************************************");

        // Carga1
        Carga carga1 = new Carga();
        carga1.setPlaca("ARD-1A31");
        carga1.setMarca("Ford");
        carga1.setModelo("Ranger");
        carga1.setCor("Branca");
        carga1.setVelocMax(190);
        carga1.setQtdRodas(4);
        carga1.getMotor().setPotencia(150);
        carga1.getMotor().setQtdPist(4);
        carga1.setCargaMax(1000);
        carga1.setTara(2000);
        System.out.println("***** CARGA 1 ******");
        System.out.println(carga1.toString());

        // Carga2
        Carga carga2 = new Carga();
        carga2.setPlaca("BAA-1A00");
        carga2.setMarca("VolksWagen");
        carga2.setModelo("F230");
        carga2.setCor("Preta");
        carga2.setVelocMax(190);
        carga2.setQtdRodas(8);
        carga2.getMotor().setPotencia(160);
        carga2.getMotor().setQtdPist(5);
        carga2.setTara(3500);
        carga2.setCargaMax(4000);
        System.out.println("***** CARGA 2 ******");
        System.out.println(carga2.toString());

        // Carga 3
        Carga carga3 = new Carga();
        carga3.setPlaca("BWW-1A89");
        carga3.setMarca("Mercedes");
        carga3.setModelo("1510");
        carga3.setCor("Bege");
        carga3.setVelocMax(240);
        carga3.setQtdRodas(4);
        carga3.getMotor().setPotencia(180);
        carga3.getMotor().setQtdPist(4);
        carga3.setCargaMax(6000);
        carga3.setTara(4000);
        System.out.println("***** CARGA 3 ******");
        System.out.println(carga3.toString());

        // Carga 4
        Carga carga4 = new Carga();
        carga4.setPlaca("WEA-1A55");
        carga4.setMarca("Volvo");
        carga4.setModelo("FH 750");
        carga4.setCor("Azul");
        carga4.setVelocMax(140);
        carga4.setQtdRodas(8);
        carga4.getMotor().setPotencia(300);
        carga4.getMotor().setQtdPist(6);
        carga4.setTara(7000);
        carga4.setCargaMax(5000);
        System.out.println("***** CARGA 4 ******");
        System.out.println(carga4.toString());

        // Carga 5
        Carga carga5 = new Carga();
        carga5.setPlaca("DEA-1A12");
        carga5.setMarca("Scania");
        carga5.setModelo("SC 23");
        carga5.setCor("Amarela");
        carga5.setVelocMax(174);
        carga5.setQtdRodas(12);
        carga5.getMotor().setPotencia(170);
        carga5.getMotor().setQtdPist(8);
        carga5.setCargaMax(10000);
        carga5.setTara(4500);
        System.out.println("***** CARGA 5 ******");
        System.out.println(carga5.toString());
    }
}