package org.example.classes;

import org.example.interfaces.Calcular;

public final class Passeio extends  Veiculo implements Calcular {
    private int qtdPassageiros;

    public Passeio() {
        this.qtdPassageiros = 0;
    }

    @Override
    public float calcVel(float velocMax) {
        return this.getVelocMax() * 1000;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public int calcular() {
        return this.getCor().length() + this.getModelo().length() + this.getMarca().length() + this.getPlaca().length();
    }

    // Sobrecarga do metodo toString para imprimir o objeto
    @Override
    public String toString(){

        System.out.println("Placa: " + this.getPlaca());
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Cor: " + this.getCor());
        System.out.println("Velocidade Maxima: " + this.getVelocMax());
        System.out.println("Quantidade Rodas: " + this.getQtdRodas());
        System.out.println("Motor -> Potencia: " + this.getMotor().getPotencia());
        System.out.println("Motor -> Qtd Pistao: " + this.getMotor().getQtdPist());
        System.out.println("Qtd Passageiro: " + this.getQtdPassageiros());
        System.out.println("Velocidade Máxima em m/h: " + String.format("%.2f", this.calcVel(this.getVelocMax())));
        System.out.println("Valor calculado interface: " + this.calcular());
        System.out.println("************************************************************");
        return null;
    }
}
