/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev;

import java.io.IOException;
import java.io.File;
import java.io.DataInput;

/**
 *
 * @author rogerio
 */
public class ArqDir {
    
    public File[] getListFile(){
        String dir = "/home/rogerio/Documentos/Google Drive/TDS/WorkspaceFluig/Santher";    
        File allDir = new File(dir);
        File[] arquivos = allDir.listFiles();       
    
        for ( int i = 0; i < arquivos.length; i++){
            System.out.println(arquivos[i].getName());
        }
        
        return arquivos;
    }
}
