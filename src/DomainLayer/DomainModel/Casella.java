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
    public int getPosicio() {
        return posicio;
    }

    public Lletra getLletraCorrecta() {
        return this.lletraCorrecta;
    }

    public boolean getEncert() {
        return this.esEncertat;
    }

    //setters
    public void setPosicio (int novaPosicio) {
        this.posicio = novaPosicio;
    }

    public void setLletraCorrecta (Lletra novaLletraCorrecta) {
        this.lletraCorrecta = novaLletraCorrecta;
    }

    public void setEsEncertat (boolean encert) {
        this.esEncertat = encert;
    }

    public void setNovaLletraErronia (Lletra novaLletra) {
        this.lletresErronies.add(novaLletra);
    }
    
    public boolean comprovaCasella(int pos, String lletra, Integer acertadaAct) {
        if (posicio == pos) {
            Lletra a = Lletra.valueOf(lletra);
            boolean encert = (lletra.equals(lletraCorrecta.toString()));
            if (!encert) { 
                lletresErronies.add(a);
                esEncertat = false;
            }
            else { 
                acertadaAct = 1;
                esEncertat = true;
            }
            return encert;
        }
        return esEncertat;
    }


}