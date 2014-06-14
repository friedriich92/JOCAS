package DomainLayer.DataInterface;

public class FactoriaControllers {
    
    private static FactoriaControllers instance;
    private static CtrlPartida cP;
    private static CtrlUsuariRegistrat cUR;
    private static CtrlCategoria cC;
    private static CtrlJugador cJ;
    

    public static FactoriaControllers getInstance() {
        if (instance == null)
            instance = new FactoriaControllers();
        return instance;
    }
    
    public CtrlPartida obtenirCtrlPartida() {
        if (this.cP == null) 
            cP = new DataLayer.CtrlPartida();
         
        return cP;
    }
    
     public CtrlUsuariRegistrat obtenirCtrlUsuariRegistrat() {
        if (this.cUR == null) 
            cUR = new DataLayer.CtrlUsuariRegistrat();
        
        return cUR;
    }
    
    public CtrlCategoria getCtrlCat() {
        if (this.cC == null) 
            cC = new DataLayer.CtrlCategoria();
        return cC;
    }
    
    public CtrlJugador getCtrlJugador() {
        if (this.cJ == null) 
            cJ = new DataLayer.CtrlJugador();
        return cJ;
    }
    
}
