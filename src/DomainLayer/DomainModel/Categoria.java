package DomainLayer.DomainModel;

import javax.persistence.*;

/**
 * Created by jedi on 10/06/14.
 */
@Entity
@Table(name="CATEGORIA")
public class Categoria {
	@Id
	@Column(name="NOM")
    private String nom;

    public void setNom (String nouNom) {
        this.nom = nouNom;
    }

    public String getNom () {
        return this.nom;
    }
}
