package banque.entite;

import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
		AssuranceVie aV = new AssuranceVie();
		aV.setNumero("654321");
		aV.setSolde(5000.0);
		aV.setClients(lCli);
		aV.setDateFin(LocalDate.of(2050, 12, 30));
		em.persist(b);
		em.persist(c);
		em.persist(lA);
		em.persist(aV);
		Operation op = new Operation();
		op.setDate(LocalDateTime.of(2005, 4, 10, 11, 30));
		op.setMontant(-500);
		op.setMotif("Versement");
		op.setCompte(lA);
		Virement v = new Virement();
		v.setDate(LocalDateTime.of(2002, 3, 7, 15, 30));
		v.setMontant(1000);
		v.setMotif("Ouverture assurance vie");
		v.setCompte(aV);
		v.setBeneficiaire("Dupond");
		em.persist(op);
		em.persist(v);
		et.commit();
		em.close();
		entityManagerFactory.close();
		
	}

}
