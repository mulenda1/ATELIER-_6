package org.example;

import java.sql.*;

public class DatabaseManager {
    // Utilisation de l'authentification Windows (Integrated Security)
    private static final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Atelier6;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"
            + "integratedSecurity=true";

    // Plus besoin de USER et PASSWORD

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Atelier6;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        return DriverManager.getConnection(URL);
    }

    public static void ajouterOuvrier(Ouvriers ouvrier) {
        String sql = "INSERT INTO Ouvriers (nom, post_nom, prenom, matricule, salaire, type) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ouvrier.getNom());
            stmt.setString(2, ouvrier.getPostNom());
            stmt.setString(3, ouvrier.getPrenom());
            stmt.setString(4, ouvrier.getMatricule());
            stmt.setDouble(5, ouvrier.getSalaire());
            stmt.setString(6, ouvrier.getClass().getSimpleName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void afficherOuvriers() {
        String sql = "SELECT * FROM Ouvriers";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Nom: " + rs.getString("nom"));
                System.out.println("Post-Nom: " + rs.getString("post_nom"));
                System.out.println("Prénom: " + rs.getString("prenom"));
                System.out.println("Matricule: " + rs.getString("matricule"));
                System.out.println("Salaire: " + rs.getDouble("salaire"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerOuvrier(String matricule) {
        String sql = "DELETE FROM Ouvriers WHERE matricule = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, matricule);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mettreAJourOuvrier(Ouvriers ouvrier) {
        String sql = "UPDATE Ouvriers SET nom = ?, post_nom = ?, prenom = ?, salaire = ?, type = ? WHERE matricule = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ouvrier.getNom());
            stmt.setString(2, ouvrier.getPostNom());
            stmt.setString(3, ouvrier.getPrenom());
            stmt.setDouble(4, ouvrier.getSalaire());
            stmt.setString(5, ouvrier.getClass().getSimpleName());
            stmt.setString(6, ouvrier.getMatricule());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
