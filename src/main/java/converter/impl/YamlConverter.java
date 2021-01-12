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
}

