package metiers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvFileReader extends AbstractFileReader {
    
    // Délimiteur par défaut (virgule pour CSV)
    private static final String DELIMITER = ",";

    public CsvFileReader(String filePath) {
        super(filePath);
    }

    /**
     * @return Une liste de tableaux de chaînes (List<String[]>), représentant les lignes et les champs.
     */
    private List<String[]> parseCsvContent() throws IOException {
      
        String content = readFileContent();
        List<String[]> records = new ArrayList<>();
        
       
        String[] lines = content.split(System.lineSeparator());
        
        for (String line : lines) {
            // Ignorer les lignes vides
            if (!line.trim().isEmpty()) {
                // 3. Séparer chaque ligne par le délimiteur (la virgule)
             
                String[] fields = line.split(DELIMITER);
                records.add(fields);
            }
        }
        return records;
    }

  
    @Override
    public void processFile() {
        System.out.println("\n--- Traitement spécifique au fichier CSV (Analyse) ---");
        try {
            // Parse les données du fichier
            List<String[]> data = parseCsvContent();
            
            if (data.isEmpty()) {
                System.out.println("Le fichier CSV est vide ou n'a pu être parsé.");
                return;
            }

            // --- Affichage des informations ---

            // 1. Afficher les en-têtes (si la première ligne est présente)
            String[] headers = data.get(0);
            System.out.println("Structure (nombre de colonnes) : " + headers.length + " colonnes.");
            System.out.println("En-têtes détectées : " + String.join(" | ", headers));
            
            // 2. Afficher des statistiques et un échantillon
            int totalRecords = data.size();
            System.out.println("Nombre total de lignes (enregistrements) : " + totalRecords);
            
            // Afficher le premier enregistrement (si le fichier en contient)
            if (totalRecords > 1) {
                 String[] firstRecord = data.get(1);
                 System.out.println("Premier enregistrement de données : " + String.join(" | ", firstRecord));
            } else {
                 System.out.println("Aucun enregistrement de données trouvé après les en-têtes.");
            }


        } catch (IOException e) {
            System.err.println("Erreur lors du traitement CSV : " + e.getMessage());
        }
    }
}