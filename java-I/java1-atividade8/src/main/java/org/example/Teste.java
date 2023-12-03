package org.example;

import org.example.bd.BDVeiculos;
import org.example.classes.Carga;
import org.example.classes.Leitura;
import org.example.classes.Passeio;
import org.example.exceptions.VeicExistException;
import org.example.exceptions.VelocException;
import org.example.forms.Principal;

public class Teste {

    public static Leitura ler = new Leitura();
    public static int menu = 0;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal();
            }
        });
    }
}