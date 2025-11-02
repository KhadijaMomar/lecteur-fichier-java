package metiers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextFileReader extends AbstractFileReader {

    public TextFileReader(String filePath) {
        super(filePath);
    }

    /**
     * Affiche le contenu du fichier texte ligne par ligne à l'envers.
     */
    public void displayContentReversedLines() {
        System.out.println("--- Contenu à l'envers (lignes) ---");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            Collections.reverse(lines);
            lines.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Erreur lors de l'affichage inversé : " + e.getMessage());
        }
    }

    /**
     * Affiche le contenu de manière palindromique  */
    public void displayContentPalindromic() {
        System.out.println("--- Contenu palindromique (caractères) ---");
        try {
            String content = readFileContent(); 
            String reversedContent = new StringBuilder(content).reverse().toString();
            System.out.println(reversedContent);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'affichage palindromique : " + e.getMessage());
        }
    }

    @Override
    public void processFile() {
        System.out.println("Traitement spécifique au fichier texte : Exécution des affichages spécifiques.");
        displayContent();              
        displayContentReversedLines();
        displayContentPalindromic();   
    }
}
