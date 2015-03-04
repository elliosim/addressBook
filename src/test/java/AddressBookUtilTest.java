import model.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AddressBookUtilTest {

    @Mock Person person1;
    @Mock Person person2;

    List<Person> addressBookEntries;

    AddressBookReader reader = new AddressBookReader();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        AddressBookMapper mapper = new AddressBookMapper();
        addressBookEntries = mapper.mapAddressBook(reader.getDataFromFile());
    }

    @Test
    public void testCountGender() throws Exception {
        AddressBookReader addressBook = new AddressBookReader();
        List<Person> entries = addressBook.getAddressBookEntries();
        assertEquals(3, AddressBookUtil.countGender("Male", entries));
    }

    @Test
    public void testGetEldest() throws Exception {
        assertEquals("Wes Jackson", AddressBookUtil.getEldest(addressBookEntries).getName());
    }

    @Test
    public void testGetPersonByName() throws Exception {
        Person person = AddressBookUtil.getPersonByName("Bill McKnight", addressBookEntries);
        assertEquals("Bill McKnight", person.getName());
        person = AddressBookUtil.getPersonByName("Gemma Lane", addressBookEntries);
        assertEquals("Gemma Lane", person.getName());
    }

    @Test
    public void testFindDaysDifference() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        when(person1.getDob()).thenReturn(sdf.parse("10/03/77"));
        when(person2.getDob()).thenReturn(sdf.parse("15/03/77"));

        assertEquals(5, AddressBookUtil.findDaysDifference(person1, person2));
    }

}
