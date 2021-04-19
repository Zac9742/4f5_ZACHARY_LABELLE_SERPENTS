package serpents_echelles.pages.joueurGagnant;

public interface StatistiquesJoueurLectureSeule {

	// chaque ligne fait partie d'une ligne du fichier JSON (concernant chaque
	// objet)
	int getIdJoueur();

	String getNom();

	boolean getGagnant();

	int getNbPartieGagnees();

	int getNbPartiePerdues();

	int getNbSerpentsTouches();

	int getNbEchellesTouchees();
}
