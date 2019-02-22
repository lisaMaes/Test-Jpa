package tp4.java;

import java.time.LocalDateTime;

import javax.persistence.*;
/***
 * Manage la classe et la table opération 
 * Relation avec un seul compte par opérations mais plusieurs opération par compte
 * @author Diginamic
 *
 */
@Entity
@Table(name="operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public class Operation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="date")
	private LocalDateTime date;
	@Column(name="montant")
	private double montant;
	@Column(name="motif")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="ID_COM")
	private Compte compte;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}
