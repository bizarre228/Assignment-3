import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader txtReader = new TxtFileReader("src\\example.txt");
            FileReader csvReader = new CsvFileReader("src\\example2.csv");
            FileReader jsonReader = new JsonFileReader("src\\example3.json");

            DataAggregator aggregator = new DataAggregator(Arrays.asList(txtReader, csvReader, jsonReader));
            List<String> aggregatedData = aggregator.aggregateData();
            DataObject basicData = new BasicDataObject(aggregatedData);

            // Decorating the given data
            DataObject encryptedData = new EncryptedDataDecorator(basicData);

            OutputWriter writer = new OutputWriter();
            writer.writeData(basicData);
            writer.writeData(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class OutputWriter {
    public void writeData(DataObject data) {
        // Checking if the data is encrypted
        boolean isEncrypted = data instanceof EncryptedDataDecorator;
        
        List<String> processedData = data.getData();
        for (String record : processedData) {
            if (isEncrypted) {
                System.out.println("Encrypted Data: " + record);
            } else {
                System.out.println("Basic Data: " + record);
            }
        }
    }

}
