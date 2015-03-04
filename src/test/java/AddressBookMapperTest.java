import model.Person;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressBookMapperTest {

    @Test
    public void testMapAllEntries() throws IOException {
        AddressBookMapper mapper = new AddressBookMapper();
        assertEquals(5, mapper.mapAddressBook().size());
    }

    @Test
    public void testPersonIsMapped() throws IOException {
        AddressBookMapper mapper = new AddressBookMapper();
        List<Person> addressBookEntries = mapper.mapAddressBook();
        Person person = addressBookEntries.get(0);
        assertEquals("Bill McKnight", person.getName());
    }



}