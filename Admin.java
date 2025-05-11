package org.example;

public class Admin {
    private String nom;
    private String postNom;
    private String prenom;

    // Constructeur
    public Admin(String nom, String postNom, String prenom) {
        this.nom = nom;
        this.postNom = postNom;
        this.prenom = prenom;
    }

    public String getNomComplet() {
        return nom + " " + postNom + " " + prenom;
    }

    // ✅ Cette méthode délègue à GestionChantiers (qui utilise DatabaseManager)
    public void ajouterOuvrier(GestionChantiers gestion, Ouvriers ouvrier) {
        gestion.ajouterOuvrier(ouvrier);
    }
}
