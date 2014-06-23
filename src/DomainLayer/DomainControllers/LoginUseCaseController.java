package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.CtrlUsuariRegistrat;
import DomainLayer.DataInterface.FactoriaControllers;
import DomainLayer.DomainModel.UsuariRegistrat;
import DomainLayer.Excepcions.*;

/**
 * Created by jedi on 10/06/14.
 */

public class LoginUseCaseController {
    public void Login(String userN, String passwd) throws ExcepcionsAS {
        
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlUsuariRegistrat cUR = f.getCtrlUsuariRegistrat();
        UsuariRegistrat usuariR = cUR.obtenirUsuariRegistrat(userN);
        if (usuariR.contrassenyaIncorrecta(passwd)) throw new ExcepcionsAS("Password Incorrecte");
        
    }
}
