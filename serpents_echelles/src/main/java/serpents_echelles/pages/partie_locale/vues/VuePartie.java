package serpents_echelles.pages.partie_locale.vues;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import serpents_echelles.pages.partie_locale.Constantes;
import serpents_echelles.commandes.afficher_stats_fin_partie.AfficherStats;
import serpents_echelles.commandes.afficher_stats_fin_partie.AfficherStatsPourEnvoi;
import serpents_echelles.commandes.brasser_de.BrasserDe;
import serpents_echelles.commandes.brasser_de.BrasserDePourEnvoi;
import serpents_echelles.enumerations.CouleurPion;
import serpents_echelles.pages.partie_locale.modeles.Joueur;
import serpents_echelles.pages.partie_locale.modeles.ModificateurPosition;
import serpents_echelles.pages.partie_locale.modeles.Pion;
import serpents_echelles.pages.partie_locale.modeles.Serpent;

public abstract class VuePartie implements Vue, Initializable {

    // TODO: Manque serpents, joueurs, bouton jouer...

    @FXML
    private StackPane conteneurGrilleMod;

    @FXML
    private VBox conteneurGrille;

    @FXML
    private Pane conteneurModPos;

    @FXML
    private VBox conteneurDe;

    @FXML
    private VBox conteneurJoueurs;

    @FXML
    private VBox conteneurInfoJoueur;

    @FXML
    private VBox conteneurAvatar;

    private int nbCasesTotales;
    private FlowPane[][] casesPanes;
    private Rectangle[][] cases;
    private Button de;

    private List<ImageView> modificateursPosistion;

    private BrasserDePourEnvoi brasserDePourEnvoi;
    private AfficherStatsPourEnvoi afficherStatsFinPartie;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        J.appel(this);

        DoitEtre.nonNul(conteneurDe);
        DoitEtre.nonNul(conteneurGrille);
        DoitEtre.nonNul(conteneurModPos);
    }

    @Override
    public void obtenirCommandesPourEnvoi() {
        J.appel(this);

        this.brasserDePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(BrasserDe.class);
        this.afficherStatsFinPartie = FabriqueCommande.obtenirCommandePourEnvoi(AfficherStats.class);
    }

    @Override
    public void installerCapteursEvenementsUsager() {
        J.appel(this);

        this.de.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                J.appel(this);

                int nb = (int) ((Math.random() * 6) + 1);

                brasserDePourEnvoi.setNombre(nb);
                brasserDePourEnvoi.envoyerCommande();
            }
        });
    }

    @Override
    public void verifierCommandesPossibles() {
        J.appel(this);
    }

    // Y-aurait-il facon plus simple de faire ca (verifier si jouer a gagne)?
    public void verifierSiGagnant(List<Joueur> joueurs) {
        for (Joueur joueur : joueurs) {
            if (joueur.getAGagne()) {
                this.afficherStatsFinPartie.envoyerCommande();
                break;
            }
        }
    }

    public void afficherInfosJoueurs(List<Joueur> joueurs, int joueurCourant) {
        this.conteneurJoueurs.getChildren().clear(); // est-ce mieux de faire ca ou une methode rafraichir et un
                                                     // initialiser...

        for (Joueur joueur : joueurs) {
            HBox conteneur = new HBox();
            Circle couleurJoueur = new Circle();
            CouleurPion couleurPion = joueur.getPion().getCouleur();
            Label nomJoueur = new Label(joueur.getNom());
            Image imageJoueurCourant = new Image("/assets/de_face_5.png");
            ImageView imageViewJoueurCourant = new ImageView(imageJoueurCourant);

            conteneur.setAlignment(Pos.CENTER_LEFT);
            conteneur.setSpacing(10);
            conteneur.setMinWidth(200);
            nomJoueur.setFont(new Font(20));
            couleurJoueur.setRadius(5);
            imageViewJoueurCourant.setFitHeight(20);
            imageViewJoueurCourant.setFitWidth(20);

            switch (couleurPion) {
            case BLEU:
                couleurJoueur.setFill(Color.BLUE);
                break;

            case ROUGE:
                couleurJoueur.setFill(Color.RED);
                break;
            case BLANC:
                couleurJoueur.setFill(Color.WHITE);
                break;
            case VERT:
                couleurJoueur.setFill(Color.GREEN);
                break;
            case ORANGE:
                couleurJoueur.setFill(Color.ORANGE);
                break;
            case JAUNE:
                couleurJoueur.setFill(Color.YELLOW);
                break;
            default:
                couleurJoueur.setFill(Color.BLACK);
                break;
            }

            conteneur.getChildren().add(couleurJoueur);
            conteneur.getChildren().add(nomJoueur);

            if (joueur.getId() == joueurCourant) {
                conteneur.getChildren().add(imageViewJoueurCourant);
            }

            this.conteneurJoueurs.getChildren().add(conteneur);
        }
    }

    public void initialiserInfoCarteJoueur(Joueur joueur) {
        CouleurPion couleurPion = joueur.getPion().getCouleur();
        String urlPion = "/assets/pion_";

        switch (couleurPion) {
        case BLEU:
            urlPion += "bleu.png";
            break;

        case ROUGE:
            urlPion += "rouge.png";
            break;
        case BLANC:
            urlPion += "blanc.png";
            break;
        case VERT:
            urlPion += "vert.png";
            break;
        case ORANGE:
            urlPion += "orange.png";
            break;
        case JAUNE:
            urlPion += "jaune.png";
            break;
        default:
            urlPion += "blanc.png";
            break;
        }

        Image pionImg = new Image(urlPion);
        ImageView pionImgView = new ImageView(pionImg);

        String nomJoueur = joueur.getNom();
        Pion pionJoueur = joueur.getPion();

        Label nomJoueurLbl = new Label(nomJoueur);
        Label casesRestantesLbl = new Label(
                "Nombre de cases restantes: " + Integer.toString(this.nbCasesTotales - pionJoueur.getPosition() - 1));
        Label dernierLancerLbl = new Label("Dernier lancer: " + Integer.toString(joueur.getDernierLancer()));
        Label nbEchellesLbl = new Label("Nombre d'\u00E9chelles: " + Integer.toString(pionJoueur.getNbEchelles()));
        Label nbSerpentsLbl = new Label("Nombre de serpents: " + Integer.toString(pionJoueur.getNbSerpents()));

        nomJoueurLbl.setFont(new Font(20));
        casesRestantesLbl.setFont(new Font(14));
        dernierLancerLbl.setFont(new Font(14));
        nbEchellesLbl.setFont(new Font(14));
        nbSerpentsLbl.setFont(new Font(14));

        this.conteneurInfoJoueur.getChildren().clear(); // est-ce mieux de faire ca ou une methode rafraichir et un
                                                        // initialiser...

        this.conteneurAvatar.getChildren().clear();
        this.conteneurAvatar.getChildren().add(pionImgView);
        this.conteneurInfoJoueur.setAlignment(Pos.CENTER_LEFT);
        this.conteneurInfoJoueur.getChildren().add(nomJoueurLbl);
        this.conteneurInfoJoueur.getChildren().add(casesRestantesLbl);
        this.conteneurInfoJoueur.getChildren().add(dernierLancerLbl);
        this.conteneurInfoJoueur.getChildren().add(nbEchellesLbl);
        this.conteneurInfoJoueur.getChildren().add(nbSerpentsLbl);
    }

    public void creerGrille(int largeurGrille) {
        J.appel(this);

        this.nbCasesTotales = (int) Math.pow(largeurGrille, 2);

        this.casesPanes = new FlowPane[largeurGrille][largeurGrille];
        this.cases = new Rectangle[largeurGrille][largeurGrille]; // Car c'est un carre

        for (int i = 0; i < largeurGrille; i++) {
            HBox ligneCourante = creerLigne(i, largeurGrille);

            this.conteneurGrille.getChildren().add(ligneCourante);
        }
    }

    public void afficherModificateursPosition(List<? extends ModificateurPosition> modPos, int largeurGrille) {
        J.appel(this);

        this.modificateursPosistion = new ArrayList<>();

        for (ModificateurPosition mod : modPos) {
            int debut = mod.getIndiceCaseDebut();
            int fin = mod.getIndiceCaseFin();

            int[] coordonnesPointsLigne = this.transformePosEnCoordonnees(debut, fin, largeurGrille);

            // Crée une ligne qui relie deux cases.
            Line modLigne = new Line(coordonnesPointsLigne[0], coordonnesPointsLigne[1], coordonnesPointsLigne[2],
                    coordonnesPointsLigne[3]);

            // Trouve la longeur de la ligne ainsi que son angle de rotation...
            double rotation = Math.atan2(modLigne.getEndY() - modLigne.getStartY(),
                    modLigne.getEndX() - modLigne.getStartX());

            // Formule de pythagore pour trouver la longeur de la ligne...
            double longeur = Math.sqrt(Math.pow((modLigne.getEndX() - modLigne.getStartX()), 2)
                    + Math.pow((modLigne.getEndY() - modLigne.getStartY()), 2));

            // Crée le serpent avec l'image et attribue ses caractéristiques.
            Image modImg = new Image((mod instanceof Serpent) ? "/assets/serpent.png" : "/assets/echelle.png");
            ImageView modImgView = new ImageView();
            Rotate rotationSpeciale = new Rotate(Math.toDegrees(rotation) + 90, 0, 0); // Pour faire la rotation à
                                                                                       // partir du point en haut a
                                                                                       // gauche de l'image.

            // Appliquer les modifications.
            modImgView.setImage(modImg);
            modImgView.setFitHeight(longeur);
            modImgView.setFitWidth(longeur / 15);
            modImgView.setLayoutX(coordonnesPointsLigne[2]);
            modImgView.setLayoutY(coordonnesPointsLigne[3]);
            modImgView.getTransforms().add(rotationSpeciale);

            // Ajoute le serpent au conteneur.
            this.modificateursPosistion.add(modImgView);
            this.conteneurModPos.getChildren().add(modImgView);
        }
    }

    /**
     * Fonction qui prend position en terme de cases et retourne les positions en
     * terme graphiques, donc en x et en y, pour suivre la grille de cases.
     * 
     * @param posCaseDebut  - La position de la case de début.
     * @param posCaseFin    - La position de la case de fin.
     * @param largeurGrille - La largeur de la grille.
     * @return Un tableau de position en nombre.
     */
    private int[] transformePosEnCoordonnees(int posCaseDebut, int posCaseFin, int largeurGrille) {
        int[] pos = new int[4];

        pos[0] = ((posCaseDebut >= largeurGrille ? posCaseDebut % largeurGrille : posCaseDebut))
                * Constantes.MIN_TAILLE_CASE + (Constantes.MIN_TAILLE_CASE / 2);
        pos[1] = (largeurGrille - 1 - (posCaseDebut >= largeurGrille ? Math.floorDiv(posCaseDebut, largeurGrille) : 0))
                * Constantes.MIN_TAILLE_CASE + (Constantes.MIN_TAILLE_CASE / 2);
        pos[2] = ((posCaseFin >= largeurGrille ? posCaseFin % largeurGrille : posCaseFin)) * Constantes.MIN_TAILLE_CASE
                + (Constantes.MIN_TAILLE_CASE / 2);
        pos[3] = (largeurGrille - 1 - (posCaseFin >= largeurGrille ? Math.floorDiv(posCaseFin, largeurGrille) : 0))
                * Constantes.MIN_TAILLE_CASE + (Constantes.MIN_TAILLE_CASE / 2);

        return pos;
    }

    private HBox creerLigne(int indiceLigne, int longeur) {
        HBox ligne = new HBox();

        for (int i = 0; i < longeur; i++) {
            FlowPane _casePane = new FlowPane();
            Rectangle _case = new Rectangle();

            _casePane.setAlignment(Pos.CENTER);

            _case.setWidth(Constantes.MIN_TAILLE_CASE);
            _case.setHeight(Constantes.MIN_TAILLE_CASE);

            if (indiceLigne % 2 == 0) {
                if (i % 2 == 0) {
                    _case.setFill(Color.web("#9DE1F6"));
                } else {
                    _case.setFill(Color.web("#DE6262"));
                }
            } else {
                if (i % 2 != 0) {
                    _case.setFill(Color.web("#9DE1F6"));
                } else {
                    _case.setFill(Color.web("#DE6262"));
                }
            }

            _case.setStrokeType(StrokeType.INSIDE);
            _case.setStroke(Color.BLACK);

            this.casesPanes[indiceLigne][i] = _casePane;
            this.cases[indiceLigne][i] = _case;

            _casePane.getChildren().add(_case);
            _casePane.toFront();
            ligne.getChildren().add(_casePane);
        }

        return ligne;
    }

    private boolean siIndicesValides(int indiceColonne, int indiceRangee) {
        J.appel(this);

        boolean siValide = false;

        if (indiceColonne >= 0 && indiceColonne < cases.length) {
            siValide = indiceRangee >= 0 && indiceRangee < cases[indiceColonne].length;
        }

        return siValide;
    }

    public void enleverPion(int indiceColonne, int indiceRangee, CouleurPion couleurPion) {
        if (siIndicesValides(indiceColonne, indiceRangee)) {
            FlowPane cCourante = this.casesPanes[indiceColonne][indiceRangee];
            cCourante.getChildren().remove(cCourante.lookup("#" + couleurPion.name())); // Enleve le pion en cherchant
                                                                                        // le
                                                                                        // node avec le id (nom de la
                                                                                        // couleur du pion).
        }
    }

    public void afficherPion(int indiceColonne, int indiceRangee, CouleurPion couleurPion, int nbJoueurs, int numeroJoueur) {
        J.appel(this);

        if (siIndicesValides(indiceColonne, indiceRangee)) {
        	
        	
            FlowPane _case = this.casesPanes[indiceColonne][indiceRangee];
            String urlPion = "/assets/pion_";
            
            switch (couleurPion) {
            case BLEU:
                urlPion += "bleu.png";
                break;

            case ROUGE:
                urlPion += "rouge.png";
                break;
            case BLANC:
                urlPion += "blanc.png";
                break;
            case VERT:
                urlPion += "vert.png";
                break;
            case ORANGE:
                urlPion += "orange.png";
                break;
            case JAUNE:
                urlPion += "jaune.png";
                break;
            default:
                urlPion += "blanc.png";
                break;
            }
            
            /*
            switch (nbJoueurs) {
			case 2:
				
				switch (numeroJoueur) {
				case 1:
					
					break;
				}
				break;
				
			}
			*/
            J.valeurs(urlPion);
            Image pionImg = new Image(urlPion);
            ImageView pionImgView = new ImageView(pionImg);
            pionImgView.setId(couleurPion.name()); // Met le id du image view du pion pour le nom de la couleur.
            
            
            
            _case.getChildren().add(pionImgView);
        }
    }

    public void initialiserDe(int num) {
        this.de = new Button();
        String url = "/assets/de_face_" + num + ".png";
        Image faceDe = new Image(url);
        ImageView faceDeView = new ImageView(faceDe);

        faceDeView.setFitHeight(Constantes.TAILLE_DE - 20);
        faceDeView.setFitWidth(Constantes.TAILLE_DE - 20);

        this.de.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.de.setBorder(new Border(new BorderStroke(Color.BLACK, null, null, new BorderWidths(2, 2, 2, 2))));
        this.de.setGraphic(faceDeView);

        this.de.setMinWidth(Constantes.TAILLE_DE);
        this.de.setMinHeight(Constantes.TAILLE_DE);

        this.conteneurDe.getChildren().add(this.de);
    }

    // est-ce que je devrais juste detruire le de et recreer un autre a chaque
    // coup...
    public void rafraichirDe(int num) {
        /*
         * if (num > 0 && num <= 6) { this.de = new Button(); String url =
         * "/assets/de_face_" + num + ".png"; Image faceDe = new Image(url); ImageView
         * faceDeView = new ImageView(faceDe);
         * 
         * faceDeView.setFitHeight(Constantes.TAILLE_DE - 20);
         * faceDeView.setFitWidth(Constantes.TAILLE_DE - 20);
         * 
         * this.de.setBackground(new Background(new BackgroundFill(Color.WHITE, null,
         * null))); this.de.setBorder(new Border(new BorderStroke(Color.BLACK, null,
         * null, new BorderWidths(2, 2, 2, 2)))); this.de.setGraphic(faceDeView); } else
         * { this.de = new Button("1"); }
         * 
         * this.de.setMinWidth(Constantes.TAILLE_DE);
         * this.de.setMinHeight(Constantes.TAILLE_DE);
         * 
         * this.conteneurDe.getChildren().add(this.de);
         */
        String url = "/assets/de_face_" + num + ".png";
        J.valeurs(num);
        Image faceDe = new Image(url);
        ImageView faceDeView = new ImageView(faceDe);

        this.de.setGraphic(faceDeView);
    }

}
