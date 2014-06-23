/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DomainLayer.DomainControllers.JugarPartidaUseCaseController;
import DomainLayer.DomainControllers.LoginUseCaseController;
import DomainLayer.DomainControllers.ConsultarCategoriesUseCaseController;
import javax.swing.JFrame;
import DomainLayer.Excepcions.ExcepcionsAS;
/**
 *
 * @author joaquin.campos
 */
public class JugarPartidaController {
    DomainLayer.DomainControllers.JugarPartidaUseCaseController jugarController = new DomainLayer.DomainControllers.JugarPartidaUseCaseController();
    
    public static void main(String args[]) {
        new EndevinaParaulesGUI().setVisible(true);
    }
    public void premerJugarPartida() {
        new AutenticacioGUI().setVisible(true);
    }
    public boolean premerOkLogin(String userName, String passwrod,JFrame f) {
        try {
            new LoginUseCaseController().Login(userName, passwrod);
            f.dispose();           
            String[] categories = new ConsultarCategoriesUseCaseController().ConsultarCategories();
            new SeleccionarCategoriaJugarPartidaGUI(categories).setVisible(true);
        }
        catch (ExcepcionsAS eAS) {
            if (eAS.getMessage().equals("Password Incorrecte")) return false;
            else if (eAS.getMessage().equals("Aquest Usuari no e un Jugador")) return true;

        }
        return false;
    }
    public boolean premerOkCategoria(String nomCategoria) {
        new JugarPartidaUseCaseController().getParaulesByCategoria(nomCategoria);
        if (new JugarPartidaUseCaseController().getParaulesByCategoria(nomCategoria)) {
            JugarPartidaUseCaseController controlador = new JugarPartidaUseCaseController();
            int[] tup = controlador.CrearPartida(nomCategoria);
            new FerJugadaJugarPartidaGUI(tup[0], tup[1], tup[2], tup[3], tup[4]).setVisible(true);
            return true;
        }
        else return false;

    }
    public int[] enviaLletra(int posCasella, String lletra){
        JugarPartidaUseCaseController controlador = new JugarPartidaUseCaseController();
        try {
            return controlador.FerJugada(posCasella, lletra);
        } catch (ExcepcionsAS e) {
            if (e.getMessage().equals("La lletra es Incorrecta")) {
                int[] result = new int[]{-1};
                return result;
            }
            return null;
        }
    }
    
    public void premerTornar() {
        System.exit(0);
    }
    public void premerOkFinalizar(JFrame frame) {
        frame.dispose();
    }
    
    public void premerAturar() {
        new JugarPartidaUseCaseController().AturarPartida();
    }
    public void premerSortir() {
        System.exit(0);
    }  
}
