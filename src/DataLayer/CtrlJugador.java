package DataLayer;

import DomainLayer.DomainModel.Jugador;

/**
 * Created by joanbarroso on 14/06/14.
 */
public class CtrlJugador implements DomainLayer.DataInterface.CtrlJugador{
    @Override
    public Jugador obteJugador(String nomUsuari) {
        //codigo para que compile
        Jugador j = new Jugador();
        return j;
    }
    
    @Override
    public void aturarPartidaActual(String nomUsuari) {
        
    }

}
