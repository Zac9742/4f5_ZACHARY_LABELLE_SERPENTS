package serpents_echelles.pages.joueurGagnant;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import serpents_echelles.commandes.quitter_stats.QuitterStats;
import serpents_echelles.commandes.quitter_stats.QuitterStatsPourEnvoi;

public class VueFinPartie implements Vue, Initializable {
	// Vue = C'est la classe "Vue" de la m�thodoligie "mvc" qu'on utilise
	// Initializable = Se r�f�re � FXML

	// appeller les variables priv�es (les caracteristiques) du XML
	@FXML
	private Text txtGagnant;
	@FXML
	private Text txtPerdant;
	@FXML
	private Text txtSerpentsTouches;
	@FXML
	private Text txtEchellesTouchees;

	@FXML
	private Button boutonQuitter;

	private QuitterStatsPourEnvoi quitterPourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		DoitEtre.nonNul(boutonQuitter);

		boutonQuitter.setOnAction(new EventHandler<ActionEvent>() {
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

		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(QuitterStats.class);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);

	}

	// __________________________________________________________________________________

	public void afficherGagnant(String nomGagnant) {

		// cette ligne va changer le texte principal dans le XML pour une nouvelle
		// phrase avec le nom du gagnant dans l'affichage
		this.txtGagnant.setText("Bravo " + nomGagnant + " vous avez gagn\u00E9 !");
	}

	public void afficherPerdant(List<Joueur> joueursPerdants) {

		String txtDebutPerdant = "D\u00E9sol\u00E9, ";
		String txtFinPerdant = " vous avez perdu...";

		for (int i = 0; i < joueursPerdants.size(); i++) {

			if (i != joueursPerdants.size() - 1) {

				txtDebutPerdant += joueursPerdants.get(i).getNom() + ", ";

			} else {
				txtDebutPerdant += joueursPerdants.get(i).getNom();
			}
		}

		this.txtPerdant.setText(txtDebutPerdant + txtFinPerdant);
	}

	public void afficherSerpentsTouches(int serpentsTouches) {

		this.txtSerpentsTouches.setText("Nombre de serpent(s) touch\u00E9(s) durant la partie: " + serpentsTouches);
	}

	public void afficherEchellesTouchees(int echellesTouchees) {

		this.txtEchellesTouchees.setText("Nombre d'\u00E9chelle(s) touch\u00E9e(s) durant la partie: " + echellesTouchees);
	}

}
