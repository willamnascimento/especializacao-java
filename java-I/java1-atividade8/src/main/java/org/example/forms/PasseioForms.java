package org.example.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PasseioForms {
    JFrame frame;
    static PasseioForms form;
    JButton btnCadastrar;
    JButton btnConsultarExcluir;
    JButton btnImprimir;
    JButton btnSair;
    JLabel lbCadastrar;
    JLabel lbConsultarExcluir;
    JLabel lbImprimir;
    JLabel lbSair;

    private PasseioForms() {
        initComponent();
    }

    public static PasseioForms initialize(){
        if (form == null)
            form = new PasseioForms();
        return form;
    }

    private void initComponent(){
        frame = new JFrame();

        btnCadastrar = new JButton();
        btnConsultarExcluir = new JButton();
        btnImprimir = new JButton();
        btnSair = new JButton();
        lbCadastrar = new JLabel();
        lbConsultarExcluir = new JLabel();
        lbImprimir = new JLabel();
        lbSair = new JLabel();

        frame.setSize(310,400);
        frame.setTitle("Veículos de Passeio");


        btnCadastrar.setText("Cadastrar");
        btnConsultarExcluir.setText("Consultar/Excluir pela placa");
        btnImprimir.setText("Imprimir/Excluir todos");
        btnSair.setText("Sair");

        /*EVENTOS*/
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar_click(evt);
            }
        });

        btnConsultarExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarExcluir_click(evt);
            }
        });

        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir_click(evt);
            }
        });

        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair_click(evt);
            }
        });

        frame.add(btnCadastrar);
        frame.add(btnConsultarExcluir);
        frame.add(btnImprimir);
        frame.add(btnSair);


        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    private void btnCadastrar_click(ActionEvent evt){
        CadastrarPasseioForms.initialize();
    }

    private void btnConsultarExcluir_click(ActionEvent evt){
        ConsultarPasseioForms.initialize();
    }

    private void btnImprimir_click(ActionEvent evt){
        ImprimirVeiculoForms.initialize();
    }

    private void btnSair_click(ActionEvent evt){
        frame.dispose();
        form = null;
    }
}
