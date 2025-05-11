package org.example;

public class Macon extends Ouvriers {
    private double salaire;

    public Macon(String nom, String postNom, String prenom, String matricule, double salaire) {
        super(nom, postNom, prenom, matricule);
        this.salaire = salaire;
    }

    @Override
    public double getSalaire() {
        return salaire;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Matricule: " + matricule);
        System.out.println("Salaire Maçon: " + salaire);
    }
}