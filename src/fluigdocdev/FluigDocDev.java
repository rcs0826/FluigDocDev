/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev;

import fluigdocdev.views.TelaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author rogerio
 */
public class FluigDocDev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // TODO code application logic here
            // Linha para mudar o estilo da aplicação
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        } catch (InstantiationException ex) {
            Logger.getLogger(FluigDocDev.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FluigDocDev.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FluigDocDev.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
