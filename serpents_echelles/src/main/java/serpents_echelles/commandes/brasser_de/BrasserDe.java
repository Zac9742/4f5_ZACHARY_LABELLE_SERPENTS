package serpents_echelles.commandes.brasser_de;

import ntro.commandes.Commande;

public class BrasserDe extends Commande<BrasserDePourEnvoi, BrasserDeRecu>
        implements BrasserDePourEnvoi, BrasserDeRecu {

    private int nombreDe;

    @Override
    public int getNombre() {
        return this.nombreDe;
    }

    @Override
    public void setNombre(int nombre) {
        this.nombreDe = nombre;
    }

}
