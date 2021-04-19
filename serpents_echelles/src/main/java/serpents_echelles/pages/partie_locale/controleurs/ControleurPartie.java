package serpents_echelles.pages.partie_locale.controleurs;

import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import serpents_echelles.commandes.brasser_de.BrasserDe;
import serpents_echelles.commandes.brasser_de.BrasserDeRecu;
import serpents_echelles.pages.partie_locale.afficheurs.AfficheurPartie;
import serpents_echelles.pages.partie_locale.modeles.Partie;
import serpents_echelles.pages.partie_locale.modeles.PartieLectureSeule;
import serpents_echelles.pages.partie_locale.vues.VuePartie;

public class ControleurPartie<PLS extends PartieLectureSeule, P extends Partie<PLS>, V extends VuePartie, A extends AfficheurPartie<PLS, V>>
		extends ControleurModeleVue<PLS, P, V, A> {
	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);

	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);

		installerRecepteurCommande(BrasserDe.class, new RecepteurCommandeMVC<BrasserDeRecu>() {

			@Override
			public void executerCommandeMVC(BrasserDeRecu commande) {
				J.appel(this);

				reagirCommandeBrasserDe(commande);
			}

		});
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
	}

	protected void reagirCommandeBrasserDe(BrasserDeRecu brasserDeRecue) {
		J.appel(this);

		getModele().effectuerCoup(brasserDeRecue.getNombre());
	}
}
