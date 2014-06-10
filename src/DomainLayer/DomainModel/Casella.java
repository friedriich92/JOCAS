package DomainLayer.DomainModel;

import java.util.ArrayList;

/**
 * Created by jedi on 10/06/14.
 */
public class Casella {

    private int posicio;
    private Lletra lletraCorrecta;
    private boolean esEncertat;
    private ArrayList<Lletra> lletresErronies;

    //getters
    private int getPosicio () {
        return posicio;
    }

    private Lletra getLletraCorrecta() {
        return this.lletraCorrecta;
    }

    private boolean getEncert() {
        return this.esEncertat;
    }

    //setters
    private void setPosicio (int novaPosicio) {
        this.posicio = novaPosicio;
    }

    private void setLletraCorrecta (Lletra novaLletraCorrecta) {
        this.lletraCorrecta = novaLletraCorrecta;
    }

    private void setEsEncertat (boolean encert) {
        this.esEncertat = encert;
    }

    private void setNovaLletraErronia (Lletra novaLletra) {
        this.lletresErronies.add(novaLletra);
    }


}