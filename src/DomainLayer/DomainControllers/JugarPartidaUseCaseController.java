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
        return new Partida().crearPartida(jug, randPar);

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
