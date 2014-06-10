package DomainLayer.DomainModel;

/**
 *  @version 1.0
 **/
public class Parametres {

    private static Parametres instance;
    private int nombreMaximErrors;

    public static Parametres getInstance() {
        if (instance == null) {
            instance = new Parametres();
        }
        return instance;
    }

    public int getNombreMaximErrors() {
        return nombreMaximErrors;
    }

    public void setNombreMaximErrors(int nombreMaximErrors) {
        this.nombreMaximErrors = nombreMaximErrors;
    }
}
