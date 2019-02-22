package tp4.java;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;
/**
 * Manage la table client
 * embarque l'objet adresse
 * A une relation de many to many avec la classe compte
 * Et une relation d'une banque par client
 * @author Diginamic
 *
 */
@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="date_naissance")
	private LocalDate dateNaissance;
	
	@ManyToMany
	@JoinTable(name="cli_compte",
			joinColumns=@JoinColumn(name="ID_CLI", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="ID_COM", referencedColumnName="id"))
	private Set<Compte> comptes;
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE", nullable=false)
	private Banque banque;
	
	@Embedded
	private Adresse adresse;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
