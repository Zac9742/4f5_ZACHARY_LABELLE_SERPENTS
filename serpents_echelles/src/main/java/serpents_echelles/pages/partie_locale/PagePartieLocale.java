package serpents_echelles.pages.partie_locale;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.modeles.EntrepotDeModeles;
import javafx.stage.Stage;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import serpents_echelles.pages.partie_locale.afficheurs.AfficheurPartieLocale;
import serpents_echelles.pages.partie_locale.controleurs.ControleurPartieLocale;
import serpents_echelles.pages.partie_locale.modeles.PartieLocale;
import serpents_echelles.pages.partie_locale.vues.VuePartieLocale;

public class PagePartieLocale extends Application {
	private String[] modelesJson = { "test1", "test2", "test3" };
	private Random alea = new Random();

	static {
		Initialisateur.initialiser();

		J.appel(PagePartieLocale.class);
	}

	public static void main(String[] args) {
		J.appel(PagePartieLocale.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		J.appel(this);

		ChargeurDeVue<VuePartieLocale> chargeur;
		chargeur = new ChargeurDeVue<VuePartieLocale>(Constantes.CHEMIN_PARTIE_LOCALE_FXML);

		VuePartieLocale vue = chargeur.getVue();

		String modele = modelesJson[alea.nextInt(this.modelesJson.length)];
		System.out.println(modele);
		PartieLocale partie = EntrepotDeModeles.obtenirModele(PartieLocale.class, "test1");

		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();

		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurPartieLocale.class, partie, vue, afficheur);

		Scene scene = chargeur.nouvelleScene(Constantes.LARGEUR_PIXELS, Constantes.HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);

		fenetrePrincipale.setMinWidth(Constantes.LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(Constantes.HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}
}