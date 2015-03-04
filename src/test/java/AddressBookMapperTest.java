import model.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AddressBookMapperTest {

    AddressBookReader reader = new AddressBookReader();

    @Mock Person person1;
    @Mock Person person2;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMapAllEntries() throws IOException {
        AddressBookMapper mapper = new AddressBookMapper();
        assertEquals(5, mapper.mapAddressBook(reader.getDataFromFile()).size());
    }

    @Test
    public void testPersonIsMapped() throws IOException {
        AddressBookMapper mapper = new AddressBookMapper();
        List<Person> addressBookEntries = mapper.mapAddressBook(reader.getDataFromFile());
        Person person = addressBookEntries.get(0);
        assertEquals("Bill McKnight", person.getName());
    }

    @Test
    public void testFindEldest() {
        assertEquals("Wes Jackson", reader.getEldest().getName());
    }

    @Test
    public void testFindDaysOlder() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        when(person1.getDob()).thenReturn(sdf.parse("10/03/77"));
        when(person2.getDob()).thenReturn(sdf.parse("15/03/77"));

        assertEquals(5, reader.findDaysDifference(person1, person2));
    }

    @Test
    public void testGetPersonByName() {
        Person person = reader.getPersonByName("Bill McKnight");
        assertEquals("Bill McKnight", person.getName());
        person = reader.getPersonByName("Gemma Lane");
        assertEquals("Gemma Lane", person.getName());
    }

}