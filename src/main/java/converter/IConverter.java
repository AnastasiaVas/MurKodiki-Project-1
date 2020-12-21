package converter;

import project1.model.Person;
import java.util.List;

public interface IConverter {
    String getStrFromPersons(List<Person> persons);
    public List<Person> getPersonsFromString(String strPersons);
}
