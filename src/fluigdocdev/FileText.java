/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author rogerio
 */
public class FileText {

    public String getReader(String pathFile) {
        String ret = "";
        try {
            FileReader arq = new FileReader(pathFile);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); 
            while (linha != null) {
                linha = lerArq.readLine();
                ret += linha + "\r\n";
            }
            arq.close();
            return ret;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        return null;
    }
    
    public String getFiles(String path){
        System.out.println(path);
        String result = "";
        File pasta = new File(path);
        
        File[] arquivos = pasta.listFiles();
       
        for( int i =0;i < arquivos.length;i++) { 
            if(arquivos[i].isDirectory()){
                result+= (i+1) + ") "+ arquivos[i].getName() + "\r\n";
                result += this.getFiles(pasta.getPath()+"/"+arquivos[i].getName());
            }  
            else{
                result+= "\t" + (i+1) + ") "+ arquivos[i].getName() + "\r\n";
            }
            
        }
        
        return result;
    }
}
