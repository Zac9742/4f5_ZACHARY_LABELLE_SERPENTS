
package serpents_echelles.messages.transmettre_taille;

import serpents_echelles.enumerations.TailleGrille;
import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreTaille extends Message<MsgTransmettreTaillePourEnvoi, 
                                             MsgTransmettreTailleRecu>

					         implements MsgTransmettreTaillePourEnvoi, 
					                    MsgTransmettreTailleRecu {
	
	private TailleGrille tailleGrille;

	@Override
	public TailleGrille getTailleGrille() {
		J.appel(this);

		return tailleGrille;
	}

	@Override
	public void setTailleGrille(TailleGrille tailleGrille) {
		J.appel(this);
		
		this.tailleGrille = tailleGrille;
	}
}
