import model.Person;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by simon on 02/03/15.
 *
 * TODO Refactor and extract an AddressBook model
 */
public class AddressBookReader {

    private static final String DATA_FILE = "/AddressBook";

    AddressBookMapper mapper = new AddressBookMapper();

    public static void main(String[] args) {

        AddressBookReader addressBook = new AddressBookReader();

        // How many males are in the address book?
        System.out.println("There are " + addressBook.countGender("Male") + " Male entries in the address book.");

        // Who is the oldest person in the address book?
        System.out.println("The oldest person is " + addressBook.getEldest().getName());

        // How many days older is Bill than Paul?
        Person bill = addressBook.getPersonByName("Bill McKnight");
        Person paul = addressBook.getPersonByName("Paul Robinson");
        long days = addressBook.findDaysDifference(bill, paul);
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

    public int countGender(String gender) {
        int genderCount = 0;
        for(Person person : getAddressBookEntries()) {
            if(gender.equals(person.getGender())) {
                genderCount++;
            }
        }
        return genderCount;
    }

    public Person getEldest() {
        List<Person> addressBookEntries = getAddressBookEntries();
        Person eldestPerson = null;
        for(Person person : addressBookEntries) {
            if(eldestPerson == null) {
                eldestPerson = person;
                continue;
            }
            if(person.getDob().compareTo(eldestPerson.getDob())<0) {
                eldestPerson = person;
            }

        }
        return eldestPerson;
    }

    public Person getPersonByName(String name) {
        for(Person person : getAddressBookEntries()) {
            if(name.equals(person.getName())) {
                return person;
            }
        }
        return null;
    }

    public long findDaysDifference(Person person1, Person person2) {
        long diffMillis = person2.getDob().getTime() - person1.getDob().getTime();
        return TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
    }
}
