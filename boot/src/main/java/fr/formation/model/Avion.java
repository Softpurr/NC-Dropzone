package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

@Entity
@Table(name = "avion")
public class Avion {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AVION_ID")
    @JsonView(Views.Commons.class)
	private int idAvion;

	@Column(name = "AVION_NOM", length = 150, nullable = false)
    @JsonView(Views.Avion.class)
	private String nomAvion;
	
	@Column(name = "AVION_CAPACITE_TRANSPORT", length = 5, nullable = false)
    @JsonView(Views.Avion.class)
	private int capaciteTransport;
	
	@Column(name = "AVION_ROTATION_MAX", length = 50, nullable = false)
    @JsonView(Views.Avion.class)
	private int rotationMax;

    @Column(name = "AVION_DISPONIBILITE", nullable = false)
    @JsonView(Views.Avion.class)
	private boolean isDispo;

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getNomAvion() {
        return nomAvion;
    }

    public void setNomAvion(String nomAvion) {
        this.nomAvion = nomAvion;
    }

    public int getCapiciteTransport() {
        return capaciteTransport;
    }

    public void setCapiciteTransport(int capiciteTransport) {
        this.capaciteTransport = capiciteTransport;
    }

    public int getRotationMax() {
        return rotationMax;
    }

    public void setRotationMax(int rotationMax) {
        this.rotationMax = rotationMax;
    }

    public boolean isDispo() {
        return isDispo;
    }

    public void setDispo(boolean isDispo) {
        this.isDispo = isDispo;
    }
    
}
