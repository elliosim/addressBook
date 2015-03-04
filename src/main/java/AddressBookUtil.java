import model.Person;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddressBookUtil {

    public static int countGender(String gender, List<Person> entries) {
        int genderCount = 0;
        for(Person person : entries) {
            if(gender.equals(person.getGender())) {
                genderCount++;
            }
        }
        return genderCount;
    }

    public static Person getEldest(List<Person> entries) {
        Person eldestPerson = null;
        for(Person person : entries) {
            if(eldestPerson == null) {
                eldestPerson = person;
                continue;
            }
            if(person.getDob().compareTo(eldestPerson.getDob())<0) {
                eldestPerson = person;
            }

        }
        return eldestPerson;
    }

    public static Person getPersonByName(String name, List<Person> entries) {
        for(Person person : entries) {
            if(name.equals(person.getName())) {
                return person;
            }
        }
        return null;
    }

    public static long findDaysDifference(Person person1, Person person2) {
        long diffMillis = person2.getDob().getTime() - person1.getDob().getTime();
        return TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
    }
}