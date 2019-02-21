package main.java;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Set;

public class TestJpa {

	public static void main( String[] args ){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestJpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//Avec un find trouver un livre
		Livre livre = em.find(Livre.class, 2);
		
		if(livre != null){
			System.out.println(livre.getId());
			System.out.println(livre.getTitre());
			System.out.println(livre.getAuteur());
		}
		
		//Afficher le livre dont le titre est 1001 recettes de Cuisine
		Query query = em.createQuery("select l from Livre l where l.titre = '1001 recettes de Cuisine'");
		 Livre livre1 = (Livre) query.getResultList().get(0);
		 
		 if(livre1 != null){
				System.out.println(livre1.getId());
				System.out.println(livre1.getTitre());
				System.out.println(livre1.getAuteur());
		 }
		 
		 //Réaliser une requête qui permet d’extraire un  emprunt et tous ses livres associés.
		 Emprunt emprunt = em.find(Emprunt.class, 1);
		 
		 if(emprunt != null){
				System.out.println(emprunt.getId());
				System.out.println(emprunt.formatDateSQL(emprunt.getDateDebut())+" -> "+emprunt.formatDateSQL(emprunt.getDateFin()));
				
				
				Set<Livre> livres = emprunt.getLivre();

				for (Livre l: livres) { 
					
					System.out.println(l.getTitre()); 
				}

		 }
		 
		 //Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
		 Client client = em.find(Client.class, 1);
		 
		 if(client != null){
				System.out.println(client.getId());
				System.out.println(client.getNom());
				System.out.println(client.getPrenom());
				
				Set<Emprunt> emprunt1 = client.getEmprunts();

				for (Emprunt e: emprunt1) { 
					
					System.out.println(e.formatDateSQL(e.getDateDebut())+" -> "+e.formatDateSQL(e.getDateFin()));
					Set<Livre> livres = e.getLivre();

					for (Livre l: livres) { 
						
						System.out.println(l.getTitre()); 
					}

				}

		 }
		 
		 
	}
}
