package serpents_echelles.pages.partie_locale.modeles;

import serpents_echelles.enumerations.CouleurModificateur;

//import serpents_echelles.enumerations.CouleurModificateur;
//import ntro.debogage.J;
//import serpents_echelles.enumerations.CouleurSerpent;

public class Serpent extends ModificateurPosition implements SerpentLectureSeule {
  public Serpent(int posDebut, int posFin, CouleurModificateur couleur) {
    super(posDebut, posFin, couleur);
  }
}
