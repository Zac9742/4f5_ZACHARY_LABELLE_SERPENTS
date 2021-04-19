
package serpents_echelles.pages.partie_locale.controleurs;

import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import serpents_echelles.commandes.brasser_de.BrasserDeRecu;
import serpents_echelles.pages.partie_locale.afficheurs.AfficheurPartieReseau;
import serpents_echelles.pages.partie_locale.modeles.PartieReseau;
import serpents_echelles.pages.partie_locale.modeles.PartieReseauLectureSeule;
import serpents_echelles.pages.partie_locale.vues.VuePartieReseau;
import serpents_echelles.messages.transmettre_coup.MsgTransmettreCoup;
import serpents_echelles.messages.transmettre_coup.MsgTransmettreCoupPourEnvoi;
import serpents_echelles.messages.transmettre_coup.MsgTransmettreCoupRecu;

public class ControleurPartieReseau

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        VuePartieReseau, 
                        AfficheurPartieReseau> {
	
	private MsgTransmettreCoupPourEnvoi transmettreCoup;
	

	@Override
	protected void obtenirMessagesPourEnvoi() {
		super.obtenirMessagesPourEnvoi();
		J.appel(this);
		
		transmettreCoup = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreCoup.class);
	}

	@Override
	protected void installerReceptionMessages() {
		super.installerReceptionMessages();
		J.appel(this);
		
		installerRecepteurMessage(MsgTransmettreCoup.class, new RecepteurMessageMVC<MsgTransmettreCoupRecu>() {

			@Override
			public void recevoirMessageMVC(MsgTransmettreCoupRecu messageRecu) {
				J.appel(this);
				
				getModele().effectuerCoup(messageRecu.getIndiceColonne());
			}
		});
	}
	
	@Override
	protected void reagirCommandeBrasserDe(BrasserDeRecu brasserDeRecue) {
		super.reagirCommandeBrasserDe(brasserDeRecue);
		J.appel(this);
		
		transmettreCoup.setIndiceColonne(brasserDeRecue.getNombre());
		transmettreCoup.envoyerMessage();
	}
}
