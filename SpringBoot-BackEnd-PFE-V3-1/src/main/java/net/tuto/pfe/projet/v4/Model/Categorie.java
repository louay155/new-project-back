package net.tuto.pfe.projet.v4.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="libelle")
	private String libelle;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="cat")
	private Niveau niveau;
public Categorie() {}
public Categorie(String libelle) {
	super();
	this.libelle = libelle;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}

}
