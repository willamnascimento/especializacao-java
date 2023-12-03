package org.example.forms;

import org.example.bd.BDVeiculos;
import org.example.classes.Carga;
import org.example.exceptions.VelocException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConsultarCargaForms {

    private static ConsultarCargaForms form;
    JFrame frame;
    JLabel lbTara;
    JTextField txtTara;
    JLabel lbCargaMax;
    JTextField txtCargaMax;
    JLabel lbPlaca;
    JTextField txtPlaca;
    JLabel lbMarca;
    JTextField txtMarca;
    JLabel lbModelo;
    JTextField txtModelo;
    JLabel lbCor;
    JTextField txtCor;
    JLabel lbQtdRodas;
    JTextField txtQtdRodas;
    JLabel lbVelocidadeMax;
    JTextField txtVelocidadeMax;
    JLabel lbQtdPistoes;
    JTextField txtQtdPistoes;
    JLabel lbPotencia;
    JTextField txtPotencia;
    JButton btnConsultar;
    JButton btnExcluir;
    JButton btnSair;

    Carga carga;
    BDVeiculos bdVeiculos;

    private ConsultarCargaForms() {
        initComponent();
        bdVeiculos = BDVeiculos.initialize();
    }

    public static ConsultarCargaForms initialize(){
        if (form == null)
            form = new ConsultarCargaForms();
        return form;
    }

    private void initComponent(){
        frame = new JFrame();
        lbTara = new JLabel();
        txtTara = new JTextField(20);
        lbCargaMax = new JLabel();
        txtCargaMax = new JTextField(20);
        lbPlaca= new JLabel();
        txtPlaca = new JTextField(20);
        lbMarca= new JLabel();
        txtMarca = new JTextField(20);
        lbModelo= new JLabel();
        txtModelo = new JTextField(20);
        lbCor= new JLabel();
        txtCor = new JTextField(20);
        lbQtdRodas= new JLabel();
        txtQtdRodas = new JTextField(20);
        lbVelocidadeMax = new JLabel();
        txtVelocidadeMax = new JTextField(20);
        lbQtdPistoes = new JLabel();
        txtQtdPistoes = new JTextField(20);
        lbPotencia = new JLabel();
        txtPotencia = new JTextField(20);

        btnConsultar = new JButton();
        btnExcluir = new JButton();
        btnSair = new JButton();

        frame.setSize(380,400);
        frame.setTitle("Consultar/Excluir pela placa");

        lbTara.setText("Tara:           ");
        lbCargaMax.setText("Carga Max:      ");
        lbPlaca.setText("Informe a Placa:");
        lbMarca.setText("Marca:          ");
        lbModelo.setText("Modelo:        ");
        lbCor.setText("Cor:            ");
        lbQtdRodas.setText("Qtd Rodas:      ");
        lbVelocidadeMax.setText("Veloc Max:      ");
        lbQtdPistoes.setText("Qtd Pistoes:    ");
        lbPotencia.setText("Potencia:       ");

        btnConsultar.setText("Consultar");
        btnExcluir.setText("Excluir");
        btnSair.setText("Sair");


        /*EVENTOS*/
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)  {
                btnConsultar_click(evt);
            }
        });

        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir_click(evt);
            }
        });

        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair_click(evt);
            }
        });

        frame.add(lbPlaca);
        frame.add(txtPlaca);
        frame.add(lbTara);
        frame.add(txtTara);
        frame.add(lbCargaMax);
        frame.add(txtCargaMax);
        frame.add(lbMarca);
        frame.add(txtMarca);
        frame.add(lbModelo);
        frame.add(txtModelo);
        frame.add(lbCor);
        frame.add(txtCor);
        frame.add(lbQtdRodas);
        frame.add(txtQtdRodas);
        frame.add(lbVelocidadeMax);
        frame.add(txtVelocidadeMax);
        frame.add(lbQtdPistoes);
        frame.add(txtQtdPistoes);
        frame.add(lbPotencia);
        frame.add(txtPotencia);
        frame.add(btnConsultar);
        frame.add(btnExcluir);
        frame.add(btnSair);

        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

    }

    private void btnConsultar_click(ActionEvent evt) {
        String placa = txtPlaca.getText();
        carga = bdVeiculos.getListaCarga()
                .stream()
                .filter(c -> c.getPlaca().equals(placa))
                .findAny()
                .orElse(null);

        if (carga == null) {
            JOptionPane.showMessageDialog(null, "Placa informada não foi encontrada ");
            txtTara.setFocusable(true);
            return;
        }

        txtTara.setText(Integer.toString(carga.getTara()));
        txtCargaMax.setText(Integer.toString(carga.getCargaMax()));
        txtCor.setText(carga.getCor());
        txtMarca.setText(carga.getMarca());
        txtModelo.setText(carga.getModelo());
        txtQtdRodas.setText(Integer.toString(carga.getQtdRodas()));
        txtVelocidadeMax.setText(Float.toString(carga.getVelocMax()));
        txtPotencia.setText(Integer.toString(carga.getMotor().getPotencia()));
        txtQtdPistoes.setText(Integer.toString(carga.getMotor().getQtdPist()));

    }
    private void btnExcluir_click(ActionEvent evt){
        int dialogResult = JOptionPane.showConfirmDialog (null, "Você gostaria de excluir esse veiculo?","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            bdVeiculos.getListaCarga().remove(carga);
            Limpar();
        }
    }

    private void btnSair_click(ActionEvent evt){
        frame.dispose();
        form = null;
    }

    private void Limpar(){
        txtPotencia.setText("");
        txtQtdPistoes.setText("");
        txtMarca.setText("");
        txtPlaca.setText("");
        txtTara.setText("");
        txtCargaMax.setText("");
        txtModelo.setText("");
        txtCor.setText("");
        txtQtdRodas.setText("");
        txtVelocidadeMax.setText("");
    }


}
