package converter.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import converter.IConverter;
import project1.model.Person;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class YamlConverter implements IConverter {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    @Override
    public String getStrFromPersons(List<Person> persons) throws JsonProcessingException {
        return mapper.writeValueAsString(persons);
    }

    @Override
    public List<Person> getPersonsFromString(String strPersons) throws IOException {
        mapper.readValue(strPersons, new TypeReference<List<Person>>() {});
        return mapper.readValue(strPersons, new TypeReference<List<Person>>() {});
    }

    @Override
    public String removePersonsFromList(long id, String strPersons) throws IOException {
        List<Person> persons = getPersonsFromString(strPersons);
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
            }
        }
        int count = 0;
        if (count < 1) {
            System.out.println("Вид списка персон после удаления персоны по id" + getStrFromPersons(persons));
        }
        count++;
        return getStrFromPersons(persons);
    }

    @Override
    public String updateDataInPerson(long id, String fieldToBeUpdated, String valueToUpdate, String strPersons) throws IOException {
        List<Person> persons = getPersonsFromString(strPersons);
        return updateDataInPersonFromList(id, fieldToBeUpdated, valueToUpdate, persons);
    }
}

