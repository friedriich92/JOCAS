package DomainLayer.DomainModel;

/**
 * Created by jedi on 10/06/14.
 */
public class Paraula {

    private String nom;
    private int nombreDeLletres;

    //setters
    private void setNom (String nouNom) {
        this.nom = nouNom;
    }

    private void setNombreDeLletres(int nouNombreDeLletres) {
        this.nombreDeLletres = nouNombreDeLletres;
    }
    //getters
    private String getNom () {
        return this.nom;
    }

    private int getNombreDeLletres() {
        return this.nombreDeLletres;
    }

    //operacions
}
