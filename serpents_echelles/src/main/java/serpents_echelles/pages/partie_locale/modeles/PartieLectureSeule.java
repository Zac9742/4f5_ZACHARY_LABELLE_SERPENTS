package serpents_echelles.pages.partie_locale.modeles;

import java.util.List;

import ntro.mvc.modeles.ModeleLectureSeule;

public interface PartieLectureSeule extends ModeleLectureSeule {
    GrilleLectureSeule getGrille();
    List<Joueur> getJoueurs();
    De getDe();
    int getIdJoueurCourant();
}
