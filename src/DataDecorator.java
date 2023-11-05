import java.util.ArrayList;
import java.util.List;

interface DataObject {
    List<String> getData();
}

class BasicDataObject implements DataObject {
    private List<String> data;

    public BasicDataObject(List<String> data) {
        this.data = data;
    }

    @Override
    public List<String> getData() {
        return data;
    }
}

public abstract class DataDecorator implements DataObject {
    protected DataObject wrappedDataObject;

    public DataDecorator(DataObject data) {
        this.wrappedDataObject = data;
    }
}

class EncryptedDataDecorator extends DataDecorator {
    public EncryptedDataDecorator(DataObject data) {
        super(data);
    }

    @Override
    public List<String> getData() {
        // Simple code for example
        List<String> encryptedData = new ArrayList<>();
        for (String record : wrappedDataObject.getData()) {
            encryptedData.add(encrypt(record));
        }
        return encryptedData;
    }

    private String encrypt(String data) {
        // Just shifting the char to 1
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += 1;
        }
        return new String(chars);
    }
}
