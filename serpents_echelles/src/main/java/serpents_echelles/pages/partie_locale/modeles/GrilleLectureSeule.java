package serpents_echelles.pages.partie_locale.modeles;

import java.util.List;

public interface GrilleLectureSeule {
    int getTaille();
    Case getCase(int position);
    List<Case> getListeCases();
    List<Serpent> getSerpents();
    List<Echelle> getEchelles();
}
