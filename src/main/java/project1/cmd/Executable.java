package project1.cmd;

import org.json.simple.parser.ParseException;
import project1.model.Person;

import java.io.IOException;
import java.util.List;

public interface Executable {
    void create(List<Person> persons) throws IOException, ParseException;

    List<Person> read() throws IOException, ParseException, ClassNotFoundException;

    void update(long id, String valueToBeUpdated, String valueToChange) throws IOException, ParseException, ClassNotFoundException;

    void delete(long id) throws IOException, ParseException, ClassNotFoundException;
}
