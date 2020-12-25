package project1.cmd;

import com.fasterxml.jackson.core.JsonProcessingException;
import converter.IConverter;
import org.json.simple.parser.ParseException;
import project1.io.FileHelper;
import project1.model.Person;

import java.io.IOException;
import java.util.List;

public class StringFormatCmdProcessor implements Executable {
    FileHelper fileHelper = new FileHelper();
    IConverter converter;
    public StringFormatCmdProcessor(IConverter converter) {
        this.converter = converter;
    }

    @Override
    public void create(List<Person> persons, String fileName) throws JsonProcessingException {
        String personsStr = converter.getStrFromPersons(persons);
        fileHelper.writeToFile(personsStr, fileName);
    }

    @Override
    public List<Person> read(String fileName) throws IOException, ParseException {
        String content = fileHelper.getFile(fileName);
        return converter.getPersonsFromString(content);
    }

    @Override
    public void update(List<Person> persons, String fileName) {

    }

    @Override
    public void delete(long id, String fileName) {

    }
}
