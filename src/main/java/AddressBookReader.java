import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public List<String> getDataFromFile() {
        List<String> list = new ArrayList<>();
        try {
            String line = "";
            BufferedReader file = new BufferedReader(new FileReader(getFile()));
            while((line = file.readLine()) != null) {
                list.add(line);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
