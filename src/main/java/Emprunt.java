package main.java;
/**
 * Manage les emprunts avec une many to many sur les livre et 
 * une relation d'un client par emprunt
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Emprunt")

public class Emprunt {

	@Id
	private Integer id;
	@Column(name="DATE_DEBUT")
	private LocalDateTime dateDebut;
	@Column(name="DATE_FIN", nullable = true)
	private LocalDateTime dateFin;
	@Column(name="DELAI",nullable = true)
	private Integer delai;
	
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT", nullable=false)
	private Client client;
	
	@ManyToMany(mappedBy="emprunts")
	private Set<Livre>livre;
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDateTime getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Livre> getLivre() {
		return livre;
	}
	public void setLivre(Set<Livre> livre) {
		this.livre = livre;
	}
	
	public String formatDateSQL(LocalDateTime date){
		String newDate;
		
		if(date != null){
			 newDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));			
		}else{
			 newDate = "non renseigné";
		}		

				
		return newDate;
	}

}
