package serpents_echelles.pages.historique_parties.afficheurs;

import ntro.debogage.J;
import ntro.mvc.Afficheur;
import serpents_echelles.pages.historique_parties.HistoriqueLectureSeule;
import serpents_echelles.pages.historique_parties.vues.VueHistorique;

public class AfficheurHistorique extends Afficheur<HistoriqueLectureSeule, VueHistorique>{

	@Override
	public void initialiserAffichage(HistoriqueLectureSeule modeleLectureSeule, VueHistorique vue) {
		J.appel(this);
	}

	@Override
	public void rafraichirAffichage(HistoriqueLectureSeule modeleLectureSeule, VueHistorique vue) {
		J.appel(this);
		
		for (int i = 0; i < modeleLectureSeule.getpartieArchive().size(); i++) {
			vue.creerLigne(modeleLectureSeule.getpartieArchive().get(i).getCouleur(), 
					modeleLectureSeule.getpartieArchive().get(i).getNomGagnant(), 
					modeleLectureSeule.getpartieArchive().get(i).getDureePartie(),
					modeleLectureSeule.getpartieArchive().get(i).getNbCoups());
		}
	}
}