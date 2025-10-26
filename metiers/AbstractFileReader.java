import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public abstract class AbstractFileReader implements IFileReader {
    protected String filePath;
    protected String fileContent;

    public AbstractFileReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Lecture du fichier ligne par ligne avec BufferedReader.
     * Stocke le résultat complet dans fileContent.
     */
    @Override
    public String readFileContent() throws IOException {
        if (fileContent == null) {
            StringBuilder sb = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line).append(System.lineSeparator());
                }
            }

            fileContent = sb.toString(); // Mise en cache du contenu
        }
        return fileContent;
    }

    /**
     * Affichage standard du contenu du fichier (à l'endroit).
     */
    @Override
    public void displayContent() {
        System.out.println("--- Contenu du fichier (" + this.getClass().getSimpleName() + ") ---");
        try {
            System.out.println(readFileContent());
        } catch (IOException e) {
            System.err.println("Erreur lors de l'affichage du contenu : " + e.getMessage());
        }
    }

    /**
     * Compare le contenu complet de deux fichiers.
     */
    public boolean compareFiles(AbstractFileReader other) {
        try {
            String content1 = this.readFileContent();
            String content2 = other.readFileContent();
            return content1.equals(content2);
        } catch (IOException e) {
            System.err.println("Erreur lors de la comparaison des fichiers : " + e.getMessage());
            return false;
        }
    }
    
    // La méthode abstract processFile() de l'interface doit être implémentée par les sous-classes.
}
