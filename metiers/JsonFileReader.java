package metiers;

import java.io.IOException;

public class JsonFileReader extends AbstractFileReader {
    
    public JsonFileReader(String filePath) {
        super(filePath);
    }

    /**
     * @param content Le contenu brut du fichier.
     * @return true si le contenu semble être du JSON valide 
     */
    private boolean isBasicJsonStructureValid(String content) {
        if (content == null || content.trim().isEmpty()) {
            return false;
        }
        String trimmed = content.trim();
        
        // Vérifie si le contenu commence par '{' et se termine par '}' (objet JSON)
        boolean isObject = trimmed.startsWith("{") && trimmed.endsWith("}");
        
        // Ou s'il commence par '[' et se termine par ']' (tableau JSON)
        boolean isArray = trimmed.startsWith("[") && trimmed.endsWith("]");
        
        return isObject || isArray;
    }

    /**
     * Tente de valider la structure et affiche le début du contenu pour aperçu.
     */
    @Override
    public void processFile() {
        System.out.println("\n--- Traitement spécifique au fichier JSON (Validation) ---");
        try {
            // 1. Obtient le contenu complet du fichier
            String content = readFileContent();
            
            // 2. Validation de la structure
            if (isBasicJsonStructureValid(content)) {
                System.out.println("✅ Structure JSON de base (Objet ou Tableau) détectée.");
            } else {
                System.out.println("❌ Le contenu ne correspond pas à une structure JSON de base valide.");
            }

            // 3. Affichage d'un aperçu
            int maxLength = Math.min(content.length(), 150);
            String preview = content.substring(0, maxLength);
            
            System.out.println("Aperçu du contenu JSON (" + maxLength + " premiers caractères) :");
            System.out.println("------------------------------------");
            System.out.println(preview + (content.length() > maxLength ? "..." : ""));
            System.out.println("------------------------------------");

           
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
        }
    }
}