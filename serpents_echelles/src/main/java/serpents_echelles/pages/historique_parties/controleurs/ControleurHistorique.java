package serpents_echelles.pages.historique_parties.controleurs;

import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import serpents_echelles.pages.historique_parties.Historique;
import serpents_echelles.pages.historique_parties.HistoriqueLectureSeule;
import serpents_echelles.pages.historique_parties.afficheurs.AfficheurHistorique;
import serpents_echelles.pages.historique_parties.vues.VueHistorique;

public class ControleurHistorique extends ControleurModeleVue<HistoriqueLectureSeule, Historique, VueHistorique, AfficheurHistorique>{

	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}
}