/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DomainLayer.DomainControllers.JugarPartidaUseCaseController;
import DomainLayer.DomainControllers.LoginUseCaseController;
import DomainLayer.DomainControllers.ConsultarCategoriesUseCaseController;
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
        try {
            new LoginUseCaseController().Login(userName, passwrod);
            f.dispose();           
            String[] categories = new ConsultarCategoriesUseCaseController().ConsultarCategories();
            new SeleccionarCategoriaJugarPartidaGUI(categories).setVisible(true);
        }
        catch (/*usuari no jugador*/) {
            return true;
        }
        catch(/*usuari no existeix*/) {
            return false;
        }
        return false;
    }
    public boolean premerOkCategoria(String nomCategoria) {
        //aqui pedir a dominio crear la partida. Te devolverá una tupla
        //que contiene el número de palabras, para dibujar las casillas.

        /*se necesita el boleano para ver si la categoria tiene palabras*/
        /*******incompleto*******/
        /*retornar true si todo ha ido bien, retornar false si la categoria no tiene palabras*/
        JugarPartidaUseCaseController controlador = new JugarPartidaUseCaseController();
        int[] tup = controlador.CrearPartida(nomCategoria);
        new FerJugadaJugarPartidaGUI(tup[0], tup[1], tup[2], tup[3], tup[4]).setVisible(true);
        return true;
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
