import model.Person;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressBookReaderTest {

    AddressBookReader reader = new AddressBookReader();

    @Test
    public void testOpenFile() {
        assertTrue(reader.getFile().exists());
    }

    @Test
    public void testGetAddressBookData() {
        assertEquals(5, reader.getDataFromFile().size());
    }

    @Test
    public void testCountGenderOfAllEntries() {
        AddressBookReader addressBook = new AddressBookReader();
        List<Person> entries = addressBook.getAddressBookEntries();
        assertEquals(3, AddressBookUtil.countGender("Male", entries));
    }
}