import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by simon on 02/03/15.
 */
public class AddressBookMapper {

    public List<Person> mapAddressBook() throws IOException {

        AddressBookReader bookReader = new AddressBookReader();
        List<String> entries = bookReader.getDataFromFile();

        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.TRIM_SPACES);

        List<Person> personEntries = new ArrayList<>();
        for(String entry : entries) {
            Person person = mapper.reader(Person.class).with(getSchema()).readValue(entry);
            personEntries.add(person);
        }

        return personEntries;
    }

    private CsvSchema getSchema() {
        return CsvSchema.builder()
                .addColumn("name")
                .addColumn("sex")
                .addColumn("dob")
                .build()
                .withLineSeparator("\n");
    }
}
