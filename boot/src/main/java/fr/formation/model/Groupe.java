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
@Table(name="groupe")
public class Groupe {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GROUPE_ID")
    @JsonView(Views.Commons.class)
	private int id;

	@Enumerated(EnumType.ORDINAL)
    @Column(name = "GROUPE_HAUTEUR", nullable = false)
    @JsonView(Views.Saut.class)
	private Hauteur hauteur;
	
    @OneToMany(mappedBy = "groupe")
	private List<Parachutiste> parachutistes;
    
    @ManyToOne
    @JoinColumn(name = "SAUT_ID")
	private Saut saut;

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

    public List<Parachutiste> getParachutistes() {
        return parachutistes;
    }

    public void setParachutistes(List<Parachutiste> parachutistes) {
        this.parachutistes = parachutistes;
    }

    public Saut getSaut() {
        return saut;
    }

    public void setSaut(Saut saut) {
        this.saut = saut;
    }

    
}
