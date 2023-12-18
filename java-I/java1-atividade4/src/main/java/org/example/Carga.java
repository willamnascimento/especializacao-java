package org.example;

public final class Carga extends  Veiculo implements Calcular{
    private int cargaMax;
    private int tara;

    public Carga() {
        this.cargaMax = 0;
        this.tara = 0;
    }

    @Override
    public float calcVel(float velocMax) {
        return this.getVelocMax() * 100000;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

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
        System.out.println("Tara: " + this.getTara());
        System.out.println("Carga Max: " + this.getCargaMax());
        System.out.println("Velocidade Máxima em cm/h: " + this.calcVel(this.getVelocMax()));
        System.out.println("************************************************************");
        return null;
    }

    @Override
    public int calcular() {
        return this.getTara() + this.getCargaMax() + this.getQtdRodas() + Math.round(this.getVelocMax());
    }
}
