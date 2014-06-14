package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.CtrlUsuariRegistrat;
import DomainLayer.DataInterface.FactoriaControllers;
import DomainLayer.DomainModel.UsuariRegistrat;
import Excepcions.pwdIncorrecte;

/**
 * Created by jedi on 10/06/14.
 */

public class LoginUseCaseController {
    public void Login(String userN, String passwd) throws pwdIncorrecte {
        
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlUsuariRegistrat cUR = f.obtenirCtrlUsuariRegistrat();
        UsuariRegistrat usuariR = cUR.obtenirUsuariRegistrat(userN);
        if (usuariR.contrassenyaIncorrecta(passwd)) throw new pwdIncorrecte("Password Incorrecte");
        
    }
}
