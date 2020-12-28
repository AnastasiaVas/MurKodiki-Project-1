package converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import project1.model.Person;

import java.io.IOException;
import java.util.List;

public interface IConverter {
    String getStrFromPersons(List<Person> persons) throws IOException;
    public List<Person> getPersonsFromString(String strPersons) throws IOException;
    public  String removePersonsFromList(long id, String strPersons) throws IOException;

}
