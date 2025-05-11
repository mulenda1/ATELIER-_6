package org.example;

class Plombier extends Ouvriers {
    private double salairePlo;

    public Plombier(String nom, String postNom, String prenom, String matricule, double salairePlo) {
        super(nom, postNom, prenom, matricule);
        this.salairePlo = salairePlo;
    }

    @Override
    public double getSalaire() {
        return salairePlo;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Salaire Plombier: " + salairePlo);
    }
}