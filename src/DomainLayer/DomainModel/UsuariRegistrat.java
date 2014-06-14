package DomainLayer.DomainModel;

/**
 * @version 1.0
 */
public class UsuariRegistrat {

    private String nom;
    private String cognom;
    private String username;
    private String pwd;

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public boolean contrassenyaIncorrecta(String passwd) {
        return !passwd.equals(this.pwd);
    }
    
    public boolean esJugador() {
        return false;
    }
}
