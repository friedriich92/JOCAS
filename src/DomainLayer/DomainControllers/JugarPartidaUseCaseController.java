package DomainLayer.DomainControllers;

import DomainLayer.Excepcions.*;
import DomainLayer.DataInterface.*;
import DomainLayer.DomainModel.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jedi on 10/06/14.
 */

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
    
    public List<String> ObtenirCategories() {
        ConsultarCategoriesUseCaseController cGUSC = new ConsultarCategoriesUseCaseController();
        List<String> nomCategories = new ArrayList<String>();
        try {
            nomCategories = cGUSC.ConsultarCategories();
        }
        catch(ExcepcionsAS eAS) {
            eAS.getMessage();
        }
        return nomCategories;
    }
    
    public List<Integer> FerJugada(int pos, String lletra) {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlPartida cP = f.obtenirCtrlPartida();
        Partida p = cP.getPartida(idP);
        List<Integer> tup = new ArrayList<Integer>();
        try {
            tup = p.FerJugada(pos, lletra);
        } catch (ExcepcionsAS eAS) {
            eAS.getMessage();
        }
        return tup;
    }
    
    
    
}
