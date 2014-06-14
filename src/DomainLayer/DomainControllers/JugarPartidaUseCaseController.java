package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.*;
import DomainLayer.DomainModel.*;

/**
 * Created by jedi on 10/06/14.
 */

public class JugarPartidaUseCaseController {
    
    public void FerAutentificacio(String userN, String passwd) {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlUsuariRegistrat ur = f.obtenirCtrlUsuariRegistrat();
        UsuariRegistrat usuariR = ur.obtenirUsuariRegistrat(userN);
        LoginUseCaseController lUSC = new LoginUseCaseController();
        lUSC.Login(userN, passwd);
        boolean juga = usuariR.esJugador();
        if (juga) throws IOException, ArrayIndexOutOfBoundsException ;
    }
}
