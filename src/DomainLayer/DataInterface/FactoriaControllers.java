package DomainLayer.DataInterface;

public class FactoriaControllers {
    
    private static FactoriaControllers instance;
    private CtrlPartida ctrlPart;
    private CtrlUsuariRegistrat ctrlUR;
    private CtrlCategoria ctrlCat;
    private CtrlJugador ctrlJug;
    private CtrlParaula ctrlPar;
    

    public static FactoriaControllers getInstance() {
        if (instance == null)
            instance = new FactoriaControllers();
        return instance;
    }
    
    public CtrlPartida getCtrlPartida() {
        if (ctrlPart == null) 
            ctrlPart = new DataLayer.CtrlPartida();
        return ctrlPart;
    }
    
     public CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
        if (this.ctrlUR == null) 
            ctrlUR = new DataLayer.CtrlUsuariRegistrat();
        return ctrlUR;
    }
    
    public CtrlCategoria getCtrlCategoria() {
        if (ctrlCat == null) 
            ctrlCat = new DataLayer.CtrlCategoria();
        return ctrlCat;
    }
    
    public CtrlJugador getCtrlJugador() {
        if (ctrlJug == null) 
            ctrlJug = new DataLayer.CtrlJugador();
        return ctrlJug;
    }
    
    public CtrlParaula getCtrlParaula() {
        if (ctrlPar == null)
            ctrlPar = new DataLayer.CtrlParaula();
        return ctrlPar;
    }
    
}
