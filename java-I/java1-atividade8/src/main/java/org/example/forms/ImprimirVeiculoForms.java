package org.example.forms;

import org.example.bd.BDVeiculos;
import org.example.classes.Carga;
import org.example.classes.Passeio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ImprimirVeiculoForms {
    JFrame frame;
    String[] colunas = {"Placa", "Marca","Modelo", "Cor", "Qtd. Rodas", "Veloc Máx", "Qtd Pist", "Potencia", "Qtd Passageiros"};

    DefaultTableModel model = new DefaultTableModel(colunas,0);
    JTable tabela= new JTable(model);
    JScrollPane barraRolagem = new JScrollPane(tabela);
    JButton btnImprimirTodos;
    JButton btnExcluirTodos;
    JButton btnSair;
    BDVeiculos bdVeiculos;
    static ImprimirVeiculoForms form;


    private ImprimirVeiculoForms() {
        initComponent();
        bdVeiculos = BDVeiculos.initialize();
    }

    public static ImprimirVeiculoForms initialize(){
        if (form == null)
            form = new ImprimirVeiculoForms();
        return form;
    }

    private void initComponent(){
        frame = new JFrame();
        btnImprimirTodos = new JButton();
        btnExcluirTodos = new JButton();
        btnSair = new JButton();

        frame.setLayout(new GridLayout(4,1,10,10));
        frame.setSize(600,500);
        frame.setTitle("Imprimir/Excluir todos");
        frame.getContentPane().setBackground(Color.WHITE);

        btnImprimirTodos.setText("Imprimir Todos");
        btnImprimirTodos.setMnemonic('I');

        btnExcluirTodos.setText("Excluir Todos");
        btnExcluirTodos.setMnemonic('E');

        btnSair.setText("Sair");
        btnSair.setMnemonic('S');

        btnImprimirTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirTodos_click(evt);
            }
        });

        btnExcluirTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTodos_click(evt);
            }
        });

        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair_click(evt);
            }
        });

        frame.add(barraRolagem);
        frame.add(btnImprimirTodos);
        frame.add(btnExcluirTodos);
        frame.add(btnSair);

        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    private void btnImprimirTodos_click(ActionEvent evt){
        imprimePasseio();
    }

    private void btnExcluirTodos_click(ActionEvent evt){
        excluiPasseio();
    }

    private void btnSair_click(ActionEvent evt){
        frame.dispose();
        form = null;
    }

    public void excluiPasseio(){
        if(bdVeiculos.getListaPasseio().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Não há veiculos de passeios para serem removidas." , "ERRO",  JOptionPane.ERROR_MESSAGE);
        }else {
            int dialogResult = JOptionPane.showConfirmDialog (null, "Você gostaria de excluir os todos os veiculos de passeio?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                bdVeiculos.setListaPasseio(new ArrayList<>());
                DefaultTableModel dm = (DefaultTableModel)tabela.getModel();
                dm.getDataVector().removeAllElements();
                dm.fireTableDataChanged();
            }
        }
    }

    public void imprimePasseio() {
        if(bdVeiculos.getListaPasseio().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Não há veiculos de passeios cadastrados." , "ERRO",  JOptionPane.ERROR_MESSAGE);
        }else {
            model = new DefaultTableModel(colunas,0);
            for(Passeio passeio : bdVeiculos.getListaPasseio()) {
                String[] dados = {passeio.getPlaca(),
                        passeio.getMarca(),
                        passeio.getModelo(),
                        passeio.getCor(),
                        String.valueOf(passeio.getQtdRodas()),
                        String.valueOf(passeio.getVelocMax()),
                        String.valueOf(passeio.getMotor().getQtdPist()),
                        String.valueOf(passeio.getMotor().getPotencia()),
                        String.valueOf(passeio.getQtdPassageiros())};
                model.addRow(dados);
            }
            tabela.setModel(model);
        }
    }
}
