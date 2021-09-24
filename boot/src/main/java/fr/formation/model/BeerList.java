package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


import fr.formation.api.Views;

@Entity
@Table(name= "beerlist")
public class BeerList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BEERLIST_ID")
    @JsonView(Views.Commons.class)
	private int id;

    @ManyToOne
    @JoinColumn(name="BEER_LIST_PARACHUTISTE")
    @JsonView(Views.BeerList.class)
    private Parachutiste parachutiste;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parachutiste getParachutiste() {
        return parachutiste;
    }

    public void setParachutiste(Parachutiste parachutiste) {
        this.parachutiste = parachutiste;
    }


}
