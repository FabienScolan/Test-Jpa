package banque.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class LivretA extends Compte {

	@Column(name="TAUX", nullable=false)
	private double taux;

	public LivretA() {
		
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	
}
