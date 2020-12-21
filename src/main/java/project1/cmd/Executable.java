package project1.cmd;

import org.json.simple.parser.ParseException;
import project1.model.Person;

import java.io.IOException;
import java.util.List;

public interface Executable {
    void create(List<Person> persons, String fileName);
    List<Person> read(String fileName) throws IOException, ParseException;
    void update(List<Person> persons, String fileName);
    void delete(long id, String fileName);
}
