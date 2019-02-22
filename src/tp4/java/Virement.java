package tp4.java;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/***
 * Manage la classe virement
 * relation de dépendance de la operation
 * Typage en v si c'est une virement sinon sera considéra juste comme une opération
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