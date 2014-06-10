package DomainLayer.DomainModel;

/**
 * @version 1.0
 */
public class Partida {

    private int idPartida;
    private boolean acabada;
    private boolean guanyada;
    private int errors;
    private Paraula teParaula;
    private Jugador jugador;
    private IEstrategiaPuntuacio estrategiaPuntuacio;

    public int getIdPartida() {
        return idPartida;
    }

    public boolean isAcabada() {
        return acabada;
    }

    public boolean isGuanyada() {
        return guanyada;
    }

    public int getErrors() {
        return errors;
    }

    public Paraula getTeParaula() {
        return teParaula;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public IEstrategiaPuntuacio getEstrategiaPuntuacio() {
        return estrategiaPuntuacio;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public void setAcabada(boolean acabada) {
        this.acabada = acabada;
    }

    public void setGuanyada(boolean guanyada) {
        this.guanyada = guanyada;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public void setTeParaula(Paraula teParaula) {
        this.teParaula = teParaula;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setEstrategiaPuntuacio(IEstrategiaPuntuacio estrategiaPuntuacio) {
        this.estrategiaPuntuacio = estrategiaPuntuacio;
    }
}
