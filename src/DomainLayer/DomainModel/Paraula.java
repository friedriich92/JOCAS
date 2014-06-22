package DomainLayer.DomainModel;

import javax.persistence.*;
/**
 * Created by jedi on 10/06/14.
 */
@Entity
@Table(name="PARAULA")
public class Paraula {

	@Id
	@Column(name="NOM")
    private String nom;
	@Column(name="NOMBRE_DE_LLETRES")
    private int nombreDeLletres;
	@ManyToOne
	@JoinColumn(name="CATEGORIA")
	private Categoria categoria;

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
    
    public String getLletraIessima(int i) {
        String[] s = nom.split("");
        return s[i+1];
    }
    
    //operacions
}
