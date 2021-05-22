package net.tuto.pfe.projet.v4.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="seance")
public class Seance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="date_sce")
	private Date date_sce;
	@Column(name="heure_deb")
	private Date heure_deb;
	@Column(name="heure_fin")
	private Date heure_fin;
	@Column(name="salle")
	private String Salle;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="mat_id")
	private Matiere matiere;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="prof_id")
	private Professeur prof;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="sce_fid", referencedColumnName="id")
	List<Eleve> leleve = new ArrayList<>();
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="seance_as",
	joinColumns= { @JoinColumn(name="sce_id")},
			inverseJoinColumns= {@JoinColumn(name="as_id")})
	private Set<AnneeScolaire> as = new HashSet<>();
	public Seance() {}
	public Seance(Date date_sce, Date heure_deb, Date heure_fin, String salle) {
		super();
		this.date_sce = date_sce;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
		Salle = salle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate_sce() {
		return date_sce;
	}
	public void setDate_sce(Date date_sce) {
		this.date_sce = date_sce;
	}
	public Date getHeure_deb() {
		return heure_deb;
	}
	public void setHeure_deb(Date heure_deb) {
		this.heure_deb = heure_deb;
	}
	public Date getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}
	public String getSalle() {
		return Salle;
	}
	public void setSalle(String salle) {
		Salle = salle;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Professeur getProf() {
		return prof;
	}
	public void setProf(Professeur prof) {
		this.prof = prof;
	}
	public List<Eleve> getLeleve() {
		return leleve;
	}
	public void setLeleve(List<Eleve> leleve) {
		this.leleve = leleve;
	}
	public Set<AnneeScolaire> getAs() {
		return as;
	}
	public void setAs(Set<AnneeScolaire> as) {
		this.as = as;
	}
	

}
