
package serpents_echelles.messages.transmettre_qui_commence;

import serpents_echelles.enumerations.Couleur;
import ntro.messages.MessagePourEnvoi;

public interface MsgTransmettreQuiCommencePourEnvoi extends MessagePourEnvoi {
	
	void setQuiCommence(Couleur quiCommence);

}
