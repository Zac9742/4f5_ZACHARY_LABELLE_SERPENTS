package serpents_echelles.pages.partie_locale.modeles;

import serpents_echelles.enumerations.CouleurPion;

public class Pion implements PionLectureSeule {
    private CouleurPion couleur;
    private transient int posPrecedente;
    private int position;
    private int nbEchelles;
    private int nbSerpents;

    public Pion(CouleurPion couleur, int posPrec, int position, int nbEchelles, int nbSerpents) {
        this.couleur = couleur;
        this.posPrecedente = posPrec;
        this.position = position;
        this.nbEchelles = nbEchelles;
        this.nbSerpents = nbSerpents;
    }

    @Override
    public CouleurPion getCouleur() {
        return this.couleur;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    @Override
    public int getNbEchelles() {
        return this.nbEchelles;
    }

    @Override
    public int getNbSerpents() {
        return this.nbSerpents;
    }

    @Override
    public int getPosPrecedente() {
        return this.posPrecedente;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPosPrecedente(int position) {
        this.posPrecedente = position;
    }

    public void setNbSerpents(int nb) {
        this.nbSerpents = nb;
    }

    public void setNbEchelles(int nb) {
        this.nbEchelles = nb;
    }

}
