package serpents_echelles.pages.joueurGagnant;

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

public class PageFinPartie extends Application {

	static {

		Initialisateur.initialiser();

		J.appel(PageFinPartie.class);
	}

	private Random alea = new Random();

	public static void main(String[] args) {
		J.appel(PageFinPartie.class);
		launch(args);
	}

	/*
	 * @Override public void start(Stage fenetrePrincipale) throws Exception {
	 * J.appel(this);
	 * 
	 * String idModeleTest = modeles[alea.nextInt(modeles.length)]; Statistique
	 * statistique = EntrepotDeModeles.obtenirModele(Statistique.class,
	 * idModeleTest);
	 * 
	 * //J.valeurs(parametres.getId(), parametres.getQuiCommence().name(),
	 * parametres.getTailleGrille());
	 * 
	 * 
	 * for (int i = 0; i < statistique.getStatistiquesJoueurs().size(); i++) {
	 * System.out.println("\n-------------------Joueur-------------------");
	 * J.valeurs(statistique.getStatistiquesJoueurs().get(i).getNbPartieGagnees());
	 * J.valeurs(statistique.getStatistiquesJoueurs().get(i).getNbPartiePerdues());
	 * J.valeurs(statistique.getStatistiquesJoueurs().get(i).getNbSerpentsTouches())
	 * ;
	 * J.valeurs(statistique.getStatistiquesJoueurs().get(i).getNbEchellesTouchees()
	 * ); } Systeme.quitter(); }
	 */

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		ChargeurDeVue<VueFinPartie> chargeur;
		chargeur = new ChargeurDeVue<VueFinPartie>(Constantes.CHEMIN_FINPARTIE_FXML);

		VueFinPartie vue = chargeur.getVue();

		String idModeleTest = Constantes.IDS_MODELES_TESTS[alea.nextInt(Constantes.IDS_MODELES_TESTS.length)];
		Statistique statistique = EntrepotDeModeles.obtenirModele(Statistique.class, idModeleTest);

		AfficheurFinPartie afficheurFinPartie = new AfficheurFinPartie();

		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurFinPartie.class, statistique, vue, afficheurFinPartie);

		Scene scene = chargeur.nouvelleScene(Constantes.LARGEUR_PIXELS, Constantes.HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);

		fenetrePrincipale.setMinWidth(Constantes.LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(Constantes.HAUTEUR_PIXELS);

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
