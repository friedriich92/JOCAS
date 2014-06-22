package DomainLayer.DomainModel;

import java.util.ArrayList;
import javax.persistence.*;

/**
 * @version 1.0
 */
@Entity
@Table(name="JUGADOR")
@PrimaryKeyJoinColumn(name="USERNAME")
public class Jugador extends UsuariRegistrat {

	@Column(name="EMAIL", unique = true)
    private String email;
	@Column(name="PARTIDA_ACTUAL")
    private Partida partidaActual;
	@OneToMany(mappedBy="jugador")
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
    
    public void partidaActualAcabada() {
        partidesJugades.add(partidaActual);
        partidaActual = null;
    }
    
    public boolean HaGuanyatDos() {
        boolean b = false;
        int sum = 0;
        for (Partida partidaJugada : partidesJugades) {
            boolean g = partidaJugada.guanyada();
            if (g) ++sum;
            if (sum == 2) b = true;
            if (b) break;
        }
        return b;
    }
    
    public void afegeixPartida(Partida p) {
        partidaActual = p;
    }

}
