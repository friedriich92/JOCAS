package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Jugador;

/**
 * Created by jedi on 10/06/14.
 */
public interface CtrlJugador {
    public Jugador obteJugador(String nomUsuari);
    
    public void aturarPartidaActual(String nomUsuari);
}
