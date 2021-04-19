package serpents_echelles.pages.parametres;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;

import static serpents_echelles.pages.parametres.Constantes.*;

public class PageParametres extends Application {

	static {

		Initialisateur.initialiser();

		J.appel(PageParametres.class);
	}

	public static void main(String[] args) {
		J.appel(PageParametres.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		ChargeurDeVue<VueParametres> chargeur;
		chargeur = new ChargeurDeVue<VueParametres>(CHEMIN_PARAMETRES_FXML, "/parametres/style/style.css");

		VueParametres vue = chargeur.getVue();

		// String idModeleTest =
		// IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		Parametres parametres = EntrepotDeModeles.creerModele(Parametres.class, ID_MODELE_PAR_DEFAUT);

		AfficheurParametres afficheurParametres = new AfficheurParametres();

		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurParametres.class, parametres, vue, afficheurParametres);

		Scene scene = chargeur.nouvelleScene(Constantes.LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);

		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		capterEvenementFermeture(fenetrePrincipale);

		fenetrePrincipale.show();
	}

	private void capterEvenementFermeture(Stage fenetrePrincipale) {
		J.appel(this);

		fenetrePrincipale.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				J.appel(this);

				Systeme.quitter();
			}
		});
	}
}
