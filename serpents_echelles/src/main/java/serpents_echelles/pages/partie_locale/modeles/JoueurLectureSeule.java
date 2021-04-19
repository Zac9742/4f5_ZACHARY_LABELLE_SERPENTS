package serpents_echelles.pages.partie_locale.modeles;

public interface JoueurLectureSeule {
    int getId();

    int getDernierLancer();

    int getNbCasesRestantes();

    String getNom();

    Pion getPion();

    boolean getAGagne();
}
