package serpents_echelles.pages.partie_locale.modeles;

public class Joueur implements JoueurLectureSeule {
    private int id;
    private String nom;
    private Pion pion;
    private int dernierLancer;
    private transient int nbCasesRestantes;
    private boolean aGagne = false;

    public Joueur(int id, String nom, Pion pion, int dernierLancer, int nbCasesRestantes) {
        this.id = id;
        this.nom = nom;
        this.pion = pion;
        this.dernierLancer = dernierLancer;
        this.nbCasesRestantes = nbCasesRestantes;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public Pion getPion() {
        return this.pion;
    }

    @Override
    public int getDernierLancer() {
        return this.dernierLancer;
    }

    @Override
    public int getNbCasesRestantes() {
        return this.nbCasesRestantes;
    }

    @Override
    public boolean getAGagne() {
        return this.aGagne;
    }

    public void setDernierLancer(int num) {
        this.dernierLancer = num;
    }

    public void setNbCasesRestantes(int nb) {
        this.nbCasesRestantes = nb;
    }

    public void gagner() {
        this.aGagne = true;
    }
}
