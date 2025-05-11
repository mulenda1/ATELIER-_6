package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ✅ Test de connexion à la base de données
        try (Connection conn = DatabaseManager.getConnection()) {
            System.out.println("✅ Connexion réussie à la base de données !");
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion à la base de données : " + e.getMessage());
            return; // Stoppe le programme si la connexion échoue
        }

        Scanner scanner = new Scanner(System.in);
        GestionChantiers gestion = new GestionChantiers();

        // 👉 Saisie des infos de l'admin
        System.out.print("Nom admin : ");
        String nomAdmin = scanner.nextLine();
        System.out.print("Post-Nom admin : ");
        String postNomAdmin = scanner.nextLine();
        System.out.print("Prénom admin : ");
        String prenomAdmin = scanner.nextLine();

        Admin admin = new Admin(nomAdmin, postNomAdmin, prenomAdmin);

        // === MENU PRINCIPAL ===
        boolean continuer = true;
        while (continuer) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Ajouter un ouvrier");
            System.out.println("2. Afficher les ouvriers");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    // 👉 Saisie des infos de l'ouvrier
                    System.out.println("Choisissez le type d’ouvrier : ");
                    System.out.println("1. Maçon\n2. Électricien\n3. Plombier\n4. Peintre");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Pour consommer le retour à la ligne

                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();

                    System.out.print("Post-Nom : ");
                    String postNom = scanner.nextLine();

                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();

                    System.out.print("Matricule : ");
                    String matricule = scanner.nextLine();

                    System.out.print("Salaire : ");
                    double salaire = scanner.nextDouble();
                    scanner.nextLine(); // Pour consommer le retour à la ligne

                    Ouvriers nouvelOuvrier = null;

                    switch (type) {
                        case 1:
                            nouvelOuvrier = new Macon(nom, postNom, prenom, matricule, salaire);
                            break;
                        case 2:
                            nouvelOuvrier = new Electricien(nom, postNom, prenom, matricule, salaire);
                            break;
                        case 3:
                            nouvelOuvrier = new Plombier(nom, postNom, prenom, matricule, salaire);
                            break;
                        case 4:
                            nouvelOuvrier = new Peintre(nom, postNom, prenom, matricule, salaire);
                            break;
                        default:
                            System.out.println("❌ Type d'ouvrier invalide.");
                    }

                    if (nouvelOuvrier != null) {
                        admin.ajouterOuvrier(gestion, nouvelOuvrier);
                        ActionLogger.logAction("Ajout d'un ouvrier", admin.getNomComplet(), nouvelOuvrier);
                        System.out.println("✅ Ouvrier ajouté et action enregistrée.");
                    }

                    break;

                case 2:
                    gestion.afficherOuvriers();
                    break;

                case 3:
                    continuer = false;
                    System.out.println("👋 Au revoir !");
                    break;

                default:
                    System.out.println("❌ Choix invalide.");
            }
        }

        scanner.close();
    }
}
