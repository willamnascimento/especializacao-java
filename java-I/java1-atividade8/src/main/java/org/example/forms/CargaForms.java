package org.example.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CargaForms {
    JFrame frame;
    JButton btnCadastrar;
    JButton btnConsultarExcluir;
    JButton btnImprimir;
    JButton btnSair;
    JLabel lbCadastrar;
    JLabel lbConsultarExcluir;
    JLabel lbImprimir;
    JLabel lbSair;
    static CargaForms form;

    private CargaForms() {
        initComponent();
    }

    public static CargaForms initialize() {
        if (form == null)
            form = new CargaForms();
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

        frame.setSize(250,400);
        frame.setTitle("Veículos de Carga");

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
        CadastrarCargaForms.initialize();
    }

    private void btnConsultarExcluir_click(ActionEvent evt){
        ConsultarCargaForms.initialize();
    }

    private void btnImprimir_click(ActionEvent evt){
        ImprimirCargaForms.initialize();
    }

    private void btnSair_click(ActionEvent evt){
        frame.dispose();
        form = null;
    }
}
