package converter.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import converter.IConverter;
import project1.model.Person;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class XMLConverter implements IConverter {
    XmlMapper xmlMapper = new XmlMapper();

    @Override
    public String getStrFromPersons(List<Person> persons) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, persons);
        return byteArrayOutputStream.toString();
    }


    @Override
    public List<Person> getPersonsFromString(String strPersons) throws IOException {
        return xmlMapper.readValue(strPersons, new TypeReference<List<Person>>() {
        });
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
        return getStrFromPersons(persons);
    }

    @Override
    public String updateDataInPerson(long id, String fieldToBeUpdated, String valueToUpdate, String strPersons) throws IOException {
        List<Person> persons = getPersonsFromString(strPersons);
        return updateDataInPersonFromList(id, fieldToBeUpdated, valueToUpdate, persons);
    }
}
