package DomainLayer.DomainModel;

/**
 *  @version 1.0
 **/
@Entity
@Table(name="PARAMETRES")
public class Parametres {

    private static Parametres instance;
    @Column(name="MAX_ERRORS")
    private int nombreMaximErrors;
    //private int idPartida;

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
    
    /*
    public int getIdPartida() {
        return idPartida;
    }
    
    
    
    public void setIdPartida(int idP) {
        idPartida = idP;
    }
    

    
    public int NovaPartida() {
        idPartida++;
        return idPartida;
    }*/
    
}
