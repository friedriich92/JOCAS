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
    public void premerOkLogin(String userName, String passwrod) {
        //aqui la comprovacion de datos de entrada
        new SeleccionarCategoriaJugarPartidaGUI().setVisible(true);
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
        new EndevinaParaulesGUI().setVisible(true);
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
