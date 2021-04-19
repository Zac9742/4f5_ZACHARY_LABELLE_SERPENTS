package serpents_echelles.pages.partie_locale.modeles;

import ntro.debogage.J;
import java.util.Random;

public class De implements DeLectureSeule {
    private int nombre;
    private Random alea;

    @Override
    public int getNombre() {
        J.appel(this);

        return this.nombre;
    }

    public void setNombre(int nombre) {
        J.appel(this);

        this.nombre = nombre;
    }

    /**
     * Fonction qui brasse le de en trouvant un nombre aleatoire entre
     * 1 et 6 inclusivement.
     */
    public void brasserDe() {
        int nbAlea = alea.nextInt((6 - 1) + 1) + 1;

        this.setNombre(nbAlea);
    }
}
