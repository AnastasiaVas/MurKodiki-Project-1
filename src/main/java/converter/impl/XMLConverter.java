package converter.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import converter.IConverter;
import project1.model.Person;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class XMLConverter implements IConverter {

    @Override
    public String getStrFromPersons(List<Person> persons) throws IOException {
        final String XML = "<Person>...</Person>";
        XmlMapper xmlMapper = new XmlMapper();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, persons);
        return byteArrayOutputStream.toString();
    }

    @Override
    public List<Person> getPersonsFromString(String strPersons) {


        return null;
    }
}
