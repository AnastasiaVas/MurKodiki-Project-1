package converter;

import project1.model.Person;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface IConverter {
    String getStrFromPersons(List<Person> persons) throws JAXBException;
}
