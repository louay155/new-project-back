package net.tuto.pfe.projet.v4.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="libelle")
	private String libelle;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="matiere")
	private Seance seance;
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="matiere_nivs",
	joinColumns= { @JoinColumn(name="mat_id")},
			inverseJoinColumns= {@JoinColumn(name="niv_id")})
	private Set<Niveau> niv = new HashSet<>();
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="matiere_offre",
	joinColumns= { @JoinColumn(name="mat_id")},
			inverseJoinColumns= {@JoinColumn(name="offre_id")})
	private Set<Offre> offre  = new HashSet<>();
	
	public Matiere() {}
	public Matiere(String libelle) {
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
