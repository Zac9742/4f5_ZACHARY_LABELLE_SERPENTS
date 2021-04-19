package serpents_echelles.pages.historique_parties;

import java.util.List;

import ntro.mvc.modeles.Modele;

public class Historique extends Modele<HistoriqueLectureSeule> implements HistoriqueLectureSeule {

	 private int nbPartieArchive;
	 private List<PartieArchive> partieArchive;

	@Override
	public int getnbPartieArchive() {
		return this.nbPartieArchive;
	}

	@Override
	public List<PartieArchive> getpartieArchive() {
		return this.partieArchive;
	}

	@Override
	public void apresChargementJson() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apresCreation() {
		// TODO Auto-generated method stub
		
	}
}