package DomainLayer.DomainModel;

import java.util.ArrayList;
import javax.persistence.*;

/**
 * Created by jedi on 10/06/14.
 */
@Entity
@Table(name="CASELLA")
public class Casella {

	@EmbeddedId
	private CasellaPK casellaPK;

	@Column(name="LLETRA_CORRECTA")
    private Lletra lletraCorrecta;
	@Column(name="ES_ENCERTAT")
    private boolean esEncertat;
	@CollectionOfElements(fetch = FetchType.EAGER)
    private ArrayList<Lletra> lletresErronies;
    //private Partida p;

    public Casella(int idPartida, int pos, Lletra lletraCorrecta) {
        this.casellaPK = new CasellaPK(idPartida, pos);
        this.lletraCorrecta = lletraCorrecta;
    }
    //getters
    public int getPosicio() {
        return casellaPK.getPosicio();
    }

    public Lletra getLletraCorrecta() {
        return this.lletraCorrecta;
    }

    public boolean getEncert() {
        return this.esEncertat;
    }

    //setters
    public void setLletraCorrecta (Lletra novaLletraCorrecta) {
        this.lletraCorrecta = novaLletraCorrecta;
    }

    public void setEsEncertat (boolean encert) {
        this.esEncertat = encert;
    }

    public void setNovaLletraErronia (Lletra novaLletra) {
        this.lletresErronies.add(novaLletra);
    }
    
    public void novaCasella(Partida p, String lletra, int i) {
        casellaPK.setPosicio(i);
        casellaPK.setIdPartida(p.getIdPartida());
        lletraCorrecta = Lletra.valueOf(lletra);
    }
    
    public boolean comprovaCasella(int pos, String lletra, Integer acertadaAct) {
        if (casellaPK.getPosicio() == pos) {
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
