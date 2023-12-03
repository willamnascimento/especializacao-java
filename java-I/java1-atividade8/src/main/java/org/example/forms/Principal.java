package org.example.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Principal{
    JFrame frame;
    JButton btnPasseio;
    JButton btnCarga;
    JLabel lbPasseio;
    JLabel lbCarga;
    public Principal() {
        initComponent();
    }

    private void initComponent(){
        frame = new JFrame();
        btnPasseio = new JButton();
        btnCarga = new JButton();
        lbCarga = new JLabel();
        lbPasseio = new JLabel();

        frame.setSize(900,400);
        frame.setTitle("Gestão de Veículos");

        btnPasseio.setText("Passeio");
        btnCarga.setText("Carga");

        btnPasseio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasseio_click(evt);
            }
        });

        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarga_click(evt);
            }
        });

        frame.add(btnPasseio);
        frame.add(btnCarga);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    private void btnPasseio_click(ActionEvent evt){
        PasseioForms.initialize();
    }

    private void btnCarga_click(ActionEvent evt){
        CargaForms.initialize();
    }
}
