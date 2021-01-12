package converter;

import converter.impl.CSVConverter;
import project1.model.Person;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public interface IConverter {

    String getStrFromPersons(List<Person> persons) throws IOException;

    public List<Person> getPersonsFromString(String strPersons) throws IOException;

    public default List<Person> updateDataInPerson(long id, String fieldToBeUpdated, String valueToUpdate, String strPersons) throws IOException {
        List<Person> persons = getPersonsFromString(strPersons);
        Iterator<Person> iterator = persons.iterator();
        boolean hasID = false;
        Person reqPerson;
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getId() == id) {
                hasID = true;
                reqPerson = item;
                switch (fieldToBeUpdated) {
                    case "id":
                        reqPerson.setId(Long.parseLong(valueToUpdate));
                        break;
                    case "fname":
                        reqPerson.setFname(valueToUpdate);
                        break;
                    case "lname":
                        reqPerson.setLname(valueToUpdate);
                        break;
                    case "age":
                        reqPerson.setAge(Integer.parseInt(valueToUpdate));
                        break;
                    case "city":
                        reqPerson.setCity(valueToUpdate);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        if (!hasID){
            throw new IllegalArgumentException();
        }

        return persons;
    }

    public default List<Person> removePersonsFromList(long id, String strPersons) throws IOException {
        List<Person> persons = getPersonsFromString(strPersons);
        Iterator<Person> iterator = persons.iterator();
        boolean hasID = false;
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
                hasID = true;
                break;
            }
        }
        if (!hasID){
            throw new IllegalArgumentException();
        }
        return persons;
    }
}
