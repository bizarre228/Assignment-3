import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface FileReader {
    List<String> readData() throws Exception;
}

class TxtFileReader implements FileReader {
    private String filePath;

    public TxtFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readData() throws Exception {
        // Reading lines to convert to the String
        return Files.readAllLines(Paths.get(filePath));
    }
}

class CsvFileReader implements FileReader {
    private String filePath;

    public CsvFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readData() throws Exception {
        // for CSV reading
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.asList(content.split("\\r?\\n"));
    }
}

class JsonFileReader implements FileReader {
    private String filePath;

    public JsonFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readData() throws Exception {
        // for JSON reading
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.asList(content.split("\\r?\\n"));
    }
}
