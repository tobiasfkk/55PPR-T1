package View;

import Model.Categoria;
import Model.ManipularImagem;
import Model.Tarefa;
import static View.ViewCriarTarefa.numeracao;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ViewAlterarTarefa extends javax.swing.JFrame {

    private String nome;
    BufferedImage imagem;
    static int numeracao;
    private boolean entrou = false; 
    
    public ViewAlterarTarefa() {
        initComponents();
        insereImagemLabel();
    }
    
    public void fechar(){
        setVisible(false);
    }
    
    public void adicionarAcaoBotaoSalvar(ActionListener acao){
        BtnSalvarAlteracao.addActionListener(acao);
    }
    
    public void adicionarAcaoComboTarefa(ActionListener acao){
        ComboTarefa.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoDeletar(ActionListener acao){
        BtnDeletar.addActionListener(acao);
    }
    
    public void ComboCategoria(Categoria categoria){
        ComboCategoria.addItem((Categoria) categoria);
    }
    
    public void ComboTarefa(Tarefa tarefa){
        ComboTarefa.addItem((Tarefa) tarefa);
    }
    
    public void CampoPrioridade(String prioridade){
        comboPrioridade.addItem(prioridade);
    }
    
    public void CampoStatus(String status){
        comboStatus.addItem(status);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public void limparCampos(){
        txtTitulo.setText("");
        dataConclusao.setText("");
        txtDescricao.setText("");
    }
    
    public Categoria getComboCategoria(){
        return (Categoria) ComboCategoria.getSelectedItem();
    }
    
    public Tarefa getComboTarefa(){
        return (Tarefa) ComboTarefa.getSelectedItem();
    }
    
    public String getTarefaTitulo(){
        return txtTitulo.getText();
    }
    
    public String getTarefaPrioridade(){
        return comboPrioridade.getSelectedItem().toString();
    }
    
    public String getTarefaStatus(){
        return comboStatus.getSelectedItem().toString();
    }
    
    public String getTarefaDataConclusao(){
         return dataConclusao.getText();
    }
    
    public String getTarefaDescricao(){
         return txtDescricao.getText();
    }
    
    public void setTarefaTitulo(String titulo){
        txtTitulo.setText(titulo);
    }
    
    
    public void setTarefaPrioridade(String prioridade){
        comboPrioridade.setSelectedItem(prioridade);
    }
    
    public void setTarefaStatus(String status){
        comboStatus.setSelectedItem(status);
    }
    
    public void setTarefaDataConclusao(String data){
        dataConclusao.setText(data);
    }
    
    public void setTarefaCategoria(Categoria categoria){
        ComboCategoria.setSelectedItem(categoria);
    }
    
    public void setTarefaDescricao(String descricao){
        txtDescricao.setText(descricao);
    }
    
    public void removerItemComboTarefas(Tarefa tarefa){
        ComboTarefa.removeItem((Tarefa) tarefa);
    }
    
    public void setTarefaAnexo(String anexo){
        nome = anexo;
        insereImagemLabel();
    }
    
    public String getAnexo(){
        return txtNomeArquivo.getText();
    }
    
    public void enviarImagem(){
        if(entrou ==  true){

            numeracao++;
            String tipo = ".jpg";
            String nome = "imagem" + Integer.toString(numeracao)+ tipo;
            try {
                
                 String caminho = (System.getProperty("user.dir")+"\\src\\main\\java\\imagens\\");
                 File outputfile = new File(caminho+nome);  
                 txtNomeArquivo.setText(nome);
                 ImageIO.write(imagem, "jpg", outputfile);
                 JOptionPane.showMessageDialog(rootPane, "Imagem alterada com sucesso");

             } catch (IOException ex) {
                 //Logger.getLogger(nome);

             }
         }
    }
    
    private void insereImagemLabel() {
         
//        ImageIcon imagem = new ImageIcon ("src/main/java/imagens/imagem1.jpg");
        ImageIcon imagem = new ImageIcon ("src/main/java/imagens/"+nome);

        imagem.setImage(imagem.getImage().getScaledInstance(jlImagem1.getWidth(),jlImagem1.getHeight(),1));
        jlImagem1.setIcon(imagem);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboTarefa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboPrioridade = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        dataConclusao = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ComboCategoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        BtnSalvarAlteracao = new javax.swing.JButton();
        BtnDeletar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnImagem = new javax.swing.JButton();
        jlImagem1 = new javax.swing.JLabel();
        txtNomeArquivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ComboTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTarefaActionPerformed(evt);
            }
        });

        jLabel1.setText("Tarefa");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alterar Tarefa");

        jLabel3.setText("Título");

        jLabel4.setText("Status");

        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        try {
            dataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataConclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataConclusaoActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Conclusão");

        jLabel7.setText("Categoria");

        ComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCategoriaActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        jLabel6.setText("Descrição");

        BtnSalvarAlteracao.setText("Salvar Alterações");
        BtnSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarAlteracaoActionPerformed(evt);
            }
        });

        BtnDeletar.setText("Deletar Registro");
        BtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeletarActionPerformed(evt);
            }
        });

        jLabel8.setText("Prioridade");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        btnImagem.setText("Imagem");
        btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });

        jlImagem1.setPreferredSize(new java.awt.Dimension(300, 400));

        txtNomeArquivo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(ComboTarefa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(comboPrioridade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(42, 42, 42)
                        .addComponent(txtTitulo)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnSalvarAlteracao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnDeletar)
                        .addGap(51, 51, 51)
                        .addComponent(btnImagem)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(275, 303, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ComboCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(jlImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(125, 125, 125)
                    .addComponent(txtNomeArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(125, 125, 125)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 421, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSalvarAlteracao)
                    .addComponent(BtnDeletar)
                    .addComponent(btnImagem))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(359, Short.MAX_VALUE)
                    .addComponent(jlImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addComponent(txtNomeArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(374, 374, 374)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTarefaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTarefaActionPerformed

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStatusActionPerformed

    private void dataConclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataConclusaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataConclusaoActionPerformed

    private void ComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCategoriaActionPerformed

    private void BtnSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarAlteracaoActionPerformed
     
    }//GEN-LAST:event_BtnSalvarAlteracaoActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void BtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarActionPerformed

    }//GEN-LAST:event_BtnDeletarActionPerformed

    private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 600, 600);

            } catch (Exception ex) {
                // System.out.println(ex.printStackTrace().toString());
            }
            entrou = true;
        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");

            entrou = false;
        }
    }//GEN-LAST:event_btnImagemActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewAlterarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAlterarTarefa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDeletar;
    private javax.swing.JButton BtnSalvarAlteracao;
    private javax.swing.JComboBox<Categoria> ComboCategoria;
    private javax.swing.JComboBox<Tarefa> ComboTarefa;
    private javax.swing.JButton btnImagem;
    private javax.swing.JComboBox<String> comboPrioridade;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JFormattedTextField dataConclusao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlImagem1;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JLabel txtNomeArquivo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
