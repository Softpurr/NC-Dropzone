package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vol")
public class Vol {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOL_ID")
	private int idVol;

	@Column(name = "VOL_NOMBRE_SAUT", nullable = false)
	private int nombreSaut;
	
	@Column(name = "VOL_AVION", nullable = false)
	private int capiciteTransport;
	
	@Column(name = "VOL_PILOTE", nullable = false)
	private Pilote pilote;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "AVION_ETAT", nullable = false)
	private Etat etat;

    @Column(name = "VOL_RESPONSABLE", nullable = false)
	private Parachutiste responsable;

	public int getIdVol() {
		return idVol;
	}

	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}

	public int getNombreSaut() {
		return nombreSaut;
	}

	public void setNombreSaut(int nombreSaut) {
		this.nombreSaut = nombreSaut;
	}

	public int getCapiciteTransport() {
		return capiciteTransport;
	}

	public void setCapiciteTransport(int capiciteTransport) {
		this.capiciteTransport = capiciteTransport;
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
