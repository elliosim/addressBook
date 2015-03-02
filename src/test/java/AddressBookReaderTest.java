import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressBookReaderTest {

    @Test
    public void testOpenFile() {
        AddressBookReader addressBookReader = new AddressBookReader();
        assertTrue(addressBookReader.getFile().exists());
    }

    @Test
    public void testGetAddressBookData() {
        AddressBookReader addressBookReader = new AddressBookReader();
        assertEquals(5, addressBookReader.getDataFromFile().size());
    }

}