
package serpents_echelles.messages.transmettre_taille;

import serpents_echelles.enumerations.TailleGrille;
import ntro.messages.MessagePourEnvoi;

public interface MsgTransmettreTaillePourEnvoi extends MessagePourEnvoi {
	
	void setTailleGrille(TailleGrille tailleGrille);

}
