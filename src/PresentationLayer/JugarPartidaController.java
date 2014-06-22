/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DomainLayer.DomainControllers.JugarPartidaUseCaseController;
import DomainLayer.DomainControllers.LoginUseCaseController;
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
    public boolean premerOkLogin(String userName, String passwrod,JFrame f) {
        String[] categories = {"hola", "esto" ,"es" ,"una" ,"prueva","a", "ver", "si","hace", "scroll"};
        new SeleccionarCategoriaJugarPartidaGUI(categories).setVisible(true);
        return true;
    }
    public void premerOkCategoria(String nomCategoria) {
        //aqui pedir a dominio crear la partida. Te devolverá una tupla
        //que contiene el número de palabras, para dibujar las casillas.
        //new FerJugadaJugarPartidaGUI().setVisible(true);
        JugarPartidaUseCaseController controlador = new JugarPartidaUseCaseController();
        int[] tup = controlador.CrearPartida(nomCategoria);
        new FerJugadaJugarPartidaGUI(tup[0], tup[1], tup[2], tup[3], tup[4]).setVisible(true);
    }
    public int[] enviaLletra(int posCasella, String lletra){
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
