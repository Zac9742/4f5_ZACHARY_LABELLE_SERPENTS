
package serpents_echelles.pages.parametres;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import serpents_echelles.enumerations.Couleur;
import serpents_echelles.commandes.choisir_nbr_joueur.ChoisirNbrJoueur;
import serpents_echelles.commandes.choisir_nbr_joueur.ChoisirNbrJoueurPourEnvoi;
import serpents_echelles.commandes.choisir_qui_commence.ChoisirQuiCommence;
import serpents_echelles.commandes.choisir_qui_commence.ChoisirQuiCommencePourEnvoi;
import serpents_echelles.commandes.choisir_taille_grille.ChoisirTailleGrille;
import serpents_echelles.commandes.choisir_taille_grille.ChoisirTailleGrillePourEnvoi;
import serpents_echelles.commandes.confirmer_parametres.ConfirmerParametres;
import serpents_echelles.commandes.confirmer_parametres.ConfirmerParametresPourEnvoi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import static serpents_echelles.pages.parametres.Constantes.*;

public class VueParametres implements Vue, Initializable {

	private ChoisirQuiCommencePourEnvoi choisirQuiCommence;
	private ChoisirTailleGrillePourEnvoi choisirTailleGrille;
	private ChoisirNbrJoueurPourEnvoi choisirNbrJoueur;
	private ConfirmerParametresPourEnvoi confirmerParametres;

	@FXML
	private Button caseBleu, caseVert, caseJaune, caseRouge, btnOk;

	@FXML
	private CheckBox checkBleu, checkVert, checkJaune, checkRouge;

	@FXML
	private ComboBox<Integer> choixTaille, nombreJoueur;

	// @FXML
	// private ComboBox<String> choixCouleurJ1, choixCouleurJ2, choixCouleurJ3,
	// choixCouleurJ4;

	// pour les traductions
	// private Map<String, TailleGrille> tailleSelonNom = new HashMap<>();
	// private Map<TailleGrille, String> nomSelonTaille = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		DoitEtre.nonNul(caseBleu);
		DoitEtre.nonNul(caseVert);
		DoitEtre.nonNul(caseJaune);
		DoitEtre.nonNul(caseRouge);

		DoitEtre.nonNul(checkBleu);
		DoitEtre.nonNul(checkVert);
		DoitEtre.nonNul(checkJaune);
		DoitEtre.nonNul(checkRouge);

		DoitEtre.nonNul(choixTaille);
		DoitEtre.nonNul(nombreJoueur);

		caseBleu.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		caseVert.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		caseRouge.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		caseJaune.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));

		initialiserChoixTaille(resources);
		initialiserNombreJoueur(resources);
	}

	private void initialiserChoixTaille(ResourceBundle resources) {
		J.appel(this);

		choixTaille.getItems().add(CASE_TOTALE_GRILLE_PETITE);
		choixTaille.getItems().add(CASE_TOTALE_GRILLE_MOYENNE);
		choixTaille.getItems().add(CASE_TOTALE_GRILLE_GRANDE);

		choixTaille.getSelectionModel().clearAndSelect(0);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);

		choisirQuiCommence = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirQuiCommence.class);
		choisirTailleGrille = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirTailleGrille.class);
		choisirNbrJoueur = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirNbrJoueur.class);
		confirmerParametres = FabriqueCommande.obtenirCommandePourEnvoi(ConfirmerParametres.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		checkRouge.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setCouleur(Couleur.ROUGE);
				choisirQuiCommence.envoyerCommande();
			}
		});

		checkJaune.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setCouleur(Couleur.JAUNE);
				choisirQuiCommence.envoyerCommande();
			}
		});

		checkBleu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setCouleur(Couleur.BLEU);
				choisirQuiCommence.envoyerCommande();
			}
		});

		checkVert.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setCouleur(Couleur.VERT);
				choisirQuiCommence.envoyerCommande();
			}
		});

		choixTaille.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				int tailleChoisie = choixTaille.getSelectionModel().getSelectedItem();

				// int tailleChoisie = tailleSelonNom.get(nomTailleChoisie);

				choisirTailleGrille.setTailleGrille(tailleChoisie);
				choisirTailleGrille.envoyerCommande();
			}
		});

		nombreJoueur.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				int nombreJoueurChoisie = nombreJoueur.getSelectionModel().getSelectedItem();
				choisirNbrJoueur.setNbrJoueur(nombreJoueurChoisie);
				choisirNbrJoueur.envoyerCommande();
				System.out.println(choisirNbrJoueur);
			}
		});

		btnOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				// TODO: Save ou transmettre le json a la partie...
				confirmerParametres.envoyerCommande();
			}
		});
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherQuiCommence(Couleur couleur) {
		J.appel(this);

		DoitEtre.nonNul(couleur);

		switch (couleur) {

		case BLEU:
			checkBleu.setSelected(true);
			checkVert.setSelected(false);
			checkRouge.setSelected(false);
			checkJaune.setSelected(false);
			break;

		case VERT:
			checkBleu.setSelected(false);
			checkVert.setSelected(true);
			checkRouge.setSelected(false);
			checkJaune.setSelected(false);
			break;

		case ROUGE:
			checkBleu.setSelected(false);
			checkVert.setSelected(false);
			checkJaune.setSelected(false);
			checkRouge.setSelected(true);
			break;

		case JAUNE:
			checkBleu.setSelected(false);
			checkVert.setSelected(false);
			checkRouge.setSelected(false);
			checkJaune.setSelected(true);
			break;

		}
	}

	public void initialiserNombreJoueur(ResourceBundle resources) {

		J.appel(this);

		for (int i = NB_JOUEUR_MINIMUM; i <= NB_JOUEUR_MAXIMUM; i++) {
			nombreJoueur.getItems().add(i);
		}
		nombreJoueur.getSelectionModel().clearAndSelect(0);

	}

	public void afficherTailleGrille(int nbCases) {
		J.appel(this);

		int indiceTaille = choixTaille.getItems().indexOf(nbCases);

		if (indiceTaille != -1) {
			choixTaille.getSelectionModel().clearAndSelect(indiceTaille);
		}
	}

	public void afficherNombreJoueur(int nbJoueur) {
		J.appel(this);

		int indiceJoueur = nombreJoueur.getItems().indexOf(nbJoueur);

		if (indiceJoueur != -1) {
			nombreJoueur.getSelectionModel().clearAndSelect(indiceJoueur);
		}
	}
}

// utile slm si on autorise chaque joueur � choisir sa couleur
// private void initialiserChoixCouleur(ResourceBundle resources) {
// J.appel(this);
//
// for(Couleur couleur : Couleur.values()) {
//
// String nomCouleur = couleur.name();
//
// choixCouleurJ1.getItems().add(nomCouleur);
// choixCouleurJ2.getItems().add(nomCouleur);
// choixCouleurJ3.getItems().add(nomCouleur);
// choixCouleurJ4.getItems().add(nomCouleur);
//
// //utilit�????????????????????????????????????????
// tailleSelonNom.put(nomTaille, tailleGrille);
// nomSelonTaille.put(tailleGrille, nomTaille);
// }
// est-ce n�cessaire si on ne veut rien de selectionn� au d�but
// choixCouleurJ1.getSelectionModel().clearAndSelect(0);
// choixCouleurJ1.getSelectionModel().clearAndSelect(0);
// choixCouleurJ1.getSelectionModel().clearAndSelect(0);
// choixCouleurJ1.getSelectionModel().clearAndSelect(0);
// }
