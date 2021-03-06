/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev.views;

import fluigdocdev.entidades.Cliente;
import fluigdocdev.SqliteConnect;
import fluigdocdev.FileSystemModel;
import fluigdocdev.Rest;
import fluigdocdev.entidades.Server;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author rogerio
 */
public class CadastroServer extends javax.swing.JInternalFrame {

    SqliteConnect sql = new SqliteConnect();
    Cliente cli = new Cliente();
    Server serv = new Server();
    Rest rest = new Rest();
    
    /**
     * Creates new form CadastroServer
     */
    public CadastroServer() {
        initComponents();
        loadCbProjt();
    }

    private void loadCbProjt() {
        try {
            this.cbCliente.setModel(sql.getResultComboBoxModel(cli.getSelNomeCli()));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCliente = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        lbTipo = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        lbURL = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        lbPorta = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lbSSL = new javax.swing.JLabel();
        ckSSL = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Servers");

        lbCliente.setText("Cliente:");

        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });

        lbTipo.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Homolog/Dev", "Produ????o", "Homologa????o", "Desenvolvimento" }));

        lbURL.setText("URL:");

        lbPorta.setText("Porta:");

        txtPorta.setText("80");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        lbLogin.setText("Login (Adm Fluig):");

        lbSenha.setText("Senha:");

        lbSSL.setText("SSL:");

        ckSSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckSSLActionPerformed(evt);
            }
        });

        jButton1.setText("Teste Rest");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbCliente)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbTipo)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbURL)
                                        .addGap(462, 538, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUrl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ckSSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbSSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPorta)
                                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbLogin)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbSenha)
                                .addGap(204, 204, 204))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCliente)
                    .addComponent(lbTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbURL))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPorta)
                            .addComponent(lbSSL))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ckSSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogin)
                    .addComponent(lbSenha))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(btSalvar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(36, 36, 36))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        // TODO add your handling code here:
        String descCli = (String) this.cbCliente.getSelectedItem();
        cli.setNome(descCli);
        try {
            String url = sql.getUnicValue(cli.getSelUrlCli());
            File file = new File(url);
            FileSystemModel model = new FileSystemModel(file);
            //this.jTree1.setModel(model);
            //this.cbProjeto.setModel(this.proj.getArqModelCB(descCli));
            //this.tbProjetos.setModel(this.proj.getArqModel(descCli));
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_cbClienteActionPerformed

    private void ckSSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckSSLActionPerformed
        // TODO add your handling code here:
        if(this.ckSSL.isSelected()){
            this.txtPorta.setText("443");
        }
        else{
            this.txtPorta.setText("80");
        }
    }//GEN-LAST:event_ckSSLActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO Fazer a valida????o dos campos:
        String descCli = (String) this.cbCliente.getSelectedItem();  
        String descTipo = (String) this.cbTipo.getSelectedItem();
        this.serv.setIdCli(descCli);
        this.serv.setTipo(descTipo);
        this.serv.setLogin(this.txtLogin.getText());
        this.serv.setSenha(this.txtSenha.getText());
        // Fazer um tratamento na URL, Ex: https://hmlportal.santher.com.br 
        this.serv.setURL(this.txtUrl.getText());
        this.serv.setSSL((this.ckSSL.isSelected()?"1":"0"));
        this.serv.setPorta(this.txtPorta.getText());
        try{
            this.serv.setServer();
            JOptionPane.showMessageDialog(null, "Servidor cadastrado com sucesso!");
        }
        catch(SQLException e){
            System.err.println("Erro: " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Bot??o de teste do evento REST
        try{
            //this.rest.getRest("https://cat-fact.herokuapp.com/facts/");
            //this.rest.getRest("https://hmlportal.santher.com.br/api/public/ecm/dataset/availableDatasets");
            this.rest.postRest("");
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JCheckBox ckSSL;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbPorta;
    private javax.swing.JLabel lbSSL;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbURL;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
