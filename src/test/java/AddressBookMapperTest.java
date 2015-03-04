import model.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressBookMapperTest {

    AddressBookReader reader = new AddressBookReader();

    List<Person> addressBookEntries;
    AddressBookMapper mapper = new AddressBookMapper();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        addressBookEntries = mapper.mapAddressBook(reader.getDataFromFile());
    }

    @Test
    public void testMapAllEntries() throws IOException {
        assertEquals(5, mapper.mapAddressBook(reader.getDataFromFile()).size());
    }

    @Test
    public void testPersonIsMapped() throws IOException {
        Person person = addressBookEntries.get(0);
        assertEquals("Bill McKnight", person.getName());
    }

}