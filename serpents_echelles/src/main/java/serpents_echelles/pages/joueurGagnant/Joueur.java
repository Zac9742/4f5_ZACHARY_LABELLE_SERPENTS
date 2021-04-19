package serpents_echelles.pages.joueurGagnant;

public class Joueur implements StatistiquesJoueurLectureSeule {

	private int idJoueur;
	private String nom;
	private boolean gagnant;
	private int nbPartieGagnees;
	private int nbPartiePerdues;
	private int nbSerpentsTouches;
	private int nbEchellesTouchees;

	// Ajout de constructeur pour création d'un joueur - Nicolas
	public Joueur(int idJoueur, String nom, boolean gagnant, int nbPartieGagnees, int nbPartiePerdues,
			int nbSerpentsTouches, int nbEchellesTouchees) {
		this.idJoueur = idJoueur;
		this.nom = nom;
		this.gagnant = gagnant;
		this.nbPartieGagnees = nbPartieGagnees;
		this.nbPartiePerdues = nbPartiePerdues;
		this.nbSerpentsTouches = nbSerpentsTouches;
		this.nbEchellesTouchees = nbEchellesTouchees;
	}

	@Override
	public int getIdJoueur() {
		return this.idJoueur;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public boolean getGagnant() {
		return this.gagnant;
	}

	@Override
	public int getNbPartieGagnees() {
		return this.nbPartieGagnees;
	}

	@Override
	public int getNbPartiePerdues() {
		return this.nbPartiePerdues;
	}

	@Override
	public int getNbSerpentsTouches() {
		return this.nbSerpentsTouches;
	}

	@Override
	public int getNbEchellesTouchees() {
		return this.nbEchellesTouchees;
	}

}
