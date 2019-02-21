package main.java;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="livre")
public class Livre {
	@Id
	private Integer id;
	@Column(name="TITRE")
	private String titre;
	@Column(name="AUTEUR")
	private String auteur;
	
	@ManyToMany
	@JoinTable(name="compo",
			joinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"))
	private Set<Emprunt>emprunts;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
}
