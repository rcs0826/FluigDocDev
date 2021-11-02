/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev.entidades;

import fluigdocdev.SqliteConnect;

/**
 *
 * @author rogerio
 */
public class Cliente {
    private String id = "0";
    private String nome = "";
    private String url = "/";
    private String selectIdCli = "select id from Cliente where nome = '?'";
    private String selectNomeCli = "select nome from Cliente order by nome";
    private String selectUrlCli = "select url from Cliente where nome = '?'";
    private String selectCliente = "Select id as Codigo, nome as Nome, url as Local from Cliente";
    private String insertCliente = "Insert Into Cliente (nome, url) values ('?','#')";
    private String updateCliente = "Update Cliente set nome = '?', url = '$' WHERE id = #";
    private String deleteCliente = "Delete From Cliente WHERE id = ?";    
    SqliteConnect sql = new SqliteConnect();
    
    /* Get */
    public String getId(){ 
        return this.id;
    }
    
    public String getNome(){ 
        return this.nome;
    }
    
    public String getUrl(){ 
        return this.url;
    }
    
    public String getSelUrlCli(){
        return this.selectUrlCli.replace("?",this.nome);
    }
    
    public String getSelNomeCli(){
        return this.selectNomeCli;
    }
    
    public String getSelCli(){
        return this.selectCliente;
    }
    
    public String getSelIdCli(){
        return this.selectIdCli.replace("?",this.nome);
    }
    
    public String getInsCli(){
        return this.insertCliente.replace("?",this.nome).replace("#",this.url);
    }
    
    public String getUpdCli(){
        return this.updateCliente.replace("?",this.nome).replace("#",this.id).replace("$",this.url);
    }
    
    public String getDelCli(){
        return this.deleteCliente.replace("?",this.id);
    }
    
    /* Set */    
    public void setId(String id){ 
        this.id = id;
    }
    
    public void setNome(String nome){ 
        this.nome = nome;
    }
    
    public void setUrl(String url){ 
        this.url = url;
    }
}
