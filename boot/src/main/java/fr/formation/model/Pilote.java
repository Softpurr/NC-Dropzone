package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pilote")
public class Pilote {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PILOTE_ID")
	private int idParachutiste;

	@Column(name = "PILOTE_NOM", length = 150, nullable = false)
	private String nomPilote;
	
	@Column(name = "PILOTE_PRENOM", length = 50, nullable = false)
	private String prenomPilote;
	
	@Column(name = "PILOTE_NUMERO_LICENCE", length = 50, nullable = false)
	private String numLicence;

	public int getIdParachutiste() {
		return idParachutiste;
	}

	public void setIdParachutiste(int idParachutiste) {
		this.idParachutiste = idParachutiste;
	}

	public String getNomPilote() {
		return nomPilote;
	}

	public void setNomPilote(String nomPilote) {
		this.nomPilote = nomPilote;
	}

	public String getPrenomPilote() {
		return prenomPilote;
	}

	public void setPrenomPilote(String prenomPilote) {
		this.prenomPilote = prenomPilote;
	}

	public String getNumLicence() {
		return numLicence;
	}

	public void setNumLicence(String numLicence) {
		this.numLicence = numLicence;
	}

	
}

