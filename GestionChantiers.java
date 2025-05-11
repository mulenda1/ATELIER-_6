package org.example;

import java.util.ArrayList;
import java.util.List;

public class GestionChantiers {
    private List<Ouvriers> listeOuvriers = new ArrayList<>();

    public void ajouterOuvrier(Ouvriers ouvrier) {
        listeOuvriers.add(ouvrier);
        DatabaseManager.ajouterOuvrier(ouvrier);
    }

    public void afficherOuvriers() {
        DatabaseManager.afficherOuvriers();
    }

    public void supprimerOuvrier(String matricule) {
        DatabaseManager.supprimerOuvrier(matricule);
    }

    public void mettreAJourOuvrier(Ouvriers ouvrier) {
        DatabaseManager.mettreAJourOuvrier(ouvrier);
    }
}
