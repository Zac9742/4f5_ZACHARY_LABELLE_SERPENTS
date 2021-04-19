package serpents_echelles.pages.historique_parties;

import serpents_echelles.enumerations.CouleurPartie;

public class PartieArchive implements PartieArchiveLectureSeule {

	private int id;
	private String nomGagnant;
	private CouleurPartie couleur;
	private int dureePartie;
	private int nbCoups;

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getNomGagnant() {
		return this.nomGagnant;
	}

	@Override
	public CouleurPartie getCouleur() {
		return this.couleur;
	}

	@Override
	public int getDureePartie() {
		return this.dureePartie;
	}

	@Override
	public int getNbCoups() {
		return this.nbCoups;
	}
}