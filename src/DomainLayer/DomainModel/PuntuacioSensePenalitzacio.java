package DomainLayer.DomainModel;

/**
 * @version 1.0
 */
public class PuntuacioSensePenalitzacio implements IEstrategiaPuntuacio {

    private int factorEncert;

    public int getFactorEncert() {
        return factorEncert;
    }

    public void setFactorEncert(int factorEncert) {
        this.factorEncert = factorEncert;
    }
    
    @Override
    public int obtePuntuacio(int errors,int nEncerts) {
        return nEncerts*factorEncert;
    }
}
