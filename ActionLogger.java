package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionLogger {
    private static final String FILE_PATH = "actions_admin.json";

    public static void logAction(String action, String adminName, Ouvriers ouvrier) {
        if (ouvrier == null) {
            System.out.println("❌ Erreur: L'ouvrier est nul. L'action ne peut pas être enregistrée.");
            return;
        }

        JSONArray actionsArray = new JSONArray();

        // 🔄 Lire le fichier existant s’il existe
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(reader);
                actionsArray = (JSONArray) obj;
            } catch (IOException | ParseException e) {
                System.out.println("⚠️ Le fichier existe mais n’a pas pu être lu : " + e.getMessage());
            }
        } else {
            System.out.println("📁 Fichier non trouvé, un nouveau sera créé.");
        }

        // 📝 Création de l’objet action
        JSONObject log = new JSONObject();
        log.put("admin", adminName);
        log.put("action", action);
        log.put("timestamp", getCurrentTimestamp());

        .put("ouvrier", ouvrier.toJson());


        actionsArray.add(log);


        saveToFile(actionsArray);
    }

    private static void saveToFile(JSONArray actionsArray) {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(actionsArray.toJSONString());
            file.flush();
            System.out.println("✅ Les actions ont été enregistrées dans le fichier.");
        } catch (IOException e) {
            System.err.println("❌ Erreur lors de la sauvegarde du fichier : " + e.getMessage());
        }
    }

    private static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
