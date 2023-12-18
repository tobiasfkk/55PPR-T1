/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 10264021908
 */
public class ViewMenu extends javax.swing.JFrame {

    /**
     * Creates new form ViewMenuw
     */
    public ViewMenu() {
        initComponents();
    }

    public void abrirTela(){
        setVisible(true);
    }
    
    public void fecharTela(){
        setVisible(false);
    }
    
    public void adicionarAcaoBotaoCadastrarCategoria(ActionListener acao){
        BtnCadastrarCategoria.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoCadastrarTarefa(ActionListener acao){
        BtnCadastrarTarefa.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoVisualizarCategoria(ActionListener acao){
        BtnVisualizarCategoria.addActionListener(acao);
    }
  
    public void adicionarAcaoBotaoVisualizarTarefa(ActionListener acao){
        BtnVisualizarTarefa.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoFechar(ActionListener acao){
        BtnFechar.addActionListener(acao);
    }
    
    public void exibirMensagem(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        BtnVisualizarTarefa = new javax.swing.JButton();
        BtnCadastrarTarefa = new javax.swing.JButton();
        BtnVisualizarCategoria = new javax.swing.JButton();
        BtnCadastrarCategoria = new javax.swing.JButton();
        BtnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("MENU");

        BtnVisualizarTarefa.setText("Visualizar Tarefa");
        BtnVisualizarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVisualizarTarefaActionPerformed(evt);
            }
        });

        BtnCadastrarTarefa.setText("Cadastrar Tarefa");
        BtnCadastrarTarefa.setMaximumSize(new java.awt.Dimension(133, 22));
        BtnCadastrarTarefa.setMinimumSize(new java.awt.Dimension(133, 22));
        BtnCadastrarTarefa.setPreferredSize(new java.awt.Dimension(133, 22));
        BtnCadastrarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrarTarefaActionPerformed(evt);
            }
        });

        BtnVisualizarCategoria.setText("Visualizar Categoria");
        BtnVisualizarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVisualizarCategoriaActionPerformed(evt);
            }
        });

        BtnCadastrarCategoria.setText("Cadastrar Categoria");
        BtnCadastrarCategoria.setMaximumSize(new java.awt.Dimension(133, 22));
        BtnCadastrarCategoria.setMinimumSize(new java.awt.Dimension(133, 22));
        BtnCadastrarCategoria.setPreferredSize(new java.awt.Dimension(133, 22));

        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BtnFechar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BtnCadastrarTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnCadastrarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnVisualizarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnVisualizarTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCadastrarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnVisualizarCategoria))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCadastrarTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnVisualizarTarefa))
                .addGap(81, 81, 81)
                .addComponent(BtnFechar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastrarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarTarefaActionPerformed
        
//        CategoriaInterface repositorioCategoria = new CategoriaDAO();
//        
//        boolean entrou = false;
//        for (Categoria categoria : repositorioCategoria.buscarTodosCategorias()) {
//            
//            entrou = true;
//            break;
//        }
//        if(entrou == false){
//            JOptionPane.showMessageDialog(null,"Necessário cadastrar pelo menos uma categoria!");
//        }else{
//            ViewCriarTarefa viewTarefa = new ViewCriarTarefa();
//            viewTarefa.setVisible(true);
//        }  
        
    }//GEN-LAST:event_BtnCadastrarTarefaActionPerformed

    private void BtnVisualizarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVisualizarCategoriaActionPerformed

//        CategoriaInterface repositorioCategoria = new CategoriaDAO();
//        
//        boolean entrou = false;
//        for (Categoria categoria : repositorioCategoria.buscarTodosCategorias()) {
//            
//            entrou = true;
//            break;
//        }
//        if(entrou == false){
//            JOptionPane.showMessageDialog(null,"Necessário cadastrar pelo menos uma categoria!");
//        }else{
//            ViewAlterarCategoria viewAlterarCategoria = new ViewAlterarCategoria();
//            viewAlterarCategoria.setVisible(true);
//        }
    }//GEN-LAST:event_BtnVisualizarCategoriaActionPerformed

    private void BtnVisualizarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVisualizarTarefaActionPerformed
  
        
        
//        TarefaInterface repositorioTarefa = new TarefaDAO();
//        
//        boolean entrou = false;
//        for (Tarefa tarefa : repositorioTarefa.buscarTodasTarefas()) {
//            
//            entrou = true;
//            break;
//        }
//        if(entrou == false){
//            JOptionPane.showMessageDialog(null,"Necessário cadastrar pelo menos uma tarefa!");
//        }else{
//            ViewAlterarTarefa viewAlterarTarefa = new ViewAlterarTarefa();
//            viewAlterarTarefa.setVisible(true); 
//        } 
    }//GEN-LAST:event_BtnVisualizarTarefaActionPerformed

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnFecharActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrarCategoria;
    private javax.swing.JButton BtnCadastrarTarefa;
    private javax.swing.JButton BtnFechar;
    private javax.swing.JButton BtnVisualizarCategoria;
    private javax.swing.JButton BtnVisualizarTarefa;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
