/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import util.*;
import javax.swing.*;


public class PedidoGUI extends javax.swing.JFrame {

    //instancia um novo objeto ClienteDAO para dar acesso aos metodos dos clientes
    ClienteDAO clienteDao = new ClienteDAO();
    
    PedidoDAO pedidoDao = new PedidoDAO();

    //recupera os dados do cadastro para dentro do ArrayList cad
    ArrayList<Cliente> cad = clienteDao.list();
    
    //sinaliza a bandeira
    int operacao = 1;

    
    /**
     * Creates new form ClienteGUI
     */
    public PedidoGUI() {
       
        
        initComponents();
        

        /* aqui gera os primeiros clientes pra não começar em branco
	fizemos um for bem simples, somente para ter dados no inicio
        
        for (int i = 0; i < 5; i++) {
            Cliente novo = new Cliente("Cliente " + i, 00 + i);
            novo.setEnderco("rua " + i * 2);
            novo.setTelefone(519703838);
            novo.setNumero(i + 5);
            novo.setBairro("Centro");
            novo.setCidade("Osório");
            novo.setAtivo(true);

            clienteDao.inserir(novo);
            novo.gerarCod(cad);
        }*/

        // aqui verifica se o ArrayList não esta vazio, caso não esteja já popula a jtable
         ArrayList<Cliente> cad = clienteDao.list();
         
         if (cad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro vazio");
        } else {
            for (int i = 0; i < cad.size(); i++) {
                DefaultTableModel model = (DefaultTableModel) tbClientes.getModel();
                Object[] rowData = {""};
                model.addRow(rowData);
                tbClientes.setValueAt(cad.get(i).getNome(), i, 0);
                tbClientes.setValueAt(cad.get(i).getTelefone(), i, 1);
                tbClientes.setValueAt(cad.get(i).getEnderco(), i, 2);
                tbClientes.setValueAt(cad.get(i).getNumero(), i, 3);
                tbClientes.setValueAt(cad.get(i).getBairro(), i, 4);
                tbClientes.setValueAt(cad.get(i).getCidade(), i, 5);
                tbClientes.setValueAt(cad.get(i).getInativo(), i, 6);
            }
        }
         
        
         
        //desabilita os botoes 
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        jComboBoxClientes.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastroClientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfCpf = new javax.swing.JTextField();
        tfDataEntrega = new javax.swing.JTextField();
        tfValorProdutos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfObservacao = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tfQtdProdutos = new javax.swing.JTextField();
        tfApto = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        tfDataPagamento = new javax.swing.JTextField();
        tfCep = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluirPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        tfCodigoPedido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jlStatusPagamento = new javax.swing.JLabel();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        btAlterarStatusPagamentoSalvar = new javax.swing.JButton();
        btAlterarStatusPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Pedidos");
        setResizable(false);

        cadastroClientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cadastroClientesMouseMoved(evt);
            }
        });
        cadastroClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento de Pedidos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cadastroClientes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 910, 50));

        jLabel2.setText("*Cliente");
        cadastroClientes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 61, 30));

        tfNome.setEnabled(false);
        cadastroClientes.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, -1));

        tfCpf.setEnabled(false);
        cadastroClientes.add(tfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 150, -1));

        tfDataEntrega.setEnabled(false);
        cadastroClientes.add(tfDataEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 150, -1));

        tfValorProdutos.setEnabled(false);
        cadastroClientes.add(tfValorProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 170, -1));

        jLabel4.setText("*Quantidade de Produtos");
        cadastroClientes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, 30));

        jLabel6.setText("*Valor Produtos");
        cadastroClientes.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 100, 20));

        jLabel7.setText("*Data da Entrega (31/12/2023)");
        cadastroClientes.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 160, 30));

        jLabel8.setText("Data do Pagamento (31/12/2023)");
        cadastroClientes.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 180, 30));

        tfObservacao.setEnabled(false);
        cadastroClientes.add(tfObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 90, -1));

        tfEndereco.setEnabled(false);
        cadastroClientes.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 60, -1));
        cadastroClientes.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, -1, -1));

        tfQtdProdutos.setEnabled(false);
        cadastroClientes.add(tfQtdProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 110, -1));

        tfApto.setEnabled(false);
        cadastroClientes.add(tfApto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 70, -1));

        tfBairro.setEnabled(false);
        cadastroClientes.add(tfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 80, -1));

        tfDataPagamento.setEnabled(false);
        cadastroClientes.add(tfDataPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 130, -1));

        tfCep.setEnabled(false);
        cadastroClientes.add(tfCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 80, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("MENU CLIENTE"));
        jPanel2.setLayout(null);
        cadastroClientes.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 120, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENU CLIENTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setLayout(null);

        btNovo.setText("NOVO");
        btNovo.setToolTipText("");
        btNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel3.add(btNovo);
        btNovo.setBounds(10, 20, 98, 50);

        btEditar.setText("EDITAR");
        btEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btEditar);
        btEditar.setBounds(10, 80, 98, 50);

        btExcluirPedido.setText("Excluir");
        btExcluirPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btExcluirPedido.setEnabled(false);
        btExcluirPedido.setMargin(new java.awt.Insets(2, 0, 3, 0));
        btExcluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirPedidoActionPerformed(evt);
            }
        });
        jPanel3.add(btExcluirPedido);
        btExcluirPedido.setBounds(10, 140, 100, 50);

        cadastroClientes.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 120, 200));

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "Endereço", "Número", "Bairro", "Cidade", "Obs Inativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);
        if (tbClientes.getColumnModel().getColumnCount() > 0) {
            tbClientes.getColumnModel().getColumn(0).setPreferredWidth(4);
            tbClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbClientes.getColumnModel().getColumn(2).setPreferredWidth(70);
            tbClientes.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbClientes.getColumnModel().getColumn(4).setPreferredWidth(2);
        }

        cadastroClientes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 910, 280));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tfCodigoPedido.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        tfCodigoPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CÓDIGO DO PEDIDO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCodigoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        cadastroClientes.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 120, 70));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menino2.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastroClientes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 180));

        btSalvar.setText("SALVAR");
        btSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        cadastroClientes.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 140, 50));

        btCancelar.setText("CANCELAR");
        btCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        cadastroClientes.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 130, 50));

        jLabel19.setText("* Campos Obrigatórios.");
        cadastroClientes.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, -1, -1));

        tfCidade.setEnabled(false);
        cadastroClientes.add(tfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 90, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("STATUS DO PAGAMENTO:");
        cadastroClientes.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 190, -1));

        jlStatusPagamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlStatusPagamento.setText("______________");
        jlStatusPagamento.setEnabled(false);
        cadastroClientes.add(jlStatusPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 20));

        jComboBoxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione Cliente" }));
        jComboBoxClientes.setEnabled(false);
        jComboBoxClientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jComboBoxClientesMouseMoved(evt);
            }
        });
        jComboBoxClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxClientesMouseClicked(evt);
            }
        });
        jComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientesActionPerformed(evt);
            }
        });
        cadastroClientes.add(jComboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 180, -1));

        btAlterarStatusPagamentoSalvar.setText("ALTERAR STATUS");
        btAlterarStatusPagamentoSalvar.setEnabled(false);
        cadastroClientes.add(btAlterarStatusPagamentoSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 140, 50));

        btAlterarStatusPagamento.setText("Alterar");
        btAlterarStatusPagamento.setEnabled(false);
        btAlterarStatusPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarStatusPagamentoActionPerformed(evt);
            }
        });
        cadastroClientes.add(btAlterarStatusPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 70, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cadastroClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cadastroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastroClientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastroClientesMouseMoved

    }//GEN-LAST:event_cadastroClientesMouseMoved

    private void jComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClientesActionPerformed

    private void jComboBoxClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxClientesMouseClicked

    }//GEN-LAST:event_jComboBoxClientesMouseClicked

    private void jComboBoxClientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxClientesMouseMoved

    }//GEN-LAST:event_jComboBoxClientesMouseMoved

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        Util.EditarFrame.limparDados(this);
        Util.EditarFrame.desativaCampos(this);
        btNovo.setEnabled(true);
        btEditar.setEnabled(false);
        btExcluirPedido.setEnabled(false);
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        tfCodigoPedido.setText("");
        tbClientes.setVisible(true);
        tfNome.requestFocus();
        btAlterarStatusPagamento.setEnabled(false);
        jComboBoxClientes.setEnabled(false);
        operacao = 1;
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        // aqui foi feito os blocos try catch em conjunto com if verificando campo abrigatorio e se é numerico pela exceção
        
        //criado objeto Pedidos
        Pedido pedido = new Pedido();
        
        
        if (!"".equals(tfQtdProdutos.getText())) {
            try {
                String qtdProdutos = tfQtdProdutos.getText().replace(',', '.');
                float qtdProdutosFloat = Float.parseFloat(qtdProdutos);
                pedido.setQtd_produto(qtdProdutosFloat);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro no campo Quantidade de Produtos, valor não é numérico!");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O campo Quantidade de Produtos é OBRIGATÓRIO!!");
            return;
        }
              
        if (!"".equals(tfValorProdutos.getText())) {
            try {
                String valorProdutos = tfValorProdutos.getText().replace(',', '.');
                float valorProdutosFloat = Float.parseFloat(valorProdutos);
                pedido.setValor_produtos(valorProdutosFloat);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro no campo Valor Produtos, valor não é numérico!");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O campo Valor Produtos é OBRIGATÓRIO!!");
            return;
        }
        
        if(!"".equals(jlStatusPagamento.getText())){
            String status = jlStatusPagamento.getText();
            if("Pago".equals(status)){
                pedido.setPagamento(true);
            }else if ("Pendente".equals(status)){
                pedido.setPagamento(false);
            }else{
                JOptionPane.showMessageDialog(null, "Erro no campo STATUS DO PAGAMENTO, valor incorreto!");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "O campo STATUS DO PAGAMENTO é OBRIGATÓRIO!!");
            return;
        }
        
        // pega o campo data de entrega
        String dataEntregaTemp = tfDataEntrega.getText();
        if(!"".equals(dataEntregaTemp)){
            try {
                // Criar um formato de data
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

                // Converter o texto para um objeto Date
                Date dataEntrega = formatoData.parse(dataEntregaTemp);

                pedido.setEntrega(dataEntrega);
                
            } catch (ParseException e) {
                // Tratar a exceção se o formato da data estiver incorreto
                JOptionPane.showMessageDialog(null, "Erro no campo DATA DA ENTREGA, DIGITE CORRETAMENTE! (dd/MM/yyyy)");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "O campo DATA DA ENTREGA É OBRIGATÓRIO!!");
            return;
        }
        
        // pega o campo data de pagamento
        String dataPagamentoTemp = tfDataPagamento.getText();
        if(!"".equals(dataPagamentoTemp)){
            try {
                // Criar um formato de data
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

                // Converter o texto para um objeto Date
                Date dataPagamento = formatoData.parse(dataPagamentoTemp);

                pedido.setData_pagamento(dataPagamento);
                
            } catch (ParseException e) {
                // Tratar a exceção se o formato da data estiver incorreto
                JOptionPane.showMessageDialog(null, "Erro no campo DATA PAGAMENTO, DIGITE CORRETAMENTE! (dd/MM/yyyy)");
                return;
            }
        }
        
        // pega codigo do clienteDao do clienteDao selecionado
            String codClienteTemp = jComboBoxClientes.getSelectedItem().toString();
        
            //converte para inteiro
            StringBuilder numeros = new StringBuilder();

            // Iterar pelos caracteres na string
            for (char c : codClienteTemp.toCharArray()) {
                // Verificar se o caractere é um dígito
                if (Character.isDigit(c)) {
                    // Adicionar o dígito à sequência de números
                    numeros.append(c);
                } else if (c == ' ') {
                    // Se encontrarmos um espaço, parar a iteração
                    break;
                }
            }

            // converte para int
            int codClienteSelecionado = Integer.parseInt(numeros.toString());
                    
              
            //aqui é verificada qual o botão e chamado o metodo correspondente, 0 inserir, 1 editar ou 2 excluir
            if (operacao == 0) {
                if (pedidoDao.inserir(pedido)) {
                    JOptionPane.showMessageDialog(null, "Inserido com sucesso!!");
                    //pedido.gerarCod(cad);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro na inserção do Pedido!!");
                }
//            } else if (operacao == 1) {
//                //c.setCodCliente(Integer.parseInt(tfCodigo.getText()));
//                if (clienteDao.editar(c)) {
//                    JOptionPane.showMessageDialog(null, "Alterado com sucesso!!");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Erro ao alterar o Cliente!!");
//                }
//            } else if (operacao == 2) {
//                c.setCodCliente(Integer.parseInt(tfCodigoPedido.getText()));
//                String texto = JOptionPane.showInputDialog(null, "Tem certeza que deseja DESABILITAR o cliente???\nIngresse o motivo da desabilitação.");
//
//                c.setInativo(texto);
//
//                //o metodo excluir, na verdade não exclui oo objeto, ele apenas marco o atributo Ativo como false.
//                if (clienteDao.excluir(c)) {
//                    JOptionPane.showMessageDialog(null, "Desabilitado com Sucesso!!");
//                    dispose();
//                    new PedidoGUI().setVisible(true);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Erro ao Desabilitar o Cliente!!");
//                }
            }
            

            //manipulação dos botões
            btNovo.setEnabled(true);
            btEditar.setEnabled(true);
            btExcluirPedido.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            tfNome.requestFocus();

            //aqui ele verifica se o ArrayList não é vazio
            if (cad.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Cadastro vazio");
            } else {
                //captura o modelo da tabela, cria nova linha e aplica o modelo
                if(operacao == 0){
                    DefaultTableModel model = (DefaultTableModel) tbClientes.getModel();
                    Object[] rowData = {""};
                    model.addRow(rowData);
                }

                //seta os valores dos atributos do clienteDao nas colunas da tabela
                cad = clienteDao.list();
                for (int i = 0; i <cad.size() ; i++) {

                    tbClientes.setValueAt(cad.get(i).getNome(), i, 0);
                    tbClientes.setValueAt(cad.get(i).getTelefone(), i, 1);
                    tbClientes.setValueAt(cad.get(i).getEnderco(), i, 2);
                    tbClientes.setValueAt(cad.get(i).getNumero(), i, 3);
                    tbClientes.setValueAt(cad.get(i).getBairro(), i, 4);
                    tbClientes.setValueAt(cad.get(i).getCidade(), i, 5);
                }
            }

            //limpa e desativa os campos
            Util.EditarFrame.limparDados(this);
            Util.EditarFrame.desativaCampos(this);

            //manipula os botoes
            tfCodigoPedido.setText("");
            btEditar.setEnabled(false);
            btExcluirPedido.setEnabled(false);
            btSalvar.setText("SALVAR");
            btSalvar.setEnabled(false);
            tbClientes.setVisible(true);
            operacao = 1;
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked

        // Obtém o modelo de seleção de linha da JTable
        ListSelectionModel selectionModel = tbClientes.getSelectionModel();

        // Adiciona um MouseListener para tratar o evento de clique
        //tbClientes.addMouseListener(new MouseAdapter(){});

        // Obtém o índice da linha clicada
        int rowIndex = tbClientes.rowAtPoint(evt.getPoint());
        // Verifica se o clique foi em uma linha válida
        if (rowIndex >= 0) {
            // Define a linha clicada como a linha selecionada
            selectionModel.setSelectionInterval(rowIndex, rowIndex);
            //Cliente selecionado = (Cliente) clienteDao.pesquisar(rowIndex);
            //tfCodigo.setText(String.valueOf(rowIndex));
            tfCodigoPedido.setText(String.valueOf(cad.get(rowIndex).getCodCliente()));
            tfNome.setText( cad.get(rowIndex).getNome());
            tfDataEntrega.setText(String.valueOf(cad.get(rowIndex).getTelefone()));
            tfCpf.setText(String.valueOf(cad.get(rowIndex).getCpf()));
            tfValorProdutos.setText(String.valueOf(cad.get(rowIndex).getRg()));
            tfEndereco.setText(cad.get(rowIndex).getEndereco());
            tfQtdProdutos.setText(String.valueOf(cad.get(rowIndex).getNumero()));
            tfApto.setText(String.valueOf(cad.get(rowIndex).getApto()));
            tfBairro.setText(cad.get(rowIndex).getBairro());
            tfDataPagamento.setText(cad.get(rowIndex).getEstado());
            tfCep.setText(String.valueOf(cad.get(rowIndex).getCep()));
            tfCidade.setText(cad.get(rowIndex).getCidade());
            tfObservacao.setText(cad.get(rowIndex).getObs());
            String status = "";
            if(cad.get(rowIndex).isAtivo()){
                status = "Desativado!";
            }else{
                status = "Ativo!";
            }
            jlStatusPagamento.setText(status);
        }
        //manipula os botões
        btNovo.setEnabled(false);
        btEditar.setEnabled(true);
        btExcluirPedido.setEnabled(true);
        btCancelar.setEnabled(true);
        jlStatusPagamento.setEnabled(true);

    }//GEN-LAST:event_tbClientesMouseClicked

    //este botão apenas ativa ps campos, manipula os botoes e muda a bandeira para 2 excluir
    private void btExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirPedidoActionPerformed
        util.Util.EditarFrame.ativaCampos(this);
        btSalvar.setText("DESABILITAR");
        btSalvar.setEnabled(true);
        btEditar.setEnabled(false);
        btExcluirPedido.setEnabled(false);
        tfCpf.setEnabled(false);
        operacao = 2;
    }//GEN-LAST:event_btExcluirPedidoActionPerformed

    //este botão apenas ativa ps campos, manipula os botoes e muda a bandeira para 1 editar
    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        util.Util.EditarFrame.ativaCampos(this);
        btSalvar.setEnabled(true);
        btEditar.setEnabled(false);
        btExcluirPedido.setEnabled(false);
        tfCpf.setEnabled(false);
        operacao = 1;
    }//GEN-LAST:event_btEditarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

        //inicializa select de clientes
        jComboBoxClientes.removeAllItems();
        for (int i=0; i< cad.size(); i++) {
            String clienteMaisCpf = cad.get(i).getCodCliente() + " - " + cad.get(i).getNome();
            jComboBoxClientes.addItem(clienteMaisCpf);
        }

        // bandeira para usar o mesmo botao de salvar
        operacao = 0;

        Pedido pedido1 = new Pedido();

        pedido1.gerarCod(cad);
        int codigo = pedido1.getCodPedido() + 1;

        // habilita e desabilita os botoes
        btNovo.setEnabled(false);
        btEditar.setEnabled(false);
        btExcluirPedido.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        tfCodigoPedido.setText("" + codigo);
        jComboBoxClientes.setEnabled(true);
        jComboBoxClientes.requestFocus();
        tbClientes.setVisible(false);
        btAlterarStatusPagamento.setEnabled(true);
        jlStatusPagamento.setText("Pendente");
        

        // limpas e ativa os campos
        Util.EditarFrame.limparDados(this);
        Util.EditarFrame.ativaCampos(this);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarStatusPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarStatusPagamentoActionPerformed
        if("Pago".equals(jlStatusPagamento.getText())){
            jlStatusPagamento.setText("Pendente");
        }else{
            jlStatusPagamento.setText("Pago");
        }
        
    }//GEN-LAST:event_btAlterarStatusPagamentoActionPerformed

   
   //o metodo main basicamente chama a view ClienteGUI
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Cria e mostra o form */
           
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoGUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarStatusPagamento;
    private javax.swing.JButton btAlterarStatusPagamentoSalvar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluirPedido;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JPanel cadastroClientes;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlStatusPagamento;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField tfApto;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JLabel tfCodigoPedido;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfDataEntrega;
    private javax.swing.JTextField tfDataPagamento;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfObservacao;
    private javax.swing.JTextField tfQtdProdutos;
    private javax.swing.JTextField tfValorProdutos;
    // End of variables declaration//GEN-END:variables
}