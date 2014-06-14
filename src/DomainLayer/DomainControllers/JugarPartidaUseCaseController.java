package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.*;
import DomainLayer.DomainModel.*;
import Excepcions.pwdIncorrecte;
import Excepcions.usuariNoJugador;

/**
 * Created by jedi on 10/06/14.
 */

public class JugarPartidaUseCaseController {
    String nomUsuari;
    int idP;
    
    public void FerAutentificacio(String userN, String passwd) throws usuariNoJugador {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlUsuariRegistrat ur = f.obtenirCtrlUsuariRegistrat();
        UsuariRegistrat usuariR = ur.obtenirUsuariRegistrat(userN);
        LoginUseCaseController lUSC = new LoginUseCaseController();
        
        try {
            lUSC.Login(userN, passwd);
        }
        
        catch(pwdIncorrecte pI) {
            pI.getMessage();
        }
        
        boolean juga = usuariR.esJugador();
        if (juga) throw new usuariNoJugador("Aquest Usuari no es un Jugador");
        nomUsuari = userN;
    }
}
