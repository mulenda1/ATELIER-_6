package org.example;

public class Personne {
    protected String nom;
    protected String postNom;
    protected String prenom;

    public Personne(String nom, String postNom, String prenom) {
        this.nom = nom;
        this.postNom = postNom;
        this.prenom = prenom;
    }

    public void afficherInfos() {
        System.out.println("Nom: " + nom + ", Post-Nom: " + postNom + ", Prénom: " + prenom);
    }
}
