import model.Person;

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

    AddressBookMapper mapper = new AddressBookMapper();
    private String eldest;

    public static void main(String[] args) {

        AddressBookReader reader = new AddressBookReader();

        // How many males are in the address book?
        System.out.println("There are " + reader.countGender("Male") + " Male entries in the address book.");

        // Who is the oldest person in the address book?



        // How many days older is Bill than Paul?
    }


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

    public int countGender(String male) {
        List<Person> addressBookEntries = mapper.mapAddressBook(getDataFromFile());
        int genderCount = 0;
        for(Person person : addressBookEntries) {
            if("Male".equals(person.getGender())) {
                genderCount++;
            }
        }
        return genderCount;
    }


}
