package serpents_echelles.pages.historique_parties;

import serpents_echelles.enumerations.CouleurPartie;

public interface PartieArchiveLectureSeule {

	int getId();

	String getNomGagnant();

	CouleurPartie getCouleur();

	int getDureePartie();

	int getNbCoups();
}