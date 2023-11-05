import java.util.ArrayList;
import java.util.List;

public class DataAggregator {
    private List<FileReader> readers;

    public DataAggregator(List<FileReader> readers) {
        this.readers = readers;
    }

    public List<String> aggregateData() throws Exception {
        List<String> aggregatedData = new ArrayList<>();
        for (FileReader reader : readers) {
            aggregatedData.addAll(reader.readData());
        }
        return aggregatedData;
    }
}
