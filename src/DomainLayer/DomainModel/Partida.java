package DomainLayer.DomainModel;

import DomainLayer.DataInterface.FactoriaControllers;
import DomainLayer.Excepcions.ExcepcionsAS;
import java.util.ArrayList;
import java.util.List;

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
    private List<Casella> caselles;

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
    
    public List<Casella> getCaselles() {
        return caselles;
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
    
    public void setCaselles(List<Casella> caselles) {
        this.caselles = caselles;
    }
    
    public boolean guanyada() {
        return guanyada;
    }
    
    public int[] CreaPartida(Categoria C, Jugador J, Paraula par) {
        Parametres p = Parametres.getInstance();
        int id = p.NovaPartida();
        int e = p.getNombreMaximErrors();
        idPartida = id;
        teParaula = par;
        acabada = false;
        guanyada = false;
        jugador = J;
        boolean b = jugador.HaGuanyatDos();
        jugador.afegeixPartida(this);
        
        int factorEncert = 3;
        int factorError = 1;
        
        if (b) {
            FactoriaControllers f = FactoriaControllers.getInstance();
            PuntuacioAmbPenalitzacio PAP = new PuntuacioAmbPenalitzacio();
            // inicializar la puntuacion (?)
            PAP.setFactorEncert(factorEncert);
            PAP.setFactorError(factorError);
            estrategiaPuntuacio = PAP;
        }
        else {
            PuntuacioSensePenalitzacio PSP = new PuntuacioSensePenalitzacio();
            PSP.setFactorEncert(factorEncert);
            estrategiaPuntuacio = PSP;
        }
        int i = 0;
        //par.assignaPartida(this); (esta en el diagrama pero la clase Palabra no tiene partidas
        int nombrell = par.getNombreDeLletres();
        while (i < nombrell - 1) {
            String lletra = par.getLletraIessima(i);
            Casella cas = new Casella();
            cas.novaCasella(this, lletra, i);
            caselles.add(cas);
            ++i;
        }
        int[] res = new int[6];
        /*
        res(0) : puntuacioInicial
        res(1) : nombreMaximErrors
        res(2) : puntuacioPerEncert
        res(3) : puntuacioPerError
        res(4) : nombre de lletres
        res(5) : idPartida
        */
        res[0] = 0;
        res[1] = e;
        res[2] = factorEncert;
        res[3] = factorError;
        res[4] = nombrell;
        res[5] = idPartida;

        return res;
    }
    
    
    public List<Integer> FerJugada(int pos, String lletra) throws ExcepcionsAS {
        Lletra[] lletres = Lletra.values();
        boolean found = false;
        for (Lletra ll : lletres) 
            if (ll.toString().equals(lletra)) found = true;
        if (!found) throw new ExcepcionsAS("La lletra es Incorrecta");
        guanyada = true;
        Integer acertadaAct = 0;
        int nEncerts = 0;
        for (Casella c : caselles) {
            boolean encert = c.comprovaCasella(pos, lletra, acertadaAct);
            if (!encert) guanyada = false;
            else ++nEncerts;
        }
        Parametres p = Parametres.getInstance();
        int nME = p.getNombreMaximErrors();
        if (acertadaAct == 0) ++errors;
        acabada = (guanyada || (errors > nME));
        int punts = estrategiaPuntuacio.obtePuntuacio(errors, nEncerts);
        if (guanyada) {
            String nom = teParaula.getNom();
            FactoriaControllers f = FactoriaControllers.getInstance();
            //enviar el mensaje (nom, punts, errors)
        }
        if (acabada)
            jugador.actualitzaRols(this);
        List<Integer> tup = new ArrayList<Integer>();
        tup.add(acertadaAct);
        Integer acabadaI = (acabada) ? 1 : 0;
        Integer guanyadaI = (guanyada) ? 1 : 0;
        tup.add(acabadaI);
        tup.add(guanyadaI);
        tup.add(punts);
        tup.add(errors);
        return tup;
    }
    
    
    
}
