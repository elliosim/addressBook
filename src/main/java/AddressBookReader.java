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

    public File getFile() {
        URL url = this.getClass().getResource(DATA_FILE);
        return new File(url.getFile());
    }

    public List getData() {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            String line = "";
            BufferedReader file = new BufferedReader(new FileReader(getFile()));
            while((line = file.readLine()) != null){
                List<String> values = Arrays.asList(line.split(","));
                data.add(values);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
