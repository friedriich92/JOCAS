package DomainLayer.DomainControllers;

import DomainLayer.Excepcions.*;
import DomainLayer.DataInterface.*;
import DomainLayer.DomainModel.*;


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
