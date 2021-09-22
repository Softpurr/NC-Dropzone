package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

@Entity
@Table(name = "vol")
public class Vol {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOL_ID")
    @JsonView(Views.Commons.class)
	private int id;

	@Column(name = "VOL_NOMBRE_SAUT", nullable = false)
    @JsonView(Views.Vol.class)
	private int nombreSaut;
	
	@ManyToOne
	@JoinColumn(name = "VOL_AVION_ID", nullable = false)
    @JsonView(Views.Vol.class)
	private Avion avion;
	
    @JsonView(Views.Vol.class)
	@ManyToOne
	@JoinColumn(name = "VOL_PILOTE_ID", nullable = false)
	private Pilote pilote;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "VOL_ETAT", nullable = false)
    @JsonView(Views.Vol.class)
	private Etat etat;

	@ManyToOne
	@JoinColumn(name = "VOL_RESPONSABLE_ID")
	@JsonView(Views.Vol.class)
	private Parachutiste responsable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombreSaut() {
		return nombreSaut;
	}

	public void setNombreSaut(int nombreSaut) {
		this.nombreSaut = nombreSaut;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Parachutiste getResponsable() {
		return responsable;
	}

	public void setResponsable(Parachutiste responsable) {
		this.responsable = responsable;
	}	

}
