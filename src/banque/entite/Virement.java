package banque.entite;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity
public class Virement extends Operation {
	@Column(name="BENEFICIAIRE", nullable = false)
	private String beneficiaire;
	public Virement(){
		
	}
	
	
}
