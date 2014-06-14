package DomainLayer.DomainModel;

/**
 * Created by jedi on 10/06/14.
 */
public class Paraula {

    private String nom;
    private int nombreDeLletres;

    //setters
    public void setNom (String nouNom) {
        this.nom = nouNom;
    }

    public void setNombreDeLletres(int nouNombreDeLletres) {
        this.nombreDeLletres = nouNombreDeLletres;
    }
    //getters
    public String getNom () {
        return this.nom;
    }

    public int getNombreDeLletres() {
        return this.nombreDeLletres;
    }

    //operacions
}
