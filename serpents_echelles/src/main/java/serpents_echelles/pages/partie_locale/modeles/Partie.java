package serpents_echelles.pages.partie_locale.modeles;

import java.util.ArrayList;
import java.util.List;

import ntro.mvc.modeles.Modele;
import serpents_echelles.enumerations.CouleurPion;

public class Partie<PLS extends PartieLectureSeule> extends Modele<PLS> implements PartieLectureSeule {
    protected Grille grille;
    protected List<Joueur> joueurs = new ArrayList<>();
    protected De de;
    protected int idJoueurCourant;

    @Override
    public void apresChargementJson() {

    }

    @Override
    public void apresCreation() {

    }

    @Override
    public GrilleLectureSeule getGrille() {
        return (GrilleLectureSeule) this.grille;
    }

    @Override
    public List<Joueur> getJoueurs() {
        return this.joueurs;
    }

    @Override
    public De getDe() {
        return this.de;
    }

    @Override
    public int getIdJoueurCourant() {
        return this.idJoueurCourant;
    }

    /**
     * Fonction qui effectue toutes les actions liées à un coup d'un joueur. Elle va
     * changer le numéro du dé, bouger le pion du joueur qui a joué et changer le
     * prochain joueur qui doit jouer.
     * 
     * @param num - le numéro du dé lancé.
     */
    public void effectuerCoup(int num) {
        this.changerNumDe(num);
        this.bougerPionJoueur(num);
        this.changerProchainJoueur();
    }

    /**
     * Fonction qui va changer le numéro du dé pour afficher le bon sur la vue.
     * 
     * @param num - de numéro du dé lancé.
     */
    public void changerNumDe(int num) {
        this.de.setNombre(num);
    }

    /**
     * Fonction qui bouge la position du joueur lorsqu'il lance le dé. Elle va
     * calculer sa nouvelle position, sauvegarder sa position précédente. De plus,
     * elle va vérifier si le joueur atteint un serpent ou une échelle et bouger le
     * pion du joueur à la bonne case en cas échéant.
     * 
     * @param num - le numéro du dé que le joueur lance.
     */
    public void bougerPionJoueur(int num) {
        List<Echelle> echelles = this.getGrille().getEchelles();
        List<Serpent> serpents = this.getGrille().getSerpents();

        for (Joueur joueur : this.joueurs) {
            Pion pJoueur = joueur.getPion();
            pJoueur.setPosPrecedente(pJoueur.getPosition());
        }

        Joueur jCourant = this.joueurs.get(this.idJoueurCourant);
        Pion pCourant = jCourant.getPion();
        int tailleGrille = this.getGrille().getTaille();
        int nouvellePosition = pCourant.getPosition() + num;

        pCourant.setPosPrecedente(pCourant.getPosition());

        if (nouvellePosition >= tailleGrille - 1) {
            pCourant.setPosition(tailleGrille - 1);
            jCourant.gagner();
            // Montrer la page gagnante...
            // Ecq bonne facon de faire?? Aussi, save pas avec un bon nom de document...

            /*
             * try { EntrepotDeModeles.sauvegarderModele(this); } catch (IOException e) {
             * e.printStackTrace(); }
             */

            System.out.println(pCourant.getCouleur().name() + " a gagné!");
        } else {
            pCourant.setPosition(nouvellePosition);
            jCourant.setDernierLancer(num);

            // Verifie que le joueur n'a pas atteint une echelle
            for (Echelle echelle : echelles) {
                if (nouvellePosition == echelle.getIndiceCaseDebut()) {
                    pCourant.setPosition(echelle.getIndiceCaseFin());
                    pCourant.setNbEchelles(pCourant.getNbEchelles() + 1);
                    break;
                }
            }

            // Verifie que le joueur n'a pas atteint un serpent
            for (Serpent serpent : serpents) {
                if (nouvellePosition == serpent.getIndiceCaseDebut()) {
                    pCourant.setPosition(serpent.getIndiceCaseFin());
                    pCourant.setNbSerpents(pCourant.getNbSerpents() + 1);
                    break;
                }
            }

            jCourant.setNbCasesRestantes(tailleGrille - nouvellePosition);
        }
    }

    /**
     * Fonction qui change le joueur courant. Elle va indiquer quel est le nouveau
     * joueur qui doit jouer.
     */
    public void changerProchainJoueur() {
        if (this.idJoueurCourant == (this.joueurs.size() - 1)) {
            this.idJoueurCourant = 0;
        } else {
            this.idJoueurCourant++;
        }
    }

    /**
     * TODO: Finir cette fonction
     * 
     * Fonction qui génère la grille. Elle va créer la grille avec la taille
     * spécifiée. Elle va aussi générer les modificateurs position (serpents et
     * echelles) et les insérer dans la grille.
     * 
     * @param taille     - la taille voulue de la grille.
     * @param nbSerpents - le nombre de serpent voulus sur la grille.
     * @param nbEchelles - le nombre d'échelles voulues sur la grille.
     */
    public void creerGrille(int taille, int nbSerpents, int nbEchelles) {
        List<Serpent> serpents = new ArrayList<>();

        for (int i = 0; i < nbSerpents; i++) {
            int posDebut = (int) (Math.random() * taille - 1) + 0;

            // ModificateurPosition serpent = new Serpent();
        }

        // Grille g = new Grille()
    }

    /**
     * Fonction qui ajoute un joueur à la liste de joueurs du modèle partie. Elle
     * crée un joueur et l'insère à la liste de joueurs de la partie.
     * 
     * @param id      - Le id du joueur.
     * @param nom     - Le nom du joueur.
     * @param couleur - La couleur du pion du joueur.
     */
    public void ajouterJoueur(int id, String nom, CouleurPion couleur) {
        Pion p = new Pion(couleur, 0, 0, 0, 0);
        Joueur j = new Joueur(id, nom, p, 1, this.grille.getTaille() - 1);

        this.joueurs.add(j);
    }
}
