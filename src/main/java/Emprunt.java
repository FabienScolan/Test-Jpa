package main.java;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "DATE_DEBUT", nullable = false)
	private LocalDate dateDebut;
	@Column(name = "DATE_FIN", nullable = true)
	private LocalDate dateFin;

	@ManyToOne
	@JoinColumn(name = "ID_Client")
	private Client client;

	@ManyToMany
	@JoinTable(name = "compo",

			joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName =

			"ID"),

			inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;

	public Emprunt() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate_debut() {
		return dateDebut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.dateDebut = date_debut;
	}

	public LocalDate getDate_fin() {
		return dateFin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.dateFin = date_fin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

}
