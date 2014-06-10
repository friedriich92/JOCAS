package DomainLayer.DomainModel;

/**
 * @version 1.0
 */
public class PuntuacioAmbPenalitzacio implements IEstrategiaPuntuacio {

    private int factorEncert;
    private int factorError;

    public int getFactorEncert() {
        return factorEncert;
    }

    public int getFactorError() {
        return factorError;
    }

    public void setFactorEncert(int factorEncert) {
        this.factorEncert = factorEncert;
    }

    public void setFactorError(int factorError) {
        this.factorError = factorError;
    }
}
