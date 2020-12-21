package project1.cmd;

import org.json.simple.parser.ParseException;
import project1.model.Person;

import java.io.IOException;
import java.util.List;

public class BinaryFormatCmdProcessor implements Executable {
    @Override
    public void create(List<Person> persons, String fileName) {

    }

    @Override
    public List<Person> read(String fileName) throws IOException, ParseException {
        return null;
    }

    @Override
    public void update(List<Person> persons, String fileName) {

    }

    @Override
    public void delete(long id, String fileName) {

    }
}
