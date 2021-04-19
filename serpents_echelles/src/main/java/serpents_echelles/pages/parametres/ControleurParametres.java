// Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of tutoriels4f5
//
// tutoriels4f5 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// tutoriels4f5 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>

package serpents_echelles.pages.parametres;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import serpents_echelles.commandes.choisir_nbr_joueur.ChoisirNbrJoueur;
import serpents_echelles.commandes.choisir_nbr_joueur.ChoisirNbrJoueurRecue;
import serpents_echelles.commandes.choisir_qui_commence.ChoisirQuiCommence;
import serpents_echelles.commandes.choisir_qui_commence.ChoisirQuiCommenceRecue;
import serpents_echelles.commandes.choisir_taille_grille.ChoisirTailleGrille;
import serpents_echelles.commandes.choisir_taille_grille.ChoisirTailleGrilleRecue;
import serpents_echelles.enumerations.Couleur;

public class ControleurParametres
		extends ControleurModeleVue<ParametresLectureSeule, Parametres, VueParametres, AfficheurParametres> {

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(ChoisirQuiCommence.class, new RecepteurCommandeMVC<ChoisirQuiCommenceRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirQuiCommenceRecue commande) {
				J.appel(this);

				Couleur quiCommence = commande.getCouleur();

				DoitEtre.nonNul(quiCommence);

				getModele().choisirQuiCommence(quiCommence);
			}
		});

		installerRecepteurCommande(ChoisirTailleGrille.class, new RecepteurCommandeMVC<ChoisirTailleGrilleRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirTailleGrilleRecue commande) {
				J.appel(this);

				int tailleGrille = commande.getTailleGrille();

				DoitEtre.nonNul(tailleGrille);

				getModele().choisirTailleGrille(tailleGrille);
			}
		});

		installerRecepteurCommande(ChoisirNbrJoueur.class, new RecepteurCommandeMVC<ChoisirNbrJoueurRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirNbrJoueurRecue commande) {
				J.appel(this);

				int nbrJoueur = commande.getNbrJoueur();

				DoitEtre.nonNul(nbrJoueur);

				getModele().choisirTailleGrille(nbrJoueur);
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}
}