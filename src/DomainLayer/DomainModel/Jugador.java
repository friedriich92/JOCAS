package DomainLayer.DomainModel;

import java.util.ArrayList;

/**
 * @version 1.0
 */
public class Jugador extends UsuariRegistrat {

    private String email;
    private Partida partidaActual;
    private ArrayList<Partida> partidesJugades;

    public String getEmail() {
        return email;
    }

    public Partida getPartidaActual() {
        return partidaActual;
    }

    public ArrayList<Partida> getPartidesJugades() {
        return partidesJugades;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPartidaActual(Partida partidaActual) {
        this.partidaActual = partidaActual;
    }

    public void setPartidesJugades(ArrayList<Partida> partidesJugades) {
        this.partidesJugades = partidesJugades;
    }
    
    @Override
    public boolean esJugador() {
        return true;
    }
    
    public void actualitzaRols(Partida p) {
        partidaActual = null;
        partidesJugades.add(p);
    }

}
