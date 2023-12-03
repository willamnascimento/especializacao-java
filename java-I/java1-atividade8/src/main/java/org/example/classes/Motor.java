package org.example.classes;

public class Motor {
    private int qtdPist;
    private int potencia;

    public Motor(){
        this.potencia = 0;
        this.qtdPist = 0;
    }

    public int getQtdPist() {
        return qtdPist;
    }

    public final void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public final void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }
}
