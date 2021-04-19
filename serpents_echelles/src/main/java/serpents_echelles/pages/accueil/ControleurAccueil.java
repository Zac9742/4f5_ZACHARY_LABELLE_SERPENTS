package serpents_echelles.pages.accueil;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.mvc.controleurs.ControleurVue;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;
import serpents_echelles.commandes.afficher_stats_fin_partie.AfficherStats;
import serpents_echelles.commandes.afficher_stats_fin_partie.AfficherStatsRecue;
import serpents_echelles.commandes.commencer_partie.CommencerPartie;
import serpents_echelles.commandes.commencer_partie.CommencerPartieRecue;
import serpents_echelles.commandes.confirmer_parametres.ConfirmerParametres;
import serpents_echelles.commandes.confirmer_parametres.ConfirmerParametresRecue;
import serpents_echelles.commandes.fermer_historique.FermerHistorique;
import serpents_echelles.commandes.fermer_historique.FermerHistoriqueRecue;
import serpents_echelles.commandes.ouvrir_historique.OuvrirHistorique;
import serpents_echelles.commandes.ouvrir_historique.OuvrirHistoriqueRecue;
import serpents_echelles.commandes.ouvrir_parametres.OuvrirParametres;
import serpents_echelles.commandes.ouvrir_parametres.OuvrirParametresRecue;
import serpents_echelles.commandes.quitter.Quitter;
import serpents_echelles.commandes.quitter.QuitterRecue;
import serpents_echelles.commandes.quitter_stats.QuitterStats;
import serpents_echelles.commandes.quitter_stats.QuitterStatsRecue;
import serpents_echelles.enumerations.CouleurPion;
import serpents_echelles.pages.historique_parties.Historique;
import serpents_echelles.pages.historique_parties.afficheurs.AfficheurHistorique;
import serpents_echelles.pages.historique_parties.controleurs.ControleurHistorique;
import serpents_echelles.pages.historique_parties.vues.VueHistorique;
import serpents_echelles.pages.joueurGagnant.AfficheurFinPartie;
import serpents_echelles.pages.joueurGagnant.ControleurFinPartie;
import serpents_echelles.pages.joueurGagnant.Statistique;
import serpents_echelles.pages.joueurGagnant.VueFinPartie;
import serpents_echelles.pages.parametres.AfficheurParametres;
import serpents_echelles.pages.parametres.ControleurParametres;
import serpents_echelles.pages.parametres.Parametres;
import serpents_echelles.pages.parametres.VueParametres;
import serpents_echelles.pages.partie_locale.afficheurs.AfficheurPartie;
import serpents_echelles.pages.partie_locale.controleurs.ControleurPartie;
import serpents_echelles.pages.partie_locale.modeles.Joueur;
import serpents_echelles.pages.partie_locale.modeles.PartieLocale;
import serpents_echelles.pages.partie_locale.modeles.PartieLocaleLectureSeule;
import serpents_echelles.pages.partie_locale.vues.VuePartieLocale;

import java.io.IOException;
import java.util.Random;

public class ControleurAccueil extends ControleurVue<VueAccueil> {

    private Statistique statistique;
    private PartieLocale partieLocale;
    private Parametres parametres;

    private Scene sceneJeu;
    private Stage dialogueJeu;

    private Scene sceneStatsFinPartie;
    private Stage dialogueStatsFinPartie;

    private Scene sceneHistorique;
    private Stage dialogueHistorique;

    private Scene sceneParametres;
    private Stage dialogueParametres;

    private Random alea = new Random();

    @Override
    protected void demarrer() {
        try {
            instancierControleurJeu();
            instancierControleurParametres();
            instancierControleurHistorique();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void installerReceptionCommandes() {
        J.appel(this);

        /**
         * Fonction qui écoute pour la commande de quitter la page des statistiques fin
         * partie.
         */
        installerRecepteurCommande(QuitterStats.class, new RecepteurCommandeMVC<QuitterStatsRecue>() {

            @Override
            public void executerCommandeMVC(QuitterStatsRecue commande) {
                J.appel(this);

                quitterStatsFinPartie();
            }
        });

        /**
         * Fonction qui écoute pour la commande d'afficher les stats de fin de partie.
         */
        installerRecepteurCommande(AfficherStats.class, new RecepteurCommandeMVC<AfficherStatsRecue>() {

            @Override
            public void executerCommandeMVC(AfficherStatsRecue commande) {
                J.appel(this);

                ouvrirStatsFinPartie();
            }
        });

        /**
         * Fonction qui écoute pour la commande d'ouverture de la page de jeu.
         */
        installerRecepteurCommande(CommencerPartie.class, new RecepteurCommandeMVC<CommencerPartieRecue>() {
            @Override
            public void executerCommandeMVC(CommencerPartieRecue commande) {
                J.appel(this);

                ouvrirJeu();
            }
        });

        /**
         * Fonction qui écoute pour la commande d'ouvrir la page des paramètres.
         */
        installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
            @Override
            public void executerCommandeMVC(OuvrirParametresRecue commande) {
                J.appel(this);

                ouvrirParametres();
            }
        });

        /**
         * Fonction qui écoute pour la commande d'ouverture de la page d'historique.
         */
        installerRecepteurCommande(OuvrirHistorique.class, new RecepteurCommandeMVC<OuvrirHistoriqueRecue>() {
            @Override
            public void executerCommandeMVC(OuvrirHistoriqueRecue commande) {
                J.appel(this);

                ouvrirHistorique();
            }
        });

        /**
         * Fonction qui écoute pour la commande de fermer la page des paramètres.
         */
        installerRecepteurCommande(ConfirmerParametres.class, new RecepteurCommandeMVC<ConfirmerParametresRecue>() {
            @Override
            public void executerCommandeMVC(ConfirmerParametresRecue commande) {
                J.appel(this);

                fermerParametres();
            }
        });

        /**
         * Fonction qui écoute pour la commande de fermer la page d'historique
         */
        installerRecepteurCommande(FermerHistorique.class, new RecepteurCommandeMVC<FermerHistoriqueRecue>() {
            @Override
            public void executerCommandeMVC(FermerHistoriqueRecue commande) {
                J.appel(this);

                fermerHistorique();
            }
        });

        /**
         * Fonction qui écoute pour la commande de quitter la page d'acceuil, et donc
         * l'application.
         */
        installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
            @Override
            public void executerCommandeMVC(QuitterRecue commande) {
                J.appel(this);

                quitter();
            }
        });
    }

    @Override
    protected void installerReceptionMessages() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void obtenirMessagesPourEnvoi() {
        // TODO Auto-generated method stub

    }

    /**
     * Fonction qui ouvre la page de jeu.
     */
    private void ouvrirJeu() {
        J.appel(this);

        dialogueJeu = DialogueModal.ouvrirDialogueModal(sceneJeu);
    }

    /**
     * Fonction qui ouvre la page des paramètres.
     */
    private void ouvrirParametres() {
        J.appel(this);

        dialogueParametres = DialogueModal.ouvrirDialogueModal(sceneParametres);
    }

    /**
     * Fonction qui ouvre la page d'historique.
     */
    private void ouvrirHistorique() {
        J.appel(this);

        dialogueHistorique = DialogueModal.ouvrirDialogueModal(sceneHistorique);
    }

    /**
     * Fonction qui va ouvrir la page des statistiques de la partie jouées. Elle va
     * être appelée lorsqu'un joueur gagne.
     */
    private void ouvrirStatsFinPartie() {
        creerStatistiquesFinPartieSelonPartie();
        try {
            instancierControleurStatsFinPartie();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        dialogueStatsFinPartie = DialogueModal.ouvrirDialogueModal(sceneStatsFinPartie);
    }

    /**
     * Fonction qui va fermer la page des statistiques de fin de partie ainsi que
     * fermer la page de jeu.
     */
    private void quitterStatsFinPartie() {
        J.appel(this);

        if (dialogueStatsFinPartie != null && dialogueJeu != null) {
            dialogueJeu.close();
            dialogueStatsFinPartie.close();
        }
    }

    /**
     * Fonction qui va fermer la page des paramètres.
     */
    private void fermerParametres() {
        J.appel(this);

        if (dialogueParametres != null) {
            dialogueParametres.close();
        }
    }

    /**
     * Fonction qui va fermer la page d'historique des parties.
     */
    private void fermerHistorique() {
        J.appel(this);

        if (dialogueHistorique != null) {
            dialogueHistorique.close();
        }
    }

    /**
     * Fonction qui va quitter la page d'acceuil, et donc terminer le programme.
     */
    private void quitter() {
        J.appel(this);

        Systeme.quitter();
    }

    /**
     * TODO: Finir cette fonction.
     * 
     * Fonction qui va créer la partie selon les paramètres qui sont choisis dans la
     * page des paramètres.
     */
    private void creerPartieSelonParametres() {
        int tailleGrille = this.parametres.getTailleGrille();
        int nbJoueurs = this.parametres.getNbJoueur();

        CouleurPion[] pions = { CouleurPion.BLEU, CouleurPion.BLANC, CouleurPion.VERT, CouleurPion.ROUGE,
                CouleurPion.ORANGE, CouleurPion.JAUNE };

        this.partieLocale = EntrepotDeModeles.creerModele(PartieLocale.class, "defaut");
        // this.partieLocale.setTailleGrille(tailleGrille);

        for (int i = 0; i < nbJoueurs; i++) {
            this.partieLocale.ajouterJoueur(i, "Joueur" + (i + 1), pions[i]);
        }
    }

    /**
     * Fonction qui crée un nouveau modele Statistiques pour que la page
     * statistiques affiche les bonnes informations. Crée des joueurs de type Joueur
     * du modele statistique pour ensuite les inserer dans le modele statistique.
     */
    private void creerStatistiquesFinPartieSelonPartie() {
        this.statistique = EntrepotDeModeles.creerModele(Statistique.class, "test");

        for (Joueur joueur : this.partieLocale.getJoueurs()) {
            this.statistique.ajouterJoueur(joueur.getId(), joueur.getNom(), joueur.getAGagne(), 0, 0,
                    joueur.getPion().getNbSerpents(), joueur.getPion().getNbEchelles());
        }
    }

    private void instancierControleurStatsFinPartie() throws IOException {
        J.appel(this);

        ChargeurDeVue<VueFinPartie> chargeur;
        chargeur = new ChargeurDeVue<VueFinPartie>(
                serpents_echelles.pages.joueurGagnant.Constantes.CHEMIN_FINPARTIE_FXML);

        sceneStatsFinPartie = chargeur.nouvelleScene(serpents_echelles.pages.joueurGagnant.Constantes.LARGEUR_PIXELS,
                serpents_echelles.pages.joueurGagnant.Constantes.HAUTEUR_PIXELS);

        // String idModeleTest =
        // serpents_echelles.pages.joueurGagnant.Constantes.IDS_MODELES_TESTS[alea
        // .nextInt(serpents_echelles.pages.joueurGagnant.Constantes.IDS_MODELES_TESTS.length)];
        // Statistique statistique = EntrepotDeModeles.obtenirModele(Statistique.class,
        // idModeleTest);
        // Statistique statistique = EntrepotDeModeles.creerModele(Statistique.class,
        // "test");

        AfficheurFinPartie afficheurPartie = new AfficheurFinPartie();

        VueFinPartie vuePartie = chargeur.getVue();

        FabriqueControleur.creerControleur(ControleurFinPartie.class, statistique, vuePartie, afficheurPartie);
    }

    private void instancierControleurJeu() throws IOException {
        J.appel(this);

        ChargeurDeVue<VuePartieLocale> chargeur;
        chargeur = new ChargeurDeVue<VuePartieLocale>(
                serpents_echelles.pages.partie_locale.Constantes.CHEMIN_PARTIE_LOCALE_FXML);

        sceneJeu = chargeur.nouvelleScene(serpents_echelles.pages.partie_locale.Constantes.LARGEUR_PIXELS,
                serpents_echelles.pages.partie_locale.Constantes.HAUTEUR_PIXELS);
        sceneJeu.getStylesheets().add("/partie/style/style.css");

        String idModeleTest = serpents_echelles.pages.partie_locale.Constantes.IDS_MODELES_TESTS[alea
                .nextInt(serpents_echelles.pages.partie_locale.Constantes.IDS_MODELES_TESTS.length)];
        this.partieLocale = EntrepotDeModeles.obtenirModele(PartieLocale.class, idModeleTest);

        AfficheurPartie<PartieLocaleLectureSeule, VuePartieLocale> afficheurPartie = new AfficheurPartie<>();

        VuePartieLocale vuePartie = chargeur.getVue();

        FabriqueControleur.creerControleur(ControleurPartie.class, partieLocale, vuePartie, afficheurPartie);
    }

    private void instancierControleurParametres() throws IOException {
        J.appel(this);

        ChargeurDeVue<VueParametres> chargeur;
        chargeur = new ChargeurDeVue<VueParametres>(
                serpents_echelles.pages.parametres.Constantes.CHEMIN_PARAMETRES_FXML);

        sceneParametres = chargeur.nouvelleScene(serpents_echelles.pages.parametres.Constantes.LARGEUR_PIXELS,
                serpents_echelles.pages.parametres.Constantes.HAUTEUR_PIXELS);
        sceneParametres.getStylesheets().add("/parametres/style/style.css");

        String idModeleTest = serpents_echelles.pages.parametres.Constantes.IDS_MODELES_TESTS[alea
                .nextInt(serpents_echelles.pages.parametres.Constantes.IDS_MODELES_TESTS.length)];
        this.parametres = EntrepotDeModeles.obtenirModele(Parametres.class, idModeleTest);

        AfficheurParametres afficheurParametres = new AfficheurParametres();

        VueParametres vueParametres = chargeur.getVue();

        FabriqueControleur.creerControleur(ControleurParametres.class, parametres, vueParametres, afficheurParametres);
    }

    private void instancierControleurHistorique() throws IOException {
        J.appel(this);

        ChargeurDeVue<VueHistorique> chargeur;
        chargeur = new ChargeurDeVue<VueHistorique>(
                serpents_echelles.pages.historique_parties.Constantes.CHEMIN_HISTORIQUE_FXML);

        sceneHistorique = chargeur.nouvelleScene(serpents_echelles.pages.historique_parties.Constantes.LARGEUR_PIXELS,
                serpents_echelles.pages.historique_parties.Constantes.HAUTEUR_PIXELS);

        String idModeleTest = serpents_echelles.pages.historique_parties.Constantes.IDS_MODELES_TESTS[alea
                .nextInt(serpents_echelles.pages.historique_parties.Constantes.IDS_MODELES_TESTS.length)];
        Historique historique = EntrepotDeModeles.obtenirModele(Historique.class, idModeleTest);

        AfficheurHistorique afficheurHistorique = new AfficheurHistorique();

        VueHistorique vueHistorique = chargeur.getVue();

        FabriqueControleur.creerControleur(ControleurHistorique.class, historique, vueHistorique, afficheurHistorique);
    }
}