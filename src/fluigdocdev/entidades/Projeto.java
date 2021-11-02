/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev.entidades;

import fluigdocdev.SqliteConnect;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/*
import fluigdocdev.entidades.Cliente;
import fluigdocdev.SqliteConnect;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 */
/**
 *
 * @author rogerio
 */
public class Projeto {

    private String id = "";
    private String descricao = "";
    private String idCli = "";
    private String selectIdProj = "select id from Projeto where descricao = '?'";
    private String insertProjeto = "Insert Into Projeto (descricao, idCli) values ('?',#)";
    private String selectProjeto = "Select id as Codigo, descricao as Nome from Projeto where idCli = ? order by descricao";
    private String selectProjetoCB = "Select descricao as Nome from Projeto where idCli = ? order by descricao";
    private String deleteProjeto = "Delete from Projeto where id = ?";
    private String deleteArqProjeto = "Delete from ArquivosProjeto where idProj= ?";
    private SqliteConnect sql = new SqliteConnect();
    private Cliente cli = new Cliente();

    /*private Cliente cli = new Cliente();
    private SqliteConnect sql = new SqliteConnect();
    private Projeto proj = new Projeto();*/
    public String getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getIdCli() {
        return this.idCli;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdCli(String idCli) {
        this.idCli = idCli;
    }

    public String getSelIdProj() {
        return this.selectIdProj.replace("?", this.descricao);
    }

    public String getSelProj() {
        return this.selectProjeto.replace("?", this.idCli);
    }

    public String getSelProjCB() {
        return this.selectProjetoCB.replace("?", this.idCli);
    }

    public String getInsProj() {
        return this.insertProjeto.replace("?", this.descricao).replace("#", this.idCli);
    }

    public void setDelArq() throws SQLException {
        String sql1 = this.deleteArqProjeto.replace("?", this.id);
        String sql2 = this.deleteProjeto.replace("?", this.id);

        this.sql.setDBValues(sql1);
        this.sql.setDBValues(sql2);
    }

    public DefaultTableModel getArqModel(String desc) throws SQLException {
        this.cli.setNome(desc);
        this.setIdCli(this.sql.getUnicValue(this.cli.getSelIdCli()));
        return sql.getResultTableModel(this.getSelProj());
    }

    public DefaultComboBoxModel getArqModelCB(String desc) throws SQLException {
        this.cli.setNome(desc);
        this.setIdCli(this.sql.getUnicValue(this.cli.getSelIdCli()));
        return sql.getResultComboBoxModel(this.getSelProjCB());
    }

    public void setProject(String descCli, String projeto) throws SQLException {
        this.cli.setNome(descCli);
        this.setIdCli(this.sql.getUnicValue(this.cli.getSelIdCli()));
        this.setDescricao(projeto);
        this.sql.setDBValues(this.getInsProj());
    }
}
