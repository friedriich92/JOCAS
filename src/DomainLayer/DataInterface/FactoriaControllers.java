package DomainLayer.DataInterface;

public class FactoriaControllers {
    
    private static FactoriaControllers instance;

    public static FactoriaControllers getInstance() {
        if (instance == null)
            instance = new FactoriaControllers();
        return instance;
    }
    
    public CtrlPartida obtenirCtrlPartida() {
        DomainLayer.DataInterface.CtrlPartida cP = new DataLayer.CtrlPartida();
        return cP;
    }
    
     public CtrlUsuariRegistrat obtenirCtrlUsuariRegistrat() {
        DomainLayer.DataInterface.CtrlUsuariRegistrat cUR = new DataLayer.CtrlUsuariRegistrat();
        return cUR;
    }
    
    public CtrlCategoria getCtrlCat() {
        DomainLayer.DataInterface.CtrlCategoria cC = new DataLayer.CtrlCategoria();
        return cC;
    }
    
    public CtrlJugador getCtrlJugador() {
        DomainLayer.DataInterface.CtrlJugador cJ = new DataLayer.CtrlJugador();
        return cJ;

    }
    
}
