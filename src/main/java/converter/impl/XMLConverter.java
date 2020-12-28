package converter.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.reflect.TypeToken;
import converter.IConverter;
import project1.model.Person;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
    public List<Person> getPersonsFromString(String strPersons) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        List<Person> persons = xmlMapper.readValue(strPersons,new TypeReference<List<Person>>(){});
        return persons;
    }

   // @Override
   // public List<Person> getPersonsFromString(String strPersons) throws IOException {
   //     List<Person> list =  new ArrayList<Person>();
   //     XmlMapper xmlMapper = new XmlMapper();
   //     Type collectionType = new TypeToken<List<Person>>(){}.getType();
   //     ObjectReader obj = xmlMapper.reader();
   //     JsonParser ojt = obj.createParser(strPersons);
   //     Person p = ojt.readValueAs((TypeReference<?>) collectionType);
   //     list.add(p);
   //     return list;
   // }
}
