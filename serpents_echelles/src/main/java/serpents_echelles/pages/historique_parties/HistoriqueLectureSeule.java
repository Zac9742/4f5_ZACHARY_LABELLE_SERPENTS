package serpents_echelles.pages.historique_parties;

import java.util.List;

import ntro.mvc.modeles.ModeleLectureSeule;

public interface HistoriqueLectureSeule extends ModeleLectureSeule{

	int getnbPartieArchive();
	List<PartieArchive> getpartieArchive();
}