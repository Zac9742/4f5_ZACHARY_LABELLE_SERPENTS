package serpents_echelles.pages.parametres;

import java.util.List;

import ntro.mvc.modeles.ModeleLectureSeule;
import serpents_echelles.enumerations.*;

public interface ParametresLectureSeule extends ModeleLectureSeule {

	Couleur getQuiCommence();

	int getTailleGrille();

	List<Joueur> getJoueurs();

	int getNbJoueur();

}
