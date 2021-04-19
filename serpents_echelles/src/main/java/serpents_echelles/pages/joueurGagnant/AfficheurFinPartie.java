package serpents_echelles.pages.joueurGagnant;

import java.util.List;

import ntro.mvc.Afficheur;

public class AfficheurFinPartie extends Afficheur<StatistiqueLectureSeule, VueFinPartie> {
// intermediaire entre l'afficheur et la vue

	@Override
	public void initialiserAffichage(StatistiqueLectureSeule mls, VueFinPartie vue) {
		//je veux acceder a la fonction dans la vue qui va afficher le gagnant
		
		// représente les infos complete d'un gagnant (l'objet)
		// chercher le gagnant de la partie, qui va ensuite aller chercher le nom de ce gagnant 
		// (donc retourner un string qui represente le nom --> getNomGagnant())
		// ***cherche le nom dans le Json***
		Joueur gagnant = mls.getGagnant();
		
		// **Affiche littéralement** le nom du gagnant
		vue.afficherGagnant(gagnant.getNom());
		
		
		// getNbSerpentsTouches --> permet d'aller chercher legalement le nb de seprent touchés dans le fichier JSON
		// gagnant --> une variable qui a save la methode GetGagnant(), qui fait partie du MLS, tout en lui donnant le type "Joueur"
		// qui lui donne droit à tous les attributs du joueur
		vue.afficherSerpentsTouches(gagnant.getNbSerpentsTouches());
		
		
		// getNbEchellesTouchees --> permet d'aller chercher legalement le nb d'echelles touchées dans le fichier JSON
		// gagnant --> une variable qui a save la methode GetGagnant(), qui fait partie du MLS, tout en lui donnant le type "Joueur"
		// qui lui donne droit à tous les attributs du joueur
		vue.afficherEchellesTouchees(gagnant.getNbEchellesTouchees());
		
		
		// je veux acceder a la fonction dans la vue qui va afficher les joueurs perdants 
		// retourne la liste des Joueurs perdants et le save dans une variable
		List<Joueur> perdants = mls.getPerdants();		
		vue.afficherPerdant(perdants);
		
	}

	@Override
	public void rafraichirAffichage(StatistiqueLectureSeule mls, VueFinPartie vue) {
		
	}

}
