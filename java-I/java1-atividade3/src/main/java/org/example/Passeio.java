package org.example;

public final class Passeio extends  Veiculo{
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
        System.out.println("Velocidade Máxima em m/h: " + this.calcVel(this.getVelocMax()));
        System.out.println("************************************************************");
        return null;
    }

}
