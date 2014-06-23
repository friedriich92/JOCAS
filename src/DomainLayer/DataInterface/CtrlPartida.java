package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Partida;

/**
 * Created by jedi on 10/06/14.
 */
public interface CtrlPartida {
    public Partida getPartida(int idP);
    
    public int[] ferJugada(int idP, int pos, String lletra);
    
    //public int[] crearPartida(Jugador jug, Paraula par);
}
