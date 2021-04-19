package serpents_echelles.pages.joueurGagnant;

import java.util.ArrayList;
import java.util.List;
import ntro.mvc.modeles.Modele;

public class Statistique extends Modele<StatistiqueLectureSeule> implements StatistiqueLectureSeule {

    // j'ai cr�� une nouvelle liste d'objet (les joueurs) qui vont etre perdants
    private List<Joueur> statistiquesJoueurs = new ArrayList<>();

    @Override
    public void apresChargementJson() {
    }

    @Override
    public void apresCreation() {
    }

    // retourne la liste de tous les joueurs
    @Override
    public List<Joueur> getStatistiquesJoueurs() {
        return this.statistiquesJoueurs;
    }

    // on va red�finir (@Override) et inscrire les d�tails de la m�thode pour
    // ensuite l'Acc�der dans l'AfficheurFinPartie
    @Override
    public Joueur getGagnant() {

        // � la base le gagnant est le premier joueur de la liste "statistiquesJoueurs"
        Joueur gagnant = statistiquesJoueurs.get(0);

        for (int i = 0; i < statistiquesJoueurs.size(); i++) {

            // aller chercher le joueur � l'index qui suit dans la boucle FOR
            Joueur joueurCourant = statistiquesJoueurs.get(i);

            // ca va dire si le joueur � la position i est gagnant (soit true ou false)
            if (joueurCourant.getGagnant()) {

                // si le joueur a ete trouv�, il va save dans une liste de joueur perdant
                gagnant = joueurCourant;
                break;
            }
        }
        return gagnant;
    }

    @Override
    public List<Joueur> getPerdants() {

        List<Joueur> joueursPerdants = new ArrayList<>();

        for (int i = 0; i < statistiquesJoueurs.size(); i++) {

            // aller chercher le joueur � l'index qui suit dans la boucle FOR
            Joueur joueurCourant = statistiquesJoueurs.get(i);

            // ca va dire si le joueur � la position i est gagnant (soit true ou false)
            if (!(joueurCourant.getGagnant())) {

                // si le joueur a ete trouv�, il va save dans une liste de joueur perdant
                joueursPerdants.add(joueurCourant);
            }
        }
        return joueursPerdants;
    }

    /**
     * Fonction qui crée et ajoute un joueur à la liste de joueurs du modèle
     * statistique.
     * 
     * @param id                 - le id du joueur
     * @param nom                - le nom du joueur
     * @param gagnant            - si il est gagnant
     * @param nbPartiesGagnees   - le nombre de parties gagnantes
     * @param nbPartiesPerdues   - le nombre de parties perdues
     * @param nbSerpentsTouches  - le nombre de serpents touches
     * @param nbEchellesTouchees - le nombre d'echelles touchees
     */
    public void ajouterJoueur(int id, String nom, boolean gagnant, int nbPartiesGagnees, int nbPartiesPerdues,
            int nbSerpentsTouches, int nbEchellesTouchees) {
        Joueur j = new Joueur(id, nom, gagnant, nbPartiesGagnees, nbPartiesPerdues, nbSerpentsTouches,
                nbEchellesTouchees);

        this.statistiquesJoueurs.add(j);
    }

}