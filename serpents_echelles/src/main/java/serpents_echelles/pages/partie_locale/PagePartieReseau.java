
package serpents_echelles.pages.partie_locale;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ntro.debogage.DoitEtre;
import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;

import static serpents_echelles.Constantes.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import serpents_echelles.client.MonClientWebSocket;
import serpents_echelles.pages.partie_locale.afficheurs.AfficheurPartieReseau;
import serpents_echelles.pages.partie_locale.controleurs.ControleurPartieReseau;
import serpents_echelles.pages.partie_locale.modeles.PartieLocale;
import serpents_echelles.pages.partie_locale.modeles.PartieReseau;
import serpents_echelles.pages.partie_locale.vues.VuePartieReseau;

public class PagePartieReseau extends Application {
	
	private String[] modelesJson = { "test1", "test2", "test3" };
	private Random alea = new Random();
	
	static {

		Initialisateur.initialiser();
		
		J.appel(PagePartieReseau.class);
	}
	
	public static void main(String[] args) {
		J.appel(PagePartieReseau.class);
		launch(args);
	}


	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		connecterAuServeur();
		
		ChargeurDeVue<VuePartieReseau> chargeur;
		chargeur = new ChargeurDeVue<VuePartieReseau>(CHEMIN_PARTIE_RESEAU_FXML);

		VuePartieReseau vue = chargeur.getVue();
		
		//PartieReseau partie = EntrepotDeModeles.creerModele(PartieReseau.class, ID_MODELE_PAR_DEFAUT);
		
		String modele = modelesJson[alea.nextInt(this.modelesJson.length)];
		System.out.println(modele);
		PartieReseau partie = EntrepotDeModeles.obtenirModele(PartieReseau.class, "test1");
		
		AfficheurPartieReseau afficheur = new AfficheurPartieReseau();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurPartieReseau.class, partie, vue, afficheur);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

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

	private void connecterAuServeur() {
		J.appel(this);

		URI uriServeur = null;
		
		try {

			uriServeur = new URI(ADRESSE_SERVEUR);

		} catch (URISyntaxException e) {
			
			Erreur.fatale("L'adresse du serveur est mal formée: " + ADRESSE_SERVEUR, e);
		}

		connecterAuServeur(uriServeur);
	}

	private void connecterAuServeur(URI uriServeur) {
		J.appel(this);

		MonClientWebSocket clientWebSocket = new MonClientWebSocket(uriServeur);
		
		Erreur.avertissement("Tentative de connexion au serveur... ");
		
		try {

			clientWebSocket.connectBlocking();

		} catch (InterruptedException e) {
			
			Erreur.nonFatale("Tentative de connexion annulée", e);
		}
	}
}
