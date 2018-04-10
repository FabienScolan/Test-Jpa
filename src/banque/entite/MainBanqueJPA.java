package banque.entite;

import java.util.HashSet;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainBanqueJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque_jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Banque b = new Banque();
		b.setNom("Banque A");
		Client c = new Client();
		c.setNom("Dupond");
		c.setPrenom("Jean");
		LocalDate dateNaissance = LocalDate.of(1990, 7, 10);
		c.setDateNaissance(dateNaissance );
		c.setAdresse(new Adresse());
		c.getAdresse().setCodePostal(22400);
		c.getAdresse().setRue("rue des genets");
		c.getAdresse().setVille("LAMBALLE");
		c.getAdresse().setNumero(4);
		c.setBanque(b);
		LivretA lA = new LivretA();
		lA.setNumero("123456");
		lA.setSolde(1000.0);
		lA.setTaux(0.8);
		Set<Client> lCli = new HashSet<Client>();
		lCli.add(c);
		lA.setClients(lCli);
		em.persist(b);
		em.persist(c);
		em.persist(lA);
		et.commit();
		em.close();
		entityManagerFactory.close();
		
	}

}
