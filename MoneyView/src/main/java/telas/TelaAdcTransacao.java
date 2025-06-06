package telas;

import dados.CategoriaDAO;
import dados.SessaoUsuario;
import dados.Transacao;
import dados.TransacaoDAO;
import dados.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaAdcTransacao extends javax.swing.JFrame {
    private int tipo;
    
    public TelaAdcTransacao(int tipo) {
        initComponents();
        this.tipo = tipo;
        preencherTipo(tipo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        btnConcluido = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(25, 26, 48));

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Descrição:");

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Valor:");

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Data:");

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Tipo:");

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Categoria:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("ADICIONAR TRANSAÇÃO");

        txtDesc.setBackground(new java.awt.Color(40, 41, 57));
        txtDesc.setForeground(new java.awt.Color(255, 255, 255));

        txtValor.setBackground(new java.awt.Color(40, 41, 57));
        txtValor.setForeground(new java.awt.Color(255, 255, 255));

        txtData.setBackground(new java.awt.Color(40, 41, 57));
        txtData.setForeground(new java.awt.Color(255, 255, 255));

        txtCategoria.setBackground(new java.awt.Color(40, 41, 57));
        txtCategoria.setForeground(new java.awt.Color(255, 255, 255));

        btnConcluido.setBackground(new java.awt.Color(40, 41, 57));
        btnConcluido.setForeground(new java.awt.Color(204, 204, 204));
        btnConcluido.setText("Concluido");
        btnConcluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluidoActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(40, 41, 57));
        btnCancelar.setForeground(new java.awt.Color(204, 204, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cmbTipo.setBackground(new java.awt.Color(40, 41, 57));
        cmbTipo.setForeground(new java.awt.Color(204, 204, 204));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ganho", "Despesa" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnConcluido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                .addComponent(btnCancelar)
                                .addGap(81, 81, 81))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDesc)
                                        .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConcluido)
                    .addComponent(btnCancelar))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        TelaTransacoes t = new TelaTransacoes();
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluidoActionPerformed
        if (txtDesc.getText().isEmpty() || txtValor.getText().isEmpty() || txtData.getText().isEmpty() || txtCategoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor, preencha todos os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        String desc = txtDesc.getText();
        Double valor = Double.valueOf(txtValor.getText());
        String data = txtData.getText();
        String tipo = cmbTipo.getSelectedItem().toString();
        String categoria = txtCategoria.getText();
        Usuario usuario = SessaoUsuario.getInstancia().getUsuario();
        int idUsuario = usuario.getId();
        //||
        
        if (transacaoDAO.validarData(data)) {
            try {
                Transacao transacao = new Transacao(-1,desc,valor,data,tipo,categoria, idUsuario);
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                int idCategoria = categoriaDAO.buscarId(categoria);
                if (idCategoria == -1) {
                   idCategoria = categoriaDAO.adicionarCategoria(categoria);
                }
                transacaoDAO.adicionarTransacao(transacao, idCategoria, idUsuario);
                JOptionPane.showMessageDialog(null, "Transação adicionada com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                TelaTransacoes t = new TelaTransacoes();
                t.setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(TelaAdcTransacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao validar a data, use o formato AAAA-MM-DD", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConcluidoActionPerformed
    
    private void preencherTipo(int tipo){
        if (tipo == 0) {
            cmbTipo.setSelectedIndex(0);
        }else{
            if (tipo == 1) {
                cmbTipo.setSelectedIndex(1);
            }else{
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao preencher o tipo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
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
            java.util.logging.Logger.getLogger(TelaAdcTransacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdcTransacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdcTransacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdcTransacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaAdcTransacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConcluido;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
