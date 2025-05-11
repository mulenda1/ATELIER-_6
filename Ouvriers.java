package org.example;

import org.json.JSONObject;

public abstract class Ouvriers extends Personne {
    protected String matricule;
    protected String nom;
    protected String postNom;
    protected String prenom;

    public Ouvriers(String nom, String postNom, String prenom, String matricule) {
        super(nom, postNom, prenom);
        this.matricule = matricule;
        this.nom = nom;
        this.postNom = postNom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPostNom() {
        return postNom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public abstract double getSalaire();
    public void afficherInfos() {
        System.out.println("Nom: " + nom);
        System.out.println("PostNom: " + postNom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Matricule: " + matricule);
    }


    public JSONObject toJson() {
        JSONObject obj = new org.example.JSONObject();
        obj.put("nom", this.nom);
        obj.put("postNom", this.postNom);
        obj.put("prenom", this.prenom);
        obj.put("matricule", this.matricule);
        obj.put("salaire", this.getSalaire()); // Appelle la méthode implémentée dans la sous-classe
        obj.put("type", this.getClass().getSimpleName());
        return obj;
    }
}
