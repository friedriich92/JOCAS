package DomainLayer.Adapters;


public class FactoriaAdapter {
    private static FactoriaAdapter instance;
    private IMissatgeAdapter iMissatgeAdapter;
    
    public FactoriaAdapter getInstance() {
        if (instance == null)
            instance = new FactoriaAdapter();
        return instance;
    }
    
    public IMissatgeAdapter getIMissatgeAdapter() {
        if (iMissatgeAdapter == null)
            iMissatgeAdapter = new IMissatgeAdapter();
        return iMissatgeAdapter;
    }
}
