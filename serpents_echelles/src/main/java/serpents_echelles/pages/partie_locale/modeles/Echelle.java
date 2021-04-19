package serpents_echelles.pages.partie_locale.modeles;

import serpents_echelles.enumerations.CouleurModificateur;

//import ntro.debogage.J;

//import serpents_echelles.enumerations.CouleurEchelle;
//import serpents_echelles.enumerations.CouleurModificateur;

public class Echelle extends ModificateurPosition implements EchelleLectureSeule {

  public Echelle(int posDebut, int posFin, CouleurModificateur couleur) {
    super(posDebut, posFin, couleur);
  }
}
