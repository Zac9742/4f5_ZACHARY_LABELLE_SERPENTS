package serpents_echelles.pages.accueil;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import serpents_echelles.commandes.commencer_partie.CommencerPartie;
import serpents_echelles.commandes.commencer_partie.CommencerPartiePourEnvoi;
import serpents_echelles.commandes.ouvrir_historique.OuvrirHistorique;
import serpents_echelles.commandes.ouvrir_historique.OuvrirHistoriquePourEnvoi;
import serpents_echelles.commandes.ouvrir_parametres.OuvrirParametres;
import serpents_echelles.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import serpents_echelles.commandes.quitter.Quitter;
import serpents_echelles.commandes.quitter.QuitterPourEnvoi;

public class VueAccueil implements Vue, Initializable {

	@FXML
	private Button btnJouer, btnParametres, btnHistorique, btnQuitter;

	@FXML
	private QuitterPourEnvoi quitterPourEnvoi;

	private OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	private OuvrirHistoriquePourEnvoi ouvrirHistoriquePourEnvoi;
	private CommencerPartiePourEnvoi commencerPartiePourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		DoitEtre.nonNul(btnHistorique);
		DoitEtre.nonNul(btnQuitter);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		btnJouer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				commencerPartiePourEnvoi.envoyerCommande();
			}
		});

		btnParametres.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				ouvrirParametresPourEnvoi.envoyerCommande();
			}
		});

		btnHistorique.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				ouvrirHistoriquePourEnvoi.envoyerCommande();
			}
		});

		btnQuitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				quitterPourEnvoi.envoyerCommande();
			}
		});
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		ouvrirParametresPourEnvoi = (OuvrirParametresPourEnvoi) FabriqueCommande
				.obtenirCommandePourEnvoi(OuvrirParametres.class);
		ouvrirHistoriquePourEnvoi = (OuvrirHistoriquePourEnvoi) FabriqueCommande
				.obtenirCommandePourEnvoi(OuvrirHistorique.class);
		commencerPartiePourEnvoi = (CommencerPartiePourEnvoi) FabriqueCommande
				.obtenirCommandePourEnvoi(CommencerPartie.class);
		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);

	}
}