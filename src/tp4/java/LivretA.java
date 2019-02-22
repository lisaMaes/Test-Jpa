package tp4.java;

import javax.persistence.Entity;
/***
 * Manage les livret A hérite de la classe compte
 * @author Diginamic
 *
 */
@Entity
public class LivretA extends Compte{

	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
}
