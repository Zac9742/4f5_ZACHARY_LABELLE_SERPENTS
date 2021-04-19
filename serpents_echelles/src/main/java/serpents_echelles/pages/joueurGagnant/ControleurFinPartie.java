package serpents_echelles.pages.joueurGagnant;

import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.systeme.Systeme;
import serpents_echelles.commandes.quitter.Quitter;
import serpents_echelles.commandes.quitter.QuitterRecue;

public class ControleurFinPartie
		extends ControleurModeleVue<StatistiqueLectureSeule, Statistique, VueFinPartie, AfficheurFinPartie> {

	// je crois que je n'ai pas de class "modeleFinPartie"

	@Override
	protected void demarrer() {
		J.appel(this);

	}

	private void quitter() {
		J.appel(this);

		Systeme.quitter();
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);

				quitter();
			}
		});

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
