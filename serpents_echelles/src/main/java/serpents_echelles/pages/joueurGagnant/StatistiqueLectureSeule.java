package serpents_echelles.pages.joueurGagnant;

import java.util.List;
import ntro.mvc.modeles.ModeleLectureSeule;

public interface StatistiqueLectureSeule extends ModeleLectureSeule {

	List<Joueur> getStatistiquesJoueurs();

	// (premi�re �tape) ajout de la m�thode getGagnant pour qu'il le reconnaisse, je
	// definis la m�thode et son type de retour
	Joueur getGagnant();

	// (premi�re �tape) ajout de la m�thode getPerdants pour qu'il le reconnaisse,
	// je definis la m�thode et son type de retour
	// ceci est mon getteur pour aller chercher la liste des perdants
	List<Joueur> getPerdants();

}
