package fr.formation.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

@Entity
@Table(name = "parachutiste")
public class Parachutiste {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARACHUTISTE_ID")
    @JsonView(Views.Commons.class)
	private int id;

	@Column(name = "PARACHUTISTE_NOM", length = 150, nullable = false)
    @JsonView(Views.Commons.class)
	private String nomParachutiste;
	
	@Column(name = "PARACHUTISTE_PRENOM", length = 50, nullable = false)
    @JsonView(Views.Parachutiste.class)
	private String prenomParachutiste;
	
	@Column(name = "PARACHUTISTE_NUMERO_LICENCE", length = 50 )
    @JsonView(Views.Parachutiste.class)
	private String numLicence;

    @Column(name = "PARACHUTISTE_DATE_LICENCE")
    @JsonView(Views.Parachutiste.class)
	private LocalDate dateLicence;
	
	@Column(name = "PARACHUTISTE_SAUT", nullable = false)
    @JsonView(Views.Parachutiste.class)
	private boolean isSaut;

    @Column(name = "PARACHUTISTE_PRATIQUANT", nullable = false)
    @JsonView(Views.Parachutiste.class)
	private boolean isPratiquant;

    @Column(name = "PARACHUTISTE_CONFIRME", nullable = false)
    @JsonView(Views.Parachutiste.class)
	private boolean isConfirme;

	@OneToMany(mappedBy = "parachutiste")
	private List<Parachute> parachutes;

	@ManyToOne
	@JoinColumn(name = "SAUT_ID")
	private Saut saut;

	@OneToMany(mappedBy = "responsable")
	private List<Vol> vol;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomParachutiste() {
		return nomParachutiste;
	}

	public void setNomParachutiste(String nomParachutiste) {
		this.nomParachutiste = nomParachutiste;
	}

	public String getPrenomParachutiste() {
		return prenomParachutiste;
	}

	public void setPrenomParachutiste(String prenomParachutiste) {
		this.prenomParachutiste = prenomParachutiste;
	}

	public String getNumLicence() {
		return numLicence;
	}

	public void setNumLicence(String numLicence) {
		this.numLicence = numLicence;
	}

	public LocalDate getDateLicence() {
		return dateLicence;
	}

	public void setDateLicence(LocalDate dateLicence) {
		this.dateLicence = dateLicence;
	}

	public boolean isSaut() {
		return isSaut;
	}

	public void setSaut(boolean isSaut) {
		this.isSaut = isSaut;
	}

	public boolean isPratiquant() {
		return isPratiquant;
	}

	public void setPratiquant(boolean isPratiquant) {
		this.isPratiquant = isPratiquant;
	}

	public boolean isConfirme() {
		return isConfirme;
	}

	public void setConfirme(boolean isConfirme) {
		this.isConfirme = isConfirme;
	}

	public List<Parachute> getParachutes() {
		return parachutes;
	}

	public void setParachutes(List<Parachute> parachutes) {
		this.parachutes = parachutes;
	}

	public Saut getSaut() {
		return saut;
	}

	public void setSaut(Saut saut) {
		this.saut = saut;
	}

	public List<Vol> getVol() {
		return vol;
	}

	public void setVol(List<Vol> vol) {
		this.vol = vol;
	}
}

