package DomainLayer.DomainModel;

import javax.persistence.*;

/**
 * @version 1.0
 */
@Entity
@Table(name="USUARI_REGISTRAT")
@Inheritance(strategy = InheritanceType.JOINED)
public class UsuariRegistrat {

    @Id
    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String pwd;
    @Column(name="NOM")
    private String nom;
    @Column(name="COGNOM")
    private String cognom;

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
