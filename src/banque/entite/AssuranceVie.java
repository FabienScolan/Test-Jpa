package banque.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	@Column(name="TAUX", nullable=false)
	private double taux;
	@Column(name="DATE_FIN", nullable=false)
	private LocalDate dateFin;

	public AssuranceVie(){
		
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
}
