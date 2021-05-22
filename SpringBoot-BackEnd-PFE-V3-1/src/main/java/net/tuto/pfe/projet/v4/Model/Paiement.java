package net.tuto.pfe.projet.v4.Model;

import java.util.Date;
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
import javax.persistence.Table;

@Entity
@Table(name="paiement")
public class Paiement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="montant")
	private float montant;
	@Column(name="Date_pai")
	private Date date_pai;
	
	public Paiement() {}
	public Paiement(float montant, Date date_pai) {
		super();
		this.montant = montant;
		this.date_pai = date_pai;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public Date getDate_pai() {
		return date_pai;
	}
	public void setDate_pai(Date date_pai) {
		this.date_pai = date_pai;
	}
	
}
