package DomainLayer.DomainModel;

import javax.persistence.*;
/**
 * @version 1.0
 */
@Entity
@Table(name="ADMINISTRADOR")
@PrimaryKeyJoinColumn(name="USERNAME")
public class Administrador extends UsuariRegistrat {

	@Column(name="TLFN")
    private String tlfn;

    public String getTlfn() {
        return tlfn;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }
}
