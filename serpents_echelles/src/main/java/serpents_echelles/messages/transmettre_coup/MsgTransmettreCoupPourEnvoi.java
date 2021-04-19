
package serpents_echelles.messages.transmettre_coup;

import ntro.messages.MessagePourEnvoi;

public interface MsgTransmettreCoupPourEnvoi extends MessagePourEnvoi {
	
	void setIndiceColonne(int indiceColonne);

}
