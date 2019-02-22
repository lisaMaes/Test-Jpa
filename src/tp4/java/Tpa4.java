package tp4.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/**
 * Appele la base de données pour les opération de persistence
 * @author Diginamic
 *
 */
public class Tpa4 {
	
	public static void main (String[] args){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banqueTp");
	//	EntityManager em = entityManagerFactory.createEntityManager();
		
		
		//Création des différents objets à genere afin d'initialiser la création des tables en bdd (cf drop and create)
		LocalDate dateNaiss = LocalDate.of(1989, 12, 3);
		LocalDate dateFin = LocalDate.of(2018, 04, 9);
		LocalDateTime now = LocalDateTime.of(2018, 04, 9, 12,52,00);
		
		Adresse adresse = new Adresse();
		adresse.setRue("Place Saint Marcel");
		adresse.setNumero(10);
		adresse.setCodePostal(05000);
		adresse.setVille("Gap");
		
		Banque banque = new Banque();
	
		banque.setNom("Bonne_paye");
		
		Client client = new Client();
		client.setDateNaissance(dateNaiss);
		client.setNom("Doe");
		client.setPrenom("Jane");
		client.setAdresse(adresse);
		client.setBanque(banque);
		
		Compte compte = new Compte();

		compte.setNumero("025sdkqskdm5445F");
		compte.setSolde(300.00);
		
		Compte compte1 = new Compte();

		compte1.setNumero("zjdklzj4645624654F");
		compte1.setSolde(100.00);
		
		Operation operation = new Operation();

		operation.setMontant(300.00);
		operation.setMotif("Allocs");
		operation.setDate(now);
		operation.setCompte(compte);
		
		Set<Operation> operations = new HashSet<Operation>();
		operations.add(operation);
		Set<Client> clients = new HashSet<Client>();
		clients.add(client);
		Set<Compte> comptes = new HashSet<Compte>();
		comptes.add(compte);

		
		banque.setClients(clients);
		
		client.setBanque(banque);
		client.setComptes(comptes);
		
		
		compte.setClients(clients);
		compte1.setClients(clients);
		compte.setOperations(operations);
		

		//creation d'une instance d'entity manager
		EntityManager em1 = entityManagerFactory.createEntityManager();
		
		//Creation d'une transition permet d'envoyer toute l'operaiton dun coup
		EntityTransaction et1 = em1.getTransaction();
		
		LivretA livretA = new LivretA();
		livretA.setTaux(9.00);
		livretA.setClients(clients);

		livretA.setNumero("456sd465szdklmekz4d65");
		livretA.setOperations(operations);
		livretA.setSolde(6000.00);
		
		Virement virement = new Virement();
		virement.setBeneficiaire("John Smith");
		virement.setCompte(compte1);
		virement.setDate(now);

		virement.setMontant(55.50);
		virement.setMotif("piouhpiouh");
		
		Set<Operation> operations1 = new HashSet<Operation>();
		operations1.add(virement);
		
		AssuranceVie assuranceVie = new AssuranceVie();
		assuranceVie.setDateFin(dateFin);
		assuranceVie.setTaux(15.00);
		assuranceVie.setClients(clients);

		assuranceVie.setNumero("4564646dkmlzqjkldj5df1qs465f");
		assuranceVie.setOperations(operations1);
		
		et1.begin();
		//persistence
		em1.persist(banque);
		em1.persist(client);
		em1.persist(compte);
		em1.persist(compte1);
		em1.persist(operation);
		
		
		em1.persist(livretA);
		em1.persist(virement);
		em1.persist(assuranceVie);
		
		//envoie des persitence
		et1.commit();
		//fermeture de l'entity manager
		em1.close();
	}
}
