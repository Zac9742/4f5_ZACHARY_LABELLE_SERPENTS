package serpents_echelles.pages.partie_locale.modeles;

import java.util.ArrayList;
import java.util.List;

//import ntro.debogage.J;
import serpents_echelles.enumerations.CouleurCase;

public class Grille implements GrilleLectureSeule {
    private int taille;
    private transient List<Case> listeCase = new ArrayList<>();
    private List<Echelle> echelles = new ArrayList<>();
    private List<Serpent> serpents = new ArrayList<>();

    public Grille(int taille, List<Echelle> echelles, List<Serpent> serpents) {

    }

    public void apresChargementJson(CouleurCase couleurCase1, CouleurCase couleurCase2) {
        this.initCases(couleurCase1, couleurCase2);
    }

    /**
     * Fonction qui initialise toutes les cases de la grille (objet Case).
     * 
     * @param couleurCase1 - La premiere couleur de la grille
     * @param couleurCase2 - La deuxieme couleur de la grille
     */
    private void initCases(CouleurCase couleurCase1, CouleurCase couleurCase2) {
        for (int i = 0; i < taille; i++) {
            Case caseCourante;

            if (i % 2 == 0) {
                caseCourante = new Case(couleurCase1, i);
            } else {
                caseCourante = new Case(couleurCase2, i);
            }

            this.listeCase.add(caseCourante);
        }
    }

    @Override
    public int getTaille() {
        // J.appel(this);

        return this.taille;
    }

    @Override
    public Case getCase(int position) {
        return this.listeCase.get(position);
    }

    @Override
    public List<Case> getListeCases() {
        return this.listeCase;
    }

    @Override
    public List<Serpent> getSerpents() {
        return this.serpents;
    }

    @Override
    public List<Echelle> getEchelles() {
        return this.echelles;
    }

    public void setTailleGrille(int taille) {
        this.taille = taille;
    }
}
