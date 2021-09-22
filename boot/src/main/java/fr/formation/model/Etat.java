package fr.formation.model;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

@JsonView(Views.Etat.class)
public enum Etat {
    ATTENTE, PREPARATION, EMBARQUEMENT, VOL, TERMINE, INCIDENCE;
}
