package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

@Entity
@Table(name = "saut")
public class Saut {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SAUT_ID")
    @JsonView(Views.Commons.class)
	private int id;

    @Column(name = "SAUT_HAUTEUR", nullable = false)
    @JsonView(Views.Saut.class)
	private int hauteur;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "SAUT_TYPE_SAUT", nullable = false)
    @JsonView(Views.Saut.class)
	private TypeSaut typeSaut;
	
	@OneToMany(mappedBy = "saut")
	@JsonView(Views.Saut.class)
	private List<Parachutiste> parachutistes;

    @OneToMany(mappedBy = "saut")
	@JsonView(Views.Saut.class)
	private List<Parachute> parachutes;

	@ManyToOne
	@JoinColumn(name = "SAUT_VOL_ID")
	@JsonView(Views.Saut.class)
	private Vol vol;

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public TypeSaut getTypeSaut() {
		return typeSaut;
	}

	public void setTypeSaut(TypeSaut typeSaut) {
		this.typeSaut = typeSaut;
	}

	public List<Parachute> getParachutes() {
		return parachutes;
	}

	public void setParachutes(List<Parachute> parachutes) {
		this.parachutes = parachutes;
	}

	public List<Parachutiste> getParachutistes() {
		return parachutistes;
	}

	public void setParachutistes(List<Parachutiste> parachutistes) {
		this.parachutistes = parachutistes;
	}
	
}
