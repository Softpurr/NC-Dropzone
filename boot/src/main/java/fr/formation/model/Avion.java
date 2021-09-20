package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AVION_ID")
	private int idAvion;

	@Column(name = "AVION_NOM", length = 150, nullable = false)
	private String nomAvion;
	
	@Column(name = "AVION_CAPACITE_TRANSPORT", length = 5, nullable = false)
	private int capiciteTransport;
	
	@Column(name = "AVION_ROTATION_MAX", length = 50, nullable = false)
	private int rotationMax;

    @Column(name = "AVION_DISPONIBILITE", nullable = false)
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
        return capiciteTransport;
    }

    public void setCapiciteTransport(int capiciteTransport) {
        this.capiciteTransport = capiciteTransport;
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
