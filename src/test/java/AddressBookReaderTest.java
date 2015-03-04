import org.junit.Test;

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
        assertEquals(3, reader.countGender("Male"));
    }



}