
package serpents_echelles.messages.transmettre_taille;

import serpents_echelles.enumerations.TailleGrille;
import ntro.messages.MessageRecu;

public interface MsgTransmettreTailleRecu extends MessageRecu {
	
	TailleGrille getTailleGrille();

}
