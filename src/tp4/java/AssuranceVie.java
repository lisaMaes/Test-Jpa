package tp4.java;

import java.time.LocalDate;

import javax.persistence.Entity;
/***
 * Manage la table assurance vie qui herite de la classe compte
 * @author Diginamic
 *
 */
@Entity
public class AssuranceVie extends Compte{
	
	private LocalDate dateFin;
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	private double taux;
}
