package metiers;
import java.io.IOException;
public interface IFileReader{

    String readFileContent() throws IOException;

    void displayContent();

    void processFile();
}