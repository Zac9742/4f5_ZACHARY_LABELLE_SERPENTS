package serpents_echelles.pages.partie_locale.modeles;

import serpents_echelles.enumerations.CouleurPion;

public interface PionLectureSeule {
    CouleurPion getCouleur();

    int getPosition();

    int getNbEchelles();

    int getNbSerpents();

    int getPosPrecedente();
}
