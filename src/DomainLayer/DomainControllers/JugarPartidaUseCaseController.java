package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.*;
import DomainLayer.DomainModel.*;
import DomainLayer.Excepcions.*;
import java.util.Random;


public class JugarPartidaUseCaseController {
    private String nomUsuari;
    private int idP;
    
    public void FerAutentificacio(String userN, String passwd) throws ExcepcionsAS {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlUsuariRegistrat ur = f.obtenirCtrlUsuariRegistrat();
        UsuariRegistrat usuariR = ur.obtenirUsuariRegistrat(userN);
        LoginUseCaseController lUSC = new LoginUseCaseController();
        
        try {
            lUSC.Login(userN, passwd);
        }
        
        catch(ExcepcionsAS eAS) {
            eAS.getMessage();
        }
        
        boolean juga = usuariR.esJugador();
        if (juga) throw new ExcepcionsAS("Aquest Usuari no es un Jugador");
        nomUsuari = userN;
    }
    
    public String[] ObtenirCategories() {
        ConsultarCategoriesUseCaseController cGUSC = new ConsultarCategoriesUseCaseController();
        String[] nomCategories = null;
        try {
            nomCategories = cGUSC.ConsultarCategories();
        }
        catch(ExcepcionsAS eAS) {
            eAS.getMessage();
        }
        return nomCategories;
    }
    
    public int[] CrearPartida(String cat) {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlCategoria CTcat = f.getCtrlCategoria();
        CtrlJugador CTj = f.getCtrlJugador();
        Paraula par = CTcat.getParaulaRandom(cat);
        Jugador J = CTj.obteJugador(nomUsuari);
        Partida p = new Partida();
        int[] tCP = p.CreaPartida(J, par);
        idP = tCP[5];
        int[] newT = new int[5];
        for (int i = 0; i < 5; ++i) newT[i] = tCP[i];
        return newT;

        /*
        CtrlJugador ctrlJug = f.getCtrlJugador();
        CtrlParaula ctrlPar = f.getCtrlParaula();
        CtrlPartida ctrlPart = f.getCtrlPartida();
        
        Paraula[] pars = ctrlPar.getParaulesByCategoria(cat);
        int randomValue = new Random().nextInt(pars.length + 1);
        Paraula randPar = pars[randomValue];
        
        Jugador jug = ctrlJug.obteJugador(nomUsuari);

        //¿Utilizar el Ctrl de Partida para crear la Partida?
        //return ctrlPart.crearPartida(jug, randPar);
        //No, se ha de crear aquí mismo.
        return new Partida().crearPartida(jug, randPar);*/

    }
        
    
    public int[] FerJugada(int pos, String lletra) {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlPartida cP = f.getCtrlPartida();
        Partida p = cP.getPartida(idP);
        int[] tup = new int[0];
        try {
            tup = p.FerJugada(pos, lletra);
        } catch (ExcepcionsAS eAS) {
            eAS.getMessage();
        }
        return tup;
    }
    
    public void AturarPartida() {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlJugador cj = f.getCtrlJugador();
        Jugador j = cj.obteJugador(nomUsuari);
        j.partidaActualAcabada();
        //cj.aturarPartidaActual(nomUsuari);
    }
    
    public boolean getParaulesByCategoria(String cat) {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlParaula cP = f.getCtrlParaula();
        Paraula[] p = cP.getParaulesByCategoria(cat);
        if (p == null) return false;
        return true;
    }

}
