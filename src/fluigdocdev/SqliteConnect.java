/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author rogerio
 */
public class SqliteConnect {

    /* Sqlite */
    private static final String stringDeConexao = "jdbc:sqlite:/home/rogerio/NetBeansProjects/FluigDocDev/database/dataBase.db";
    // conexão
    private Connection conexao = null;
    // instrucao SQL
    private Statement instrucaoSQL;
    // resultados
    private ResultSet resultados;
    
    public String getUnicValue(String query) throws SQLException {
        try {
            System.out.println("query: " + query);
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(stringDeConexao);
            instrucaoSQL = conexao.createStatement();
            instrucaoSQL.executeQuery(query);
            resultados = instrucaoSQL.executeQuery(query);
            
            return resultados.getString(resultados.getMetaData().getColumnName(1));
            
        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao adicionar executar a query.");
            System.err.println(ex.getMessage());
        } finally {
            conexao.close();
        }
        
        return "";
    }
    
    public ResultSet getValues(String query) throws SQLException {
        try {
            System.out.println("query: " + query);
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(stringDeConexao);
            instrucaoSQL = conexao.createStatement();
            instrucaoSQL.executeQuery(query);
            resultados = instrucaoSQL.executeQuery(query);
            
            return resultados;
            
        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao adicionar executar a query.");
            System.err.println(ex.getMessage());
        } finally {
            conexao.close();
        }
        
        return null;
    }

    public void setDBValues(String query) throws SQLException {
        try {
            System.out.println("query: " + query);
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(stringDeConexao);
            instrucaoSQL = conexao.createStatement();
            instrucaoSQL.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao adicionar executar a query.");
            System.err.println(ex.getMessage());
        } finally {
            conexao.close();
        }
    }

    public DefaultComboBoxModel getResultComboBoxModel(String query) throws SQLException {
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            System.out.println("query: " + query);
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(stringDeConexao);
            instrucaoSQL = conexao.createStatement();
            resultados = instrucaoSQL.executeQuery(query);
            modelo.addElement("Selecione");
            
            while (resultados.next()) {
                modelo.addElement(resultados.getString(resultados.getMetaData().getColumnName(1)));
            }
            
            return modelo;
        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao adicionar executar a query.");
            System.err.println(ex.getMessage());
        } finally {
            conexao.close();
        }

        return null;
    }

    public DefaultTableModel getResultTableModel(String query) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        int colCount = 0;

        try {
            System.out.println("query: " + query);
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(stringDeConexao);
            instrucaoSQL = conexao.createStatement();

            resultados = instrucaoSQL.executeQuery(query);
            colCount = resultados.getMetaData().getColumnCount();

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
        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao adicionar executar a query.");
            System.err.println(ex.getMessage());
        } finally {
            conexao.close();
        }

        return null;
    }
}
