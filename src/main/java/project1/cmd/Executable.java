package project1.cmd;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import project1.model.Person;

import java.io.IOException;
import java.util.List;

public interface Executable {
    void create(List<Person> persons, String fileName) throws IOException;

    List<Person> read(String fileName) throws IOException, ParseException;

    void update(long id, String valueToBeUpdated, String valueToChange, String fileName) throws IOException;

    void delete(long id, String fileName) throws IOException;
}
