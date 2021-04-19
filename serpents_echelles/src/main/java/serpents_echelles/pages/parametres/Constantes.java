
package serpents_echelles.pages.parametres;

import serpents_echelles.enumerations.TailleGrille;

public class Constantes {

	public static final String ID_MODELE_PAR_DEFAUT = "defaut";
	public static final String CHEMIN_PARAMETRES_FXML = "/parametres/structure.xml";
	public static final String CHEMIN_PARTIE_LOCALE_FXML = "/partie/locale/structure.xml";

	public static final String[] IDS_MODELES_TESTS = { "test1", "test2", "test3" };

	public static final int NB_JOUEUR_MINIMUM = 1;
	public static final int NB_JOUEUR_MAXIMUM = 4;

	public static final int HAUTEUR_GRILLE_PETITE = 5;
	public static final int HAUTEUR_GRILLE_MOYENNE = 10;
	public static final int HAUTEUR_GRILLE_GRANDE = 15;

	public static final int LARGEUR_GRILLE_PETITE = 5;
	public static final int LARGEUR_GRILLE_MOYENNE = 5;
	public static final int LARGEUR_GRILLE_GRANDE = 5;

	public static final int CASE_TOTALE_GRILLE_PETITE = 25;
	public static final int CASE_TOTALE_GRILLE_MOYENNE = 50;
	public static final int CASE_TOTALE_GRILLE_GRANDE = 75;

	public static final TailleGrille TAILLE_GRILLE_PAR_DEFAUT = TailleGrille.PETITE;

	public static final int TAILLE_CASE = 40;

	public static final int LARGEUR_PIXELS_MIN = 400;
	public static final int HAUTEUR_PIXELS_MIN = 600;

	public static final int LARGEUR_PIXELS = 500;
	public static final int HAUTEUR_PIXELS = 400;

	public static final int LARGEUR_PARAMETRES_PIXELS_MIN = 250;
	public static final int HAUTEUR_PARAMETRES_PIXELS_MIN = 500;

	public static final int LARGEUR_PARAMETRES_PIXELS = 300;
	public static final int HAUTEUR_PARAMETRES_PIXELS = 520;

	public static final int LARGEUR_PARAMETRES_PIXELS_MAX = 350;
	public static final int HAUTEUR_PARAMETRES_PIXELS_MAX = 540;
}
