package main.java;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TestLivreJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		/*
		 * Livre l = em.find(Livre.class, 1); if (l != null){
		 * System.out.println(l.getId() + " " + l.getTitre() + " " +
		 * l.getAuteur()); } TypedQuery<Livre> query2 =
		 * em.createQuery("select l from Livre l where l.titre='Germinal'",
		 * Livre.class); Livre l2 = query2.getResultList().get(0);
		 * System.out.println(l2.getId() + " " + l2.getTitre() + " " +
		 * l2.getAuteur());
		 */
		Query query3 = em.createQuery("select e.livres from Emprunt e where e.id=1");
		List<Livre> result = query3.getResultList();
		for (Livre l : result) {
			System.out.println(l.getId() + " " + l.getTitre() + " " + l.getAuteur());
		}
		TypedQuery<Emprunt> query4 = em.createQuery("select e from Emprunt e where e.client=3", Emprunt.class);
		query4.getResultList().forEach(e -> System.out.println(e.getId() + " " + e.getDate_debut() + " " + e.getDate_fin()));
		em.close();
		entityManagerFactory.close();
	}

}
