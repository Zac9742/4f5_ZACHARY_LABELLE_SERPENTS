
package serpents_echelles.commandes.choisir_nbr_joueur;

import ntro.commandes.Commande;
import ntro.debogage.J;

public class ChoisirNbrJoueur extends Commande<ChoisirNbrJoueurPourEnvoi, ChoisirNbrJoueurRecue>
		implements ChoisirNbrJoueurPourEnvoi, ChoisirNbrJoueurRecue {

	private int nbrJoueur;

	@Override
	public int getNbrJoueur() {
		J.appel(this);

		return nbrJoueur;
	}

	@Override
	public void setNbrJoueur(int nbrJoueur) {
		J.appel(this);

		this.nbrJoueur = nbrJoueur;
	}

}
