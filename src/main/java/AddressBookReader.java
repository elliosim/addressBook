import model.Person;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 02/03/15.
 */
public class AddressBookReader {

    private static final String DATA_FILE = "/AddressBook";

    AddressBookMapper mapper = new AddressBookMapper();

    public static void main(String[] args) {

        AddressBookReader addressBook = new AddressBookReader();

        // How many males are in the address book?
        List<Person> entries = addressBook.getAddressBookEntries();
        System.out.println("There are " + AddressBookUtil.countGender("Male", entries) + " Male entries in the address book.");

        // Who is the oldest person in the address book?
        System.out.println("The oldest person is " + AddressBookUtil.getEldest(entries).getName());

        // How many days older is Bill than Paul?
        Person bill = AddressBookUtil.getPersonByName("Bill McKnight", entries);
        Person paul = AddressBookUtil.getPersonByName("Paul Robinson", entries);
        long days = AddressBookUtil.findDaysDifference(bill, paul);
        System.out.println("Bill is " + days + " days older than Paul");
    }


    public File getFile() {
        URL url = this.getClass().getResource(DATA_FILE);
        return new File(url.getFile());
    }

    public List<Person> getAddressBookEntries() {
        return mapper.mapAddressBook(getDataFromFile());
    }

    public List<String> getDataFromFile() {
        List<String> list = new ArrayList<String>();
        try {
            String line;
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
