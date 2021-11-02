/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev.entidades;

import java.util.ArrayList;
import fluigdocdev.SqliteConnect;
import fluigdocdev.entidades.Projeto;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.TreePath;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rogerio
 */
public class ArqProjet {

    private String id = "0";
    private String descricao = "";
    private String idProj = "";
    private String tipo = "";
    private String url = "/";
    private String tipoFluig = "";
    private String selectArq = "Select * from ArquivosProjeto where idProj = ?";
    private String insertArq = "INSERT INTO ArquivosProjeto (descricao, idProj,tipo,url,tipoFluig) VALUES ('?','#','$','@','%')";
    private String deleteArq = "Delete from ArquivosProjeto where id = ?";
    private String selectAllArq = "SELECT * FROM ArquivosProjeto WHERE tipoFluig = 'datasets' AND idProj = ?";
    private ArrayList<ArqProjet> dados = new ArrayList<ArqProjet>();
    private SqliteConnect sql = new SqliteConnect();
    private Projeto proj = new Projeto();

    public String getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getIdProj() {
        return this.idProj;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getTipoFluig() {
        return this.tipoFluig;
    }

    public String getUrl() {
        return this.url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdProj(String idProj) {
        this.idProj = idProj;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTipoFluig(String tipoFluig) {
        this.tipoFluig = tipoFluig;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    private String getSelectAllArq(){
        return selectAllArq.replace("?", this.getIdProj());
    }
    
    public DefaultTableModel getArqImport(String desc)throws SQLException{     
        this.proj.setDescricao(desc);
        this.setIdProj(this.sql.getUnicValue(this.proj.getSelIdProj())); 
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet resultados = sql.getValues(this.getSelectAllArq());
        int colCount = resultados.getMetaData().getColumnCount();
        System.out.println("colCount: "+colCount);
        for (int i = 1; i <= colCount; i++) {
            modelo.addColumn(resultados.getMetaData().getColumnName(i));
        }

        while (resultados.next()) {
            String row[] = new String[colCount];

            for (int x = 0; x < colCount; x++) {
                row[x] = resultados.getString(resultados.getMetaData().getColumnName(x + 1));
            }
            modelo.addRow(row);
        }
        
        return modelo;
    }
    
    public DefaultTableModel getArqModel(String desc) throws SQLException{
        this.proj.setDescricao(desc);
        this.setIdProj(this.sql.getUnicValue(this.proj.getSelIdProj()));               
        return sql.getResultTableModel(this.selectArq.replace("?", this.idProj));
    }
    
    public void setDelArq() throws SQLException{
        String del = this.deleteArq.replace("?", this.id);
        this.sql.setDBValues(del);
    }
    
    public void setArq(TreePath treePath,String desc) throws SQLException {        
        this.proj.setDescricao(desc);
        this.setIdProj(this.sql.getUnicValue(this.proj.getSelIdProj()));
        
        String path = new String();
        int count = treePath.getPath().length;

        for (int i = 0; i < count; i++) {
            path += treePath.getPathComponent(i).toString();
            path += (i < count - 1) ? "/" : "";
            this.setDescricao(treePath.getPathComponent(i).toString());
        }        
        File arq = new File(path);        
        this.setTipo((arq.isDirectory()?"dir":"file")); 
        this.setTipoFluig(treePath.getPathComponent(1).toString().toLowerCase());
        this.setUrl(path);
        
        System.out.println("tree Name: " + path);
        String query = this.insertArq.replace("?", this.descricao).replace("#", this.idProj).replace("$", this.tipo).replace("@", this.url).replace("%", this.tipoFluig);
        this.sql.setDBValues(query);
    }
}
