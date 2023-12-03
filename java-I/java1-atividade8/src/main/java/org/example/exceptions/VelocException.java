package org.example.exceptions;

public class VelocException extends Exception{
    public VelocException() {

    }

    public String ImprimeException(){
        return "A velocidade máxima está fora dos limites brasileiros";
    }
}
