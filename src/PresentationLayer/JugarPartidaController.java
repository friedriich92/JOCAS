/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DomainLayer.DomainControllers.JugarPartidaUseCaseController;
import javax.swing.JFrame;
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
    public boolean premerOkLogin(String userName, String passwrod) {
        //aqui la comprovacion de datos de entrada
        boolean retorn = true;
        boolean jugador = true;
        boolean usuariValid = true;
        if (usuariValid) {
            new SeleccionarCategoriaJugarPartidaGUI().setVisible(true);
        }
        else if (!jugador) {
            //dudas
        }
        else {
            retorn = false;
        }
        return retorn;
    }
    public void premerOkCategoria(String nomCategoria) {
        //aqui pedir a dominio el numero de letras de la palabra
        //new FerJugadaJugarPartidaGUI().setVisible(true);
    }
    public int[] enviaLletra(JFrame frame,int posCasella, String lletra){
        JugarPartidaUseCaseController controlador = new JugarPartidaUseCaseController();
        return controlador.FerJugada(posCasella, lletra);
    }
    
    public void premerTornar() {
        System.exit(0);
    }
    public void premerOkFinalizar(JFrame frame) {
        frame.dispose();
    }
    
    public void premerAturar() {
        //cosa nazi
    }
    public void premerSortir() {
        System.exit(0);
    }
    
    
    
    
}
