
package serpents_echelles.messages.transmettre_qui_commence;

import serpents_echelles.enumerations.Couleur;
import ntro.messages.MessageRecu;

public interface MsgTransmettreQuiCommenceRecu extends MessageRecu {
	
	Couleur getQuiCommence();

}
