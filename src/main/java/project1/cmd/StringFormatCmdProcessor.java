package project1.cmd;

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
    public void create(List<Person> persons, String fileName) throws IOException {
        String personsStr = converter.getStrFromPersons(persons);
        fileHelper.writeToFile(personsStr, fileName);
    }

    @Override
    public List<Person> read(String fileName) throws IOException, ParseException {
        String content = fileHelper.getFile(fileName);
        return converter.getPersonsFromString(content);
    }

    @Override
    public void update(long id, String valueToBeUpdated, String valueToChange, String fileName) throws IOException {
        String content = fileHelper.getFile(fileName);
        String p = converter.updateDataInPerson(id, valueToBeUpdated, valueToChange, content);
        fileHelper.writeToFile(p, fileName);
    }

    @Override
    public void delete(long id, String fileName) throws IOException {
        String content = fileHelper.getFile(fileName);
        String p = converter.removePersonsFromList(id, content);
        fileHelper.writeToFile(p, fileName);
//        System.out.println(fileHelper.getFile(fileName));
    }
}
