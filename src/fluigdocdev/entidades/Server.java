/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev.entidades;

import fluigdocdev.SqliteConnect;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author rogerio
 */
public class Server {
    private String idCli = "";
    private String tipo = "";
    private String url = "";
    private String porta = "";
    private String login = "";
    private String senha = "";
    private String ssl = "";
    private String insertServer = "Insert into Server (cliente, tipo, url, porta, login, senha, ssl) values (?)";
    private String selectServer = "Select tipo as Nome from Server where cliente = ? order by tipo";
    private SqliteConnect sql = new SqliteConnect();
    private Cliente cli = new Cliente();

    public String getCliente(){
	return this.idCli;
    }
     public String getTipo(){
        return this.tipo;
    }
     public String getURL(){
        return this.url;
    }
     public String getPorta(){
        return this.porta;
    }
     public String getLogin(){
        return this.login;
    }
     public String getSenha(){
        return this.senha;
    }
     public String getSSL(){
        return this.ssl;
    }
    public String getSelServer() {
        return this.selectServer.replace("?", this.idCli);
    }
    public DefaultComboBoxModel getServerModelCB(String desc) throws SQLException {
        this.cli.setNome(desc);
        this.setIdCli(this.sql.getUnicValue(this.cli.getSelIdCli()));
        return sql.getResultComboBoxModel(this.getSelServer());
    }
    public void setServer() throws SQLException {
        String values = "";
        this.cli.setNome(this.idCli);
        
        values += this.sql.getUnicValue(this.cli.getSelIdCli())+",'";
        values += this.tipo+"','";
        values += this.url+"',";
        values += this.porta+",'";
        values += this.login+"','";
        values += this.senha+"',";
        values += this.ssl;     
        
        this.sql.setDBValues(this.insertServer.replace("?",values));
    }
    
    public void setIdCli(String cliente){
	this.idCli = cliente;
    }
     public void setTipo(String tipo){
        this.tipo = tipo;
    }
     public void setURL(String url){
        this.url = url;
    }
     public void setPorta(String porta){
        this.porta = porta;
    }
     public void setLogin(String login){
        this.login = login;
    }
     public void setSenha(String senha){
        this.senha = senha;
    }
     public void setSSL(String ssl){
        this.ssl = ssl;
    }

}
