package DomainLayer.DomainModel;

import javax.persistence.*;

@Embeddable
public class CasellaPK {

	protected int idPartida;
	protected int posicio;
	
	public CasellaPK() {};
	
	public CasellaPK(int idPartida, int posicio) {
		this.idPartida = idPartida;
		this.posicio = posicio;
	}
        
        public int getPosicio() {
            return posicio;
        }
        
        public int getIdPartida() {
            return idPartida;
        }
        
        public void setPosicio(int pos) {
            posicio = pos;
        }
        
        public void setIdPartida(int idP) {
            idPartida = idP;
        }
	
}
