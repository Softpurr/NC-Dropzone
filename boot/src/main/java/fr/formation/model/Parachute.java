package fr.formation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

@Entity
@Table(name = "parachute")
public class Parachute {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARACHUTE_ID")
    @JsonView(Views.Commons.class)
	private int idAvion;

	@Column(name = "PARACHUTE_NOM_HARNAIS", length = 150, nullable = false)
    @JsonView(Views.Parachute.class)
	private String nomHarnais;
	
	@Column(name = "PARACHUTE_NOM_VOILE_PRINCIPALE", length = 50, nullable = false)
    @JsonView(Views.Parachute.class)
	private String nomVoilePrincipale;
	
	@Column(name = "PARACHUTE_NOM_VOILE_SECOURS", length = 50, nullable = false)
    @JsonView(Views.Parachute.class)
	private String nomVoileSecours;

    @Column(name = "PARACHUTE_TAILLE_VOILE_PRINCIPALE", nullable = false)
    @JsonView(Views.Parachute.class)
	private BigDecimal tailleVoilePrincipale;
	
	@Column(name = "PARACHUTE_TAILLE_VOILE_SECOURS", nullable = false)
    @JsonView(Views.Parachute.class)
	private BigDecimal tailleVoileSecours;

    @Column(name = "PARACHUTE_DATE_PLIAGE_VOILE_SECOURS", nullable = false)
    @JsonView(Views.Parachute.class)
	private LocalDate datePliageVoileSecours;

    @Column(name = "PARACHUTE_SECURITE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @JsonView(Views.Parachute.class)
	private Securite securite;

    @Column(name = "PARACHUTE_PERSO", nullable = false)
    @JsonView(Views.Parachute.class)
	private boolean isPerso;

    @Column(name = "PARACHUTE_DISPONIBILITE", nullable = false)
    @JsonView(Views.Parachute.class)
	private boolean isDispo;

	@ManyToOne
	@JoinColumn(name = "PARACHUTE_PARACHUTISTE_ID")
	private Parachutiste parachutiste;

	@ManyToOne
	@JoinColumn(name = "PARACHUTE_SAUT_ID")
	private Saut saut;

	public int getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}

	public String getNomHarnais() {
		return nomHarnais;
	}

	public void setNomHarnais(String nomHarnais) {
		this.nomHarnais = nomHarnais;
	}

	public String getNomVoilePrincipale() {
		return nomVoilePrincipale;
	}

	public void setNomVoilePrincipale(String nomVoilePrincipale) {
		this.nomVoilePrincipale = nomVoilePrincipale;
	}

	public String getNomVoileSecours() {
		return nomVoileSecours;
	}

	public void setNomVoileSecours(String nomVoileSecours) {
		this.nomVoileSecours = nomVoileSecours;
	}

	public BigDecimal getTailleVoilePrincipale() {
		return tailleVoilePrincipale;
	}

	public void setTailleVoilePrincipale(BigDecimal tailleVoilePrincipale) {
		this.tailleVoilePrincipale = tailleVoilePrincipale;
	}

	public BigDecimal getTailleVoileSecours() {
		return tailleVoileSecours;
	}

	public void setTailleVoileSecours(BigDecimal tailleVoileSecours) {
		this.tailleVoileSecours = tailleVoileSecours;
	}

	public LocalDate getDatePliageVoileSecours() {
		return datePliageVoileSecours;
	}

	public void setDatePliageVoileSecours(LocalDate datePliageVoileSecours) {
		this.datePliageVoileSecours = datePliageVoileSecours;
	}

	public Securite getSecurite() {
		return securite;
	}

	public void setSecurite(Securite securite) {
		this.securite = securite;
	}

	public boolean isPerso() {
		return isPerso;
	}

	public void setPerso(boolean isPerso) {
		this.isPerso = isPerso;
	}

	public boolean isDispo() {
		return isDispo;
	}

	public void setDispo(boolean isDispo) {
		this.isDispo = isDispo;
	}

	public Parachutiste getParachutiste() {
		return parachutiste;
	}

	public void setParachutiste(Parachutiste parachutiste) {
		this.parachutiste = parachutiste;
	}

	public Saut getSaut() {
		return saut;
	}

	public void setSaut(Saut saut) {
		this.saut = saut;
	}
    
	

}
