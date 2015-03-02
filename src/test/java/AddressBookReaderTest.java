import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AddressBookReaderTest extends TestCase {

    @Test
    public void testOpenFile() {
        AddressBookReader addressBookReader = new AddressBookReader();
        assertTrue(addressBookReader.getFile().exists());
    }

    @Test
    public void testGetAddressBookData() {
        AddressBookReader addressBookReader = new AddressBookReader();
        assertEquals(5, addressBookReader.getData().size());
    }



}