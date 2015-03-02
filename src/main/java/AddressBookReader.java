import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by simon on 02/03/15.
 */
public class AddressBookReader {

    private static final String DATA_FILE = "/AddressBook";

    private AddressBookMapper mapper;

    public File getFile() {
        URL url = this.getClass().getResource(DATA_FILE);
        return new File(url.getFile());
    }

    public List getDataFromFile() {
        List<List<String>> data = new ArrayList<>();
        try {
            String line = "";
            BufferedReader file = new BufferedReader(new FileReader(getFile()));
            while((line = file.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(","));
                data.add(values);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return data;
    }
}
