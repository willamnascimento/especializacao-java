package org.example.forms;

import org.example.bd.BDVeiculos;
import org.example.classes.Passeio;
import org.example.exceptions.VelocException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CadastrarPasseioForms {
    static CadastrarPasseioForms form;
    JFrame frame;
    JLabel lbQtdPassageiros;
    JTextField txtQtdPassageiros;
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

    Passeio passeio;
    BDVeiculos bdVeiculos;

    private CadastrarPasseioForms() {
        initComponent();
        bdVeiculos = BDVeiculos.initialize();
    }

    public static CadastrarPasseioForms initialize() {
        if (form == null)
            form = new CadastrarPasseioForms();
        return form;
    }

    private void initComponent(){
        frame = new JFrame();
        lbQtdPassageiros = new JLabel();
        txtQtdPassageiros = new JTextField(20);
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

        frame.setSize(380,400);
        frame.setTitle("Cadastro de Passeio");

        lbQtdPassageiros.setText("Qtd Passageiros:");
        lbPlaca.setText("Placa:          ");
        lbMarca.setText("Marca:          ");
        lbModelo.setText("Modelo:        ");
        lbCor.setText("Cor:            ");
        lbQtdRodas.setText("Qtd Rodas:      ");
        lbVelocidadeMax.setText("Veloc Max:       ");
        lbQtdPistoes.setText("Qtd Pistoes:    ");
        lbPotencia.setText("Potencia:        ");
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

        frame.add(lbQtdPassageiros);
        frame.add(txtQtdPassageiros);
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
        passeio = new Passeio();
        try {
            passeio.setQtdPassageiros(Integer.parseInt(txtQtdPassageiros.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Qtd Passageiros tem que ser Inteiro! ");
            return;
        }

        passeio.setCor(txtCor.getText());
        passeio.setMarca(txtMarca.getText());
        passeio.setModelo(txtModelo.getText());
        passeio.setPlaca(txtPlaca.getText());
        try {
            passeio.setQtdRodas(Integer.parseInt(txtQtdRodas.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Qtd Rodas tem que ser Inteiro! ");
            txtQtdRodas.setFocusable(true);
            return;
        }
        try {
            passeio.setVelocMax(Float.parseFloat(txtVelocidadeMax.getText()));
        }catch (VelocException ex){
            passeio.setVelocMax(100);
            JOptionPane.showMessageDialog(null, ex.ImprimeException());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Velocidade Maxima tem que ser Numeral! ");
            return;
        }
        try {
            passeio.getMotor().setPotencia(Integer.parseInt(txtPotencia.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Potencia tem que ser Inteiro! ");
            txtPotencia.setFocusable(true);
            return;
        }
        try {
            passeio.getMotor().setQtdPist(Integer.parseInt(txtQtdPistoes.getText()));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A Qtd Pistoes tem que ser Inteiro! ");
            txtQtdPistoes.setFocusable(true);

            return;
        }

        bdVeiculos.getListaPasseio().add(passeio);

        JOptionPane.showMessageDialog(null, "Os dados do veículo de passeio foram adicionados! ");
    }

    private void btnLimpar_click(ActionEvent evt){
        Limpar();
    }

    private void btnNovo_click(ActionEvent evt){
        passeio = new Passeio();
        Limpar();
    }

    private void btnSair_click(ActionEvent evt){
        for (Passeio p : bdVeiculos.getListaPasseio()){
            System.out.println(p.toString());
        }

        frame.dispose();
        form = null;
    }

    private void Limpar(){
        txtPotencia.setText("");
        txtQtdPistoes.setText("");
        txtQtdPassageiros.setText("");
        txtMarca.setText("");
        txtPlaca.setText("");
        txtQtdPistoes.setText("");
        txtModelo.setText("");
        txtCor.setText("");
        txtQtdRodas.setText("");
        txtVelocidadeMax.setText("");
    }
}
