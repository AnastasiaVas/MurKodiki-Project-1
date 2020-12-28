package converter.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.mapper.Mapper;
import converter.IConverter;
import project1.model.Person;
import project1.model.Persons;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YamlConverter implements IConverter {


    @Override
    public String getStrFromPersons(List<Person> persons) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String resultStr = mapper.writeValueAsString(persons);
        return resultStr;
    }

    @Override
    public List<Person> getPersonsFromString(String strPersons) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<Person> enums = mapper.readValue(strPersons,new TypeReference<List<Person>>(){});
        return enums;
    }
}

