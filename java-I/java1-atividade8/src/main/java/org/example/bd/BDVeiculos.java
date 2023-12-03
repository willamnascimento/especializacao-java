package org.example.bd;

import org.example.classes.Carga;
import org.example.classes.Passeio;
import org.example.forms.CargaForms;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
    private List<Passeio> listaPasseio;
    private List<Carga> listaCarga;

    private static  BDVeiculos bdVeiculos;

    public static BDVeiculos initialize(){
        if (bdVeiculos == null)
            bdVeiculos = new BDVeiculos();
        return bdVeiculos;
    }

    private BDVeiculos() {
        this.listaCarga = new ArrayList<>();
        this.listaPasseio = new ArrayList<>();
    }

    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

    public void setListaPasseio(List<Passeio> listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public void setListaCarga(List<Carga> listaCarga) {
        this.listaCarga = listaCarga;
    }
}
