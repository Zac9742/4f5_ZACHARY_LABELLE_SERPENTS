
package serpents_echelles.commandes.choisir_taille_grille;

import ntro.commandes.Commande;
import ntro.debogage.J;

public class ChoisirTailleGrille extends Commande<ChoisirTailleGrillePourEnvoi, ChoisirTailleGrilleRecue>
		implements ChoisirTailleGrillePourEnvoi, ChoisirTailleGrilleRecue {

	private int tailleGrille;

	@Override
	public int getTailleGrille() {
		J.appel(this);

		return tailleGrille;
	}

	@Override
	public void setTailleGrille(int taille) {
		J.appel(this);

		this.tailleGrille = taille;
	}

}
