package serpents_echelles.pages.partie_locale.afficheurs;

import java.util.List;

import ntro.debogage.J;
import ntro.mvc.Afficheur;
import serpents_echelles.enumerations.CouleurPion;
import serpents_echelles.pages.partie_locale.modeles.Joueur;
import serpents_echelles.pages.partie_locale.modeles.PartieLectureSeule;
import serpents_echelles.pages.partie_locale.modeles.Pion;
import serpents_echelles.pages.partie_locale.vues.VuePartie;

public class AfficheurPartie<PLS extends PartieLectureSeule, V extends VuePartie> extends Afficheur<PLS, V> {

    @Override
    public void initialiserAffichage(PLS partieLectureSeule, V vue) {
        J.appel(this);

        int largeur = 5;
        int hauteur = 0;
        switch (partieLectureSeule.getGrille().getTaille()) {
		case 25:
			hauteur = 5;
			break;
		case 50:
			hauteur = 10;
			break;
		case 75:
			hauteur = 15;
			break;
		}

        vue.creerGrille(largeur, hauteur);

        vue.afficherModificateursPosition(partieLectureSeule.getGrille().getSerpents(), largeur, hauteur);
        vue.afficherModificateursPosition(partieLectureSeule.getGrille().getEchelles(), largeur, hauteur);
        vue.initialiserDe(partieLectureSeule.getDe().getNombre());
    }

    @Override
    public void rafraichirAffichage(PLS partieLectureSeule, V vue) {
        J.appel(this);

        // Afficher les joueurs sur la grille
        // TODO: Handle error pour taille pas carree...
        int taileGrille = partieLectureSeule.getGrille().getTaille();
        int longeurGrille = 5;
        int hauteurGrille = 0;
        switch (partieLectureSeule.getGrille().getTaille()) {
		case 25:
			hauteurGrille = 5;
			break;
		case 50:
			hauteurGrille = 10;
			break;
		case 75:
			hauteurGrille = 15;
			break;
		}
        
        List<Joueur> joueurs = partieLectureSeule.getJoueurs();

        vue.verifierSiGagnant(joueurs);
        
        int numeroJoueur = 1;
        int nbJoueurs = joueurs.size();
        
        for (Joueur joueur : joueurs) {
        	
            // Commence par enlever tous les pions des joueurs sur la grille en se basant
            // sur leur position precedente
            Pion pionJoueur = joueur.getPion();
            int posPrecJoueurGrille = pionJoueur.getPosPrecedente();
            int posPrecX = positionEnGrille(posPrecJoueurGrille, hauteurGrille)[0];
            int posPrecY = positionEnGrille(posPrecJoueurGrille, longeurGrille)[1];

            vue.enleverPion(posPrecX, posPrecY, pionJoueur.getCouleur()); // enleve le pion ici, avec son id etant son
                                                                          // nom de couleur (vu que tjrs unique)

            int posJoueurGrille = pionJoueur.getPosition();

            CouleurPion couleurPionJoueur = pionJoueur.getCouleur();

            int posX = positionEnGrille(posJoueurGrille, hauteurGrille)[0];
            int posY = positionEnGrille(posJoueurGrille, longeurGrille)[1];

            vue.afficherPion(posX, posY, couleurPionJoueur, nbJoueurs, numeroJoueur); // Afficher tous les pions...
            numeroJoueur++;
        }

        vue.rafraichirDe(partieLectureSeule.getDe().getNombre());
        vue.initialiserInfoCarteJoueur(partieLectureSeule.getJoueurs().get(partieLectureSeule.getIdJoueurCourant())); // TODO:
                                                                                                                      // A
                                                                                                                      // changer
                                                                                                                      // pour
                                                                                                                      // le
                                                                                                                      // bon
                                                                                                                      // id
        // joueur...
        vue.afficherInfosJoueurs(partieLectureSeule.getJoueurs(), partieLectureSeule.getIdJoueurCourant());
    }

    /**
     * Fonction qui change la position du joueur en coordonnees sur la grille.
     * 
     * @param pos           - Position du joueur.
     * @param longeurGrille - La largeur de la grille.
     * @return Un tableau de 2 positions, soit la position en x et celle en y.
     */
    private int[] positionEnGrille(int pos, int longeurGrille) {
        int posX = longeurGrille - 1 - (pos >= longeurGrille ? Math.floorDiv(pos, longeurGrille) : 0);
        int posY = pos >= longeurGrille ? pos % longeurGrille : pos;

        return new int[] { posX, posY };
    }

}
