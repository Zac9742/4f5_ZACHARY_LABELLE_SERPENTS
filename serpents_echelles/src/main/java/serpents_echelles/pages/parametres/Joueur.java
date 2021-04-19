package serpents_echelles.pages.parametres;

import serpents_echelles.enumerations.Couleur;

public class Joueur implements JoueurLectureSeule {

	private Couleur couleur;
	private String nomJoueur;
	// private int idJoueur;

	@Override
	public Couleur getCouleur() {

		return couleur;
	}

	@Override
	public String getNom() {
		return nomJoueur;

	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;

	}

	public void setNom(String nom) {
		this.nomJoueur = nom;

	}

}
