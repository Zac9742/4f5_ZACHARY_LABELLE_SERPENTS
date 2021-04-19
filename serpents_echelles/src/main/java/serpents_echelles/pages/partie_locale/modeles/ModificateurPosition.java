package serpents_echelles.pages.partie_locale.modeles;

import serpents_echelles.enumerations.CouleurModificateur;

// Parent de l'objet echelle et serpent. J'ai cree ce parent car les echelles et serpents ont des caracteristiques tres semblables.
public class ModificateurPosition implements ModificateurLectureSeule {
    private int indiceCaseDebut;
    private int indiceCaseFin;
    private CouleurModificateur couleur;

    public ModificateurPosition(int posDebut, int posFin, CouleurModificateur couleur) {
        this.indiceCaseDebut = posDebut;
        this.indiceCaseFin = posFin;
        this.couleur = couleur;
    }

    @Override
    public int getIndiceCaseDebut() {
        // J.appel(this);

        return this.indiceCaseDebut;
    }

    @Override
    public int getIndiceCaseFin() {
        // J.appel(this);

        return this.indiceCaseFin;
    }

    @Override
    public CouleurModificateur getCouleur() {
        // J.appel(this);

        return this.couleur;
    }

    public void setCaseDebut(int caseDebut) {
        // J.appel(this);

        this.indiceCaseDebut = caseDebut;
    }

    public void setCaseFin(int caseFin) {
        // J.appel(this);

        this.indiceCaseFin = caseFin;
    }

    public void setCouleur(CouleurModificateur couleur) {
        // J.appel(this);

        this.couleur = couleur;
    }
}
