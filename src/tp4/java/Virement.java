package tp4.java;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/***
 * Manage la classe virement
 * relation de d�pendance de la operation
 * Typage en v si c'est une virement sinon sera consid�ra juste comme une op�ration
 * @author Diginamic
 *
 */
@Entity
@DiscriminatorValue("V")
public class Virement extends Operation{

	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}