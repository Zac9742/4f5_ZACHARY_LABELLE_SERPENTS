package serpents_echelles.pages.partie_locale.modeles;

import serpents_echelles.enumerations.CouleurModificateur;

public interface ModificateurLectureSeule {
    int getIndiceCaseDebut();
    int getIndiceCaseFin();
    CouleurModificateur getCouleur();
}
