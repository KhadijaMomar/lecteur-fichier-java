package application;

import metiers.TextFileReader;
import metiers.CsvFileReader;
import metiers.JsonFileReader; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderApp {

    // Définition de chemins distincts pour les différents types de fichiers
    private static final String TEST_TEXT_PATH = "demo_text_file.txt";
    private static final String TEST_CSV_PATH = "demo_data_file.csv";
    private static final String TEST_JSON_PATH = "demo_config_file.json";

    // Fichier pour la démonstration de la comparaison
    private static final String TEST_COMPARISON_PATH = "demo_text_compare.txt";

    /**
     * Crée des fichiers de test temporaires avec des contenus appropriés.
     */
    private static void setupTestFiles() {
        try {
            // Contenu pour le fichier texte (TEST_TEXT_PATH)
            String textContent = "Je suis étudiante en licence professionnelle\nProjet Web et Mobile 2\nBonjour le monde!";
            Files.write(Paths.get(TEST_TEXT_PATH), textContent.getBytes());
            
            // Contenu pour le fichier CSV (TEST_CSV_PATH)
            String csvContent = "Nom,Âge,Ville\nAlice,30,Paris\nBob,24,Lyon\nClaire,42,Marseille";
            Files.write(Paths.get(TEST_CSV_PATH), csvContent.getBytes());
            
            // Contenu pour le fichier JSON (TEST_JSON_PATH)
            String jsonContent = "{\n  \"projet\": \"Lecture de Fichiers\",\n  \"version\": 1.0,\n  \"auteur\": \"Étudiant\"\n}";
            Files.write(Paths.get(TEST_JSON_PATH), jsonContent.getBytes());
            
            // Contenu légèrement différent pour le fichier de comparaison
            String compareContent = "Je suis étudiante en licence professionnelle\nProjet Web et Mobile 2\nA la Sorbonne Université";
            Files.write(Paths.get(TEST_COMPARISON_PATH), compareContent.getBytes());


            System.out.println("✅ Fichiers de test créés : " + TEST_TEXT_PATH + ", " + TEST_CSV_PATH + ", " + TEST_JSON_PATH + " et " + TEST_COMPARISON_PATH);
        } catch (IOException e) {
            System.err.println("Impossible de créer les fichiers de test. Veuillez vérifier les permissions.");
        }
    }

    
    public static void main(String[] args) {
        setupTestFiles();

        // 1. DÉMONSTRATION DU LECTEUR TEXTE
        System.out.println("\n===== DÉMONSTRATION 1 : LECTEUR TEXTE (TextFileReader) =====");
        TextFileReader textReader = new TextFileReader(TEST_TEXT_PATH);
        textReader.processFile(); 

        // 2. DÉMONSTRATION DE L'EXTENSIBILITÉ (CSV)
        System.out.println("\n===== DÉMONSTRATION 2 : LECTEUR CSV (CsvFileReader) =====");
        CsvFileReader csvReader = new CsvFileReader(TEST_CSV_PATH);
        csvReader.processFile(); 

        // 3. DÉMONSTRATION DE L'EXTENSIBILITÉ (JSON)
        System.out.println("\n===== DÉMONSTRATION 3 : LECTEUR JSON (JsonFileReader) =====");
        JsonFileReader jsonReader = new JsonFileReader(TEST_JSON_PATH);
        jsonReader.processFile(); 

        // 4. DÉMONSTRATION DE LA COMPARAISON
        System.out.println("\n===== DÉMONSTRATION 4 : COMPARAISON DE FICHIERS =====");
        
        TextFileReader textReaderA = new TextFileReader(TEST_TEXT_PATH);
        TextFileReader textReaderB = new TextFileReader(TEST_COMPARISON_PATH);

        boolean areEqual = textReaderA.compareFiles(textReaderB);
        
        System.out.println("Comparaison des fichiers " + TEST_TEXT_PATH + " et " + TEST_COMPARISON_PATH + " :");
        String resultMessage = areEqual 
            ? "✅ OUI - Les deux fichiers sont identiques" 
            : "❌ NON - Les deux fichiers ne sont pas identiques";
        System.out.println("➡️ Résultat : " + resultMessage);

        // Nettoyage des fichiers
        System.out.println("\n===== NETTOYAGE DES FICHIERS DE TEST =====");
        try {
            Files.deleteIfExists(Paths.get(TEST_TEXT_PATH));
            Files.deleteIfExists(Paths.get(TEST_CSV_PATH));
            Files.deleteIfExists(Paths.get(TEST_JSON_PATH));
            Files.deleteIfExists(Paths.get(TEST_COMPARISON_PATH));
            System.out.println("Fichiers de test temporaires supprimés.");
        } catch (IOException ignored) {}
    }
}