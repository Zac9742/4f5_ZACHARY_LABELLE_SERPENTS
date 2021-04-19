package serpents_echelles.pages.partie_locale.modeles;

import serpents_echelles.enumerations.CouleurCase;
import ntro.debogage.J;

public class Case implements CaseLectureSeule {
    private CouleurCase couleur;
    private int indice;

    public Case(CouleurCase couleur, int indice) {
        this.couleur = couleur;
        this.indice = indice;
    }

    @Override
    public CouleurCase getCouleur() {
        J.appel(this);

        return this.couleur;
    }

    @Override
    public int getIndice() {
        J.appel(this);

        return this.indice;
    }

    public void setCouleur(CouleurCase couleur) {
        J.appel(this);

        this.couleur = couleur;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
