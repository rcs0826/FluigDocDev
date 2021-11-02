/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev.entidades;

import fluigdocdev.SqliteConnect;
import java.sql.SQLException;
/**
 *
 * @author rogerio
 */
public class Config {
    SqliteConnect sql = new SqliteConnect();
    
    private String getVariavel = "SELECT valor FROM Config WHERE variavel = '#'";
    private String setVariavel = "UPDATE Config SET valor = '$' WHERE variavel = '#'";
    
    public String getCreateDoc(){        
        try{
            return sql.getUnicValue(this.getVariavel.replace("#","createDoc"));
        }
        catch(SQLException e){
            return "";
        }
    }
    
    public void setConfig(String variavel, String valor){        
        try{
            sql.setDBValues(this.setVariavel.replace("$",valor).replace("#",variavel));
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
}
