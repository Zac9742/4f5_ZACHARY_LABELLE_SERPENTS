package serpents_echelles.pages.historique_parties;

import java.util.Random;
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
import serpents_echelles.pages.historique_parties.afficheurs.AfficheurHistorique;
import serpents_echelles.pages.historique_parties.controleurs.ControleurHistorique;
import serpents_echelles.pages.historique_parties.vues.VueHistorique;

import static serpents_echelles.pages.historique_parties.Constantes.*;

public class PageHistoriqueParties extends Application {

	static {

		Initialisateur.initialiser();

		J.appel(PageHistoriqueParties.class);
	}

	private Random alea = new Random();

	public static void main(String[] args) {
		J.appel(PageHistoriqueParties.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		// Interface

		ChargeurDeVue<VueHistorique> chargeur;
		chargeur = new ChargeurDeVue<VueHistorique>(CHEMIN_HISTORIQUE_FXML);

		VueHistorique vue = chargeur.getVue();

		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		Historique historique = EntrepotDeModeles.obtenirModele(Historique.class, idModeleTest);

		AfficheurHistorique afficheurHistorique = new AfficheurHistorique();

		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurHistorique.class, historique, vue, afficheurHistorique);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);

		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		capterEvenementFermeture(fenetrePrincipale);

		fenetrePrincipale.show();

		// Console

		System.out.println("Nom du test JSon: " + idModeleTest);
		System.out.print("Nombre de parties : ");
		J.valeurs(historique.getnbPartieArchive());
		for (int i = 0; i < historique.getpartieArchive().size(); i++) {
			System.out.print("ID du joueur : ");
			J.valeurs(historique.getpartieArchive().get(i).getId());
			System.out.print("Nom du joueur : ");
			J.valeurs(historique.getpartieArchive().get(i).getNomGagnant());
			System.out.print("Couleur du joueur : ");
			J.valeurs(historique.getpartieArchive().get(i).getCouleur().name());
			System.out.print("Nombre de coups : ");
			J.valeurs(historique.getpartieArchive().get(i).getNbCoups());
			System.out.print("Dur�e de la partie : ");
			J.valeurs(historique.getpartieArchive().get(i).getDureePartie());
		}
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