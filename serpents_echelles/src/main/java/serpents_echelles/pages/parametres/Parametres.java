package serpents_echelles.pages.parametres;

import java.util.List;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;
import serpents_echelles.enumerations.*;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {
	private int nbJoueur;
	private List<Joueur> joueurs;
	private Couleur quiCommence;
	private int nbCases;

	@Override
	public void apresCreation() {
		J.appel(this);

		quiCommence = Couleur.JAUNE;
		nbCases = Constantes.CASE_TOTALE_GRILLE_MOYENNE;
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);

		DoitEtre.nonNul(quiCommence);
		DoitEtre.nonNul(nbCases);
		DoitEtre.nonNul(joueurs);
		DoitEtre.nonNul(nbJoueur);
	}

	@Override
	public Couleur getQuiCommence() {
		J.appel(this);

		return quiCommence;
	}

	@Override
	public int getTailleGrille() {
		return nbCases;
	}

	public List<Joueur> getJoueurs() {

		return this.joueurs;
	}

	public int getNbJoueur() {
		J.appel(this);

		return nbJoueur;
	}

	public void setQuiCommence(Couleur joueurQuiCommence) {
		J.appel(this);

		this.quiCommence = joueurQuiCommence;
	}

	public void setTailleGrille(int nbCases) {
		J.appel(this);

		this.nbCases = nbCases;
	}

	public void setJoueur(Joueur joueur) {
		J.appel(this);

		this.joueurs.add(joueur);
	}

	public void setNbJoueur(int nbJoueur) {
		J.appel(this);

		this.nbJoueur = nbJoueur;
	}

	public void choisirQuiCommence(Couleur joueurQuiCommence) {
		J.appel(this);

		this.quiCommence = joueurQuiCommence;
	}

	public void choisirTailleGrille(int tailleGrille) {
		J.appel(this);

		this.nbCases = tailleGrille;
	}

}
