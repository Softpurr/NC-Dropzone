package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Enumerated(EnumType.ORDINAL)
    @Column(name = "SAUT_HAUTEUR", nullable = false)
    @JsonView(Views.Saut.class)
	private Hauteur hauteur;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "SAUT_TYPE_SAUT", nullable = false)
    @JsonView(Views.Saut.class)
	private TypeSaut typeSaut;
	
    @OneToMany(mappedBy = "saut")
	private List<Parachute> parachutes;

    @OneToMany(mappedBy = "saut")
	private List<Parachutiste> parachutistes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hauteur getHauteur() {
		return hauteur;
	}

	public void setHauteur(Hauteur hauteur) {
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

	public List<Parachutiste> getParachutiste() {
		return parachutistes;
	}

	public void setParachutiste(List<Parachutiste> parachutistes) {
		this.parachutistes = parachutistes;
	}

	
	
}
