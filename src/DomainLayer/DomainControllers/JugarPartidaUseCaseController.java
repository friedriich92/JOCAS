package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.*;
import DomainLayer.DomainModel.*;
import DomainLayer.Excepcions.*;
import java.util.List;


public class JugarPartidaUseCaseController {
    String nomUsuari;
    int idP;
    
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
        CtrlCategoria CTcat = f.getCtrlCat();
        CtrlJugador CTj = f.getCtrlJugador();
        Categoria C = CTcat.get(cat);
        Paraula par = CTcat.getParaulaRandom();
        Jugador J = CTj.obteJugador(nomUsuari);
        Partida p = new Partida();
        int[] tCP = p.CreaPartida(C, J, par);
        idP = tCP[5];
        int[] newT = new int[5];
        for (int i = 0; i < 5; ++i) newT[i] = tCP[i];
        return newT;
    }
        
    
    public int[] FerJugada(int pos, String lletra) {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlPartida cP = f.obtenirCtrlPartida();
        int[] tup = null;
        //try {
            tup = cP.ferJugada(idP, pos, lletra);
        /*
        } catch (ExcepcionsAS eAS) {
            eAS.getMessage();
        }
        */
        return tup;
    }
    
    public void AturarPartida() {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlJugador cj = f.getCtrlJugador();
        //Jugador j = cj.obteJugador(nomUsuari);
        //j.partidaActualAcabada();
        cj.aturarPartidaActual(nomUsuari);
    }

}
