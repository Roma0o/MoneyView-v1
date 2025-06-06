package telas;

import dados.SessaoUsuario;
import dados.Transacao;
import dados.TransacaoDAO;
import dados.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaTransacoes extends javax.swing.JFrame {

    public TelaTransacoes() {
        initComponents();
        carregarDespesas();
        carregarGanhos();
        carregarTransacoes();
    }

    private void carregarDespesas() {
    Usuario usuario = SessaoUsuario.getInstancia().getUsuario();
    if (usuario == null) {
        JOptionPane.showMessageDialog(this, "Nenhum usuário logado!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    TransacaoDAO transacaoDAO = new TransacaoDAO();
    List<Transacao> despesas = transacaoDAO.buscarTransacoesDoUsuario(usuario.getId(), "Despesa");

    DefaultTableModel model = (DefaultTableModel) tblDespesas.getModel();
    model.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

    for (Transacao despesa : despesas) {
        model.addRow(new Object[]{
            despesa.getId(),
            despesa.getDescricao(),
            despesa.getValor(),
            despesa.getData(),
            despesa.getTipo(),
            despesa.getCategoria()
        });
    }
}
    
    private void carregarGanhos() {
    Usuario usuario = SessaoUsuario.getInstancia().getUsuario();
    if (usuario == null) {
        JOptionPane.showMessageDialog(this, "Nenhum usuário logado!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    TransacaoDAO transacaoDAO = new TransacaoDAO();
    List<Transacao> ganhos = transacaoDAO.buscarTransacoesDoUsuario(usuario.getId(), "Ganho");

    DefaultTableModel model = (DefaultTableModel) tblGanhos.getModel();
    model.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

    for (Transacao ganho : ganhos) {
        model.addRow(new Object[]{
            ganho.getId(),
            ganho.getDescricao(),
            ganho.getValor(),
            ganho.getData(),
            ganho.getTipo(),
            ganho.getCategoria()
        });
    }
}
    
    private void carregarTransacoes() {
    Usuario usuario = SessaoUsuario.getInstancia().getUsuario();
    if (usuario == null) {
        JOptionPane.showMessageDialog(this, "Nenhum usuário logado!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    TransacaoDAO transacaoDAO = new TransacaoDAO();
    List<Transacao> transacoes = transacaoDAO.buscarTodasTransacoesDoUsuario(usuario.getId());

    DefaultTableModel model = (DefaultTableModel) tblAnalise.getModel();
    model.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

    for (Transacao transacao : transacoes) {
        model.addRow(new Object[]{
            transacao.getId(),
            transacao.getDescricao(),
            transacao.getValor(),
            transacao.getData(),
            transacao.getTipo(),
            transacao.getCategoria()
        });
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        btnGanhos = new javax.swing.JButton();
        btnDespesas = new javax.swing.JButton();
        btnAnalise = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tbpnlTelas = new javax.swing.JTabbedPane();
        pnlGanhos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGanhos = new javax.swing.JTable();
        btnEditGanho = new javax.swing.JButton();
        btnAdcGanho = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnlDespesas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDespesas = new javax.swing.JTable();
        btnAdcDespesa = new javax.swing.JButton();
        btnEditDespesa = new javax.swing.JButton();
        pnlAnalise = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnalise = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(40, 41, 57));

        btnGanhos.setText("Ganhos");
        btnGanhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGanhosActionPerformed(evt);
            }
        });

        btnDespesas.setText("Despesas");
        btnDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespesasActionPerformed(evt);
            }
        });

        btnAnalise.setText("Analise");
        btnAnalise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnaliseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Menu");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGanhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnalise, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnGanhos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnalise, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(440, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        pnlGanhos.setBackground(new java.awt.Color(25, 26, 48));
        pnlGanhos.setForeground(new java.awt.Color(187, 71, 185));

        tblGanhos.setBackground(new java.awt.Color(6, 7, 26));
        tblGanhos.setForeground(new java.awt.Color(204, 204, 204));
        tblGanhos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descricao", "Valor", "Data", "Tipo", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGanhos);

        btnEditGanho.setBackground(new java.awt.Color(40, 41, 57));
        btnEditGanho.setForeground(new java.awt.Color(224, 225, 238));
        btnEditGanho.setText("Editar Ganho");
        btnEditGanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditGanhoActionPerformed(evt);
            }
        });

        btnAdcGanho.setBackground(new java.awt.Color(40, 41, 57));
        btnAdcGanho.setForeground(new java.awt.Color(224, 225, 238));
        btnAdcGanho.setText("Adicionar Ganho");
        btnAdcGanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdcGanhoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(224, 225, 238));
        jLabel2.setText("Gerenciar Ganhos");

        javax.swing.GroupLayout pnlGanhosLayout = new javax.swing.GroupLayout(pnlGanhos);
        pnlGanhos.setLayout(pnlGanhosLayout);
        pnlGanhosLayout.setHorizontalGroup(
            pnlGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGanhosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(pnlGanhosLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnAdcGanho, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditGanho, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        pnlGanhosLayout.setVerticalGroup(
            pnlGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGanhosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdcGanho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditGanho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        tbpnlTelas.addTab("tab1", pnlGanhos);

        pnlDespesas.setBackground(new java.awt.Color(25, 26, 48));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(224, 225, 238));
        jLabel3.setText("Gerenciar Despesas");

        tblDespesas.setBackground(new java.awt.Color(6, 7, 26));
        tblDespesas.setForeground(new java.awt.Color(204, 204, 204));
        tblDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descricao", "Valor", "Data", "Tipo", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDespesas);

        btnAdcDespesa.setBackground(new java.awt.Color(40, 41, 57));
        btnAdcDespesa.setForeground(new java.awt.Color(224, 225, 238));
        btnAdcDespesa.setText("Adicionar Despesa");
        btnAdcDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdcDespesaActionPerformed(evt);
            }
        });

        btnEditDespesa.setBackground(new java.awt.Color(40, 41, 57));
        btnEditDespesa.setForeground(new java.awt.Color(224, 225, 238));
        btnEditDespesa.setText("Editar Despesa");
        btnEditDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDespesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDespesasLayout = new javax.swing.GroupLayout(pnlDespesas);
        pnlDespesas.setLayout(pnlDespesasLayout);
        pnlDespesasLayout.setHorizontalGroup(
            pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDespesasLayout.createSequentialGroup()
                .addGroup(pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDespesasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDespesasLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnAdcDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnEditDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        pnlDespesasLayout.setVerticalGroup(
            pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDespesasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdcDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        tbpnlTelas.addTab("tab2", pnlDespesas);

        pnlAnalise.setBackground(new java.awt.Color(25, 26, 48));
        pnlAnalise.setForeground(new java.awt.Color(25, 26, 48));

        tblAnalise.setBackground(new java.awt.Color(6, 7, 26));
        tblAnalise.setForeground(new java.awt.Color(204, 204, 204));
        tblAnalise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descricao", "Valor", "Data", "Tipo", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAnalise);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(224, 225, 238));
        jLabel4.setText("Análise");

        javax.swing.GroupLayout pnlAnaliseLayout = new javax.swing.GroupLayout(pnlAnalise);
        pnlAnalise.setLayout(pnlAnaliseLayout);
        pnlAnaliseLayout.setHorizontalGroup(
            pnlAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnaliseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        pnlAnaliseLayout.setVerticalGroup(
            pnlAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnaliseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        tbpnlTelas.addTab("tab3", pnlAnalise);

        getContentPane().add(tbpnlTelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -40, 1000, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGanhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanhosActionPerformed
        tbpnlTelas.setSelectedIndex(0);
    }//GEN-LAST:event_btnGanhosActionPerformed

    private void btnDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespesasActionPerformed
        tbpnlTelas.setSelectedIndex(1);
    }//GEN-LAST:event_btnDespesasActionPerformed

    private void btnAnaliseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaliseActionPerformed
        tbpnlTelas.setSelectedIndex(2);
    }//GEN-LAST:event_btnAnaliseActionPerformed

    private void btnAdcGanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdcGanhoActionPerformed
        TelaAdcTransacao t = new TelaAdcTransacao(0);
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAdcGanhoActionPerformed

    private void btnAdcDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdcDespesaActionPerformed
        TelaAdcTransacao t = new TelaAdcTransacao(1);
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAdcDespesaActionPerformed

    private void btnEditGanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditGanhoActionPerformed
        int linha = tblGanhos.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel)tblGanhos.getModel();
        abrirTelaDeEdicao(linha, modelo);
        dispose();
    }//GEN-LAST:event_btnEditGanhoActionPerformed

    private void btnEditDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDespesaActionPerformed
        int linha = tblDespesas.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel)tblDespesas.getModel();
        abrirTelaDeEdicao(linha, modelo);
        dispose();
    }//GEN-LAST:event_btnEditDespesaActionPerformed
    
    private void abrirTelaDeEdicao(int linha, DefaultTableModel modelo){
        if (linha != -1) {
            
            int idTransacao = (int) modelo.getValueAt(linha, 0);
            String desc = modelo.getValueAt(linha,1).toString();
            Double valor = Double.valueOf(modelo.getValueAt(linha,2).toString());
            String data = modelo.getValueAt(linha,3).toString();
            String tipo = modelo.getValueAt(linha,4).toString();
            String categoria = modelo.getValueAt(linha,5).toString();
            Usuario usuario = SessaoUsuario.getInstancia().getUsuario();
            int idUsuario = usuario.getId();
            
            Transacao transacao = new Transacao(idTransacao, desc, valor, data, tipo, categoria, idUsuario);
            
            new TelaEditTransacao(transacao).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma transação, clicando nela!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
            java.util.logging.Logger.getLogger(TelaTransacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTransacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTransacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTransacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTransacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdcDespesa;
    private javax.swing.JButton btnAdcGanho;
    private javax.swing.JButton btnAnalise;
    private javax.swing.JButton btnDespesas;
    private javax.swing.JButton btnEditDespesa;
    private javax.swing.JButton btnEditGanho;
    private javax.swing.JButton btnGanhos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlAnalise;
    private javax.swing.JPanel pnlDespesas;
    private javax.swing.JPanel pnlGanhos;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JTable tblAnalise;
    private javax.swing.JTable tblDespesas;
    private javax.swing.JTable tblGanhos;
    private javax.swing.JTabbedPane tbpnlTelas;
    // End of variables declaration//GEN-END:variables
}
