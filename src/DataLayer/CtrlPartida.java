package DataLayer;

import DomainLayer.DomainModel.Partida;

/**
 * Created by joanbarroso on 14/06/14.
 */
public class CtrlPartida implements DomainLayer.DataInterface.CtrlPartida {
    @Override
    public Partida getPartida(int idP) {
        //codigo para que deje compilar
        Partida p = new Partida();
        return p;
    }
    
    public int[] ferJugada(int idP, int pos, String lletra) {
        return new int[]{0,1,2,3,4};
    }
}
