import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.Person;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by simon on 02/03/15.
 */
public class AddressBookMapper {

    public List getEntries() throws IOException {

        AddressBookReader bookReader = new AddressBookReader();

        CsvMapper mapper = new CsvMapper();
        MappingIterator<Map<String,String>> it = mapper.reader(Map.class)
                .with(getSchema())
                .readValues(bookReader.getFile());

        while (it.hasNext()) {
            Map<String,String> rowAsMap = it.next();
            System.out.println(rowAsMap);
        }

        return null;
    }

    private CsvSchema getSchema() {
        return CsvSchema.builder()
                .addColumn("name")
                .addColumn("age", CsvSchema.ColumnType.NUMBER)
                .addColumn("dob")
                .build();
    }
}
