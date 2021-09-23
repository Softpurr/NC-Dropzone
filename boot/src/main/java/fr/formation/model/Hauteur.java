package fr.formation.model;

public enum Hauteur {
    _1200(1200), _1600(1600), _2000(2000), _2500(2500), _4000(4000), _6000(6000);

    private int h;

    Hauteur(int h) {
        this.h = h;
    }

    public int getInt() {
        return h;
    }
}
