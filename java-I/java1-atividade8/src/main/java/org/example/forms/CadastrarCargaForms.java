package org.example.forms;

import org.example.bd.BDVeiculos;
import org.example.classes.Carga;
import org.example.exceptions.VelocException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CadastrarCargaForms {
    static CadastrarCargaForms form;
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
    JButton btnCadastrar;
    JButton btnLimpar;
    JButton btnNovo;
    JButton btnSair;

    Carga carga;
    BDVeiculos bdVeiculos;
    private CadastrarCargaForms() {
        initComponent();
        bdVeiculos = BDVeiculos.initialize();
    }

    public static CadastrarCargaForms initialize() {
        if (form == null)
            form = new CadastrarCargaForms();
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
        btnCadastrar = new JButton();
        btnLimpar = new JButton();
        btnNovo = new JButton();
        btnSair = new JButton();

        frame.setSize(350,400);
        frame.setTitle("Cadastro de Carga");

        lbTara.setText("Tara:        ");
        lbCargaMax.setText("Carga Max:   ");
        lbPlaca.setText("Placa:       ");
        lbMarca.setText("Marca:       ");
        lbModelo.setText("Modelo:     ");
        lbCor.setText("Cor:         ");
        lbQtdRodas.setText("Qtd Rodas:   ");
        lbVelocidadeMax.setText("Veloc Max:   ");
        lbQtdPistoes.setText("Qtd Pistoes: ");
        lbPotencia.setText("Potencia:    ");
        btnSair.setText("Sair");
        btnNovo.setText("Novo");
        btnLimpar.setText("Limpar");
        btnCadastrar.setText("Cadastrar");

        /*EVENTOS*/
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)  {
                try {
                    btnCadastrar_click(evt);
                } catch (VelocException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar_click(evt);
            }
        });

        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovo_click(evt);
            }
        });

        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair_click(evt);
            }
        });

        frame.add(lbTara);
        frame.add(txtTara);
        frame.add(lbCargaMax);
        frame.add(txtCargaMax);
        frame.add(lbPlaca);
        frame.add(txtPlaca);
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
        frame.add(btnCadastrar);
        frame.add(btnLimpar);
        frame.add(btnNovo);
        frame.add(btnSair);

        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    private void btnCadastrar_click(ActionEvent evt) throws VelocException {
        carga = new Carga();
        try {
            carga.setTara(Integer.parseInt(txtTara.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Tara tem que ser Inteiro! ");
            txtTara.setFocusable(true);
            return;
        }
        try {
            carga.setCargaMax(Integer.parseInt(txtCargaMax.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Carga Maxima tem que ser Inteiro! ");
            txtCargaMax.setFocusable(true);
            return;
        }
        carga.setCor(txtCor.getText());
        carga.setMarca(txtMarca.getText());
        carga.setModelo(txtModelo.getText());
        carga.setPlaca(txtPlaca.getText());
        try {
            carga.setQtdRodas(Integer.parseInt(txtQtdRodas.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Qtd Rodas tem que ser Inteiro! ");
            txtQtdRodas.setFocusable(true);
            return;
        }
        try {
            carga.setVelocMax(Float.parseFloat(txtVelocidadeMax.getText()));
        }catch (VelocException ex){
            carga.setVelocMax(90);
            JOptionPane.showMessageDialog(null, ex.ImprimeException());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Velocidade Maxima tem que ser Numeral! ");
            return;
        }
        try {
            carga.getMotor().setPotencia(Integer.parseInt(txtPotencia.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Potencia tem que ser Inteiro! ");
            txtPotencia.setFocusable(true);
            return;
        }
        try {
            carga.getMotor().setQtdPist(Integer.parseInt(txtQtdPistoes.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Qtd Pistoes tem que ser Inteiro! ");
            txtQtdPistoes.setFocusable(true);

            return;
        }

        bdVeiculos.getListaCarga().add(carga);

        JOptionPane.showMessageDialog(null, "Os dados do veículo de carga foram adicionados! ");
    }

    private void btnLimpar_click(ActionEvent evt){
        Limpar();
    }

    private void btnNovo_click(ActionEvent evt){
        carga = new Carga();
        Limpar();
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
