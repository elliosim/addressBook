import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AddressBookMapperTest {

    @Test
    public void testMapData() throws IOException {
        AddressBookMapper mapper = new AddressBookMapper();
        mapper.getEntries();
//        assertEquals(5, mapper.getEntries().size());
    }



}