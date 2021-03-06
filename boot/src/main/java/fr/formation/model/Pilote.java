package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

@Entity
@Table(name = "pilote")
public class Pilote {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PILOTE_ID")
    @JsonView(Views.Commons.class)
	private int id;

	@Column(name = "PILOTE_NOM", length = 150, nullable = false)
    @JsonView(Views.Commons.class)
	private String nomPilote;
	
	@Column(name = "PILOTE_PRENOM", length = 50, nullable = false)
    @JsonView(Views.Pilote.class)
	private String prenomPilote;
	
	@Column(name = "PILOTE_NUMERO_LICENCE", length = 50, nullable = false)
    @JsonView(Views.Pilote.class)
	private String numLicence;

	@OneToMany(mappedBy = "pilote")
	private List<Vol> vol;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

