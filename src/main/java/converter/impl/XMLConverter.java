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
}
