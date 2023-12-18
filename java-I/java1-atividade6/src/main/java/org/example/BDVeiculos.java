package org.example;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
    private List<Passeio> listaPasseio;
    private List<Carga> listaCarga;

    public BDVeiculos() {
        this.listaCarga = new ArrayList<>();
        this.listaPasseio = new ArrayList<>();
    }

    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

}
