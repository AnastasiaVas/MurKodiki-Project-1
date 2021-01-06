package project1.cmd;

import converter.IConverter;
import org.json.simple.parser.ParseException;
import project1.io.FileHelper;
import project1.model.Person;

import java.io.IOException;
import java.util.List;
import static project1.UserDialogController.fileName;
public class StringFormatCmdProcessor implements Executable {
    FileHelper fileHelper = new FileHelper();
    IConverter converter;

    public StringFormatCmdProcessor(IConverter converter) {
        this.converter = converter;
    }

    @Override
    public void create(List<Person> persons) throws IOException {
        String personsStr = converter.getStrFromPersons(persons);
        fileHelper.writeToFile(personsStr);
    }

    @Override
    public List<Person> read() throws IOException, ParseException {
        String content = fileHelper.getFile();
        return converter.getPersonsFromString(content);
    }

    @Override
    public void update(long id, String valueToBeUpdated, String valueToChange) throws IOException {
        String content = fileHelper.getFile();
        String p = converter.updateDataInPerson(id, valueToBeUpdated, valueToChange, content);
        fileHelper.writeToFile(p);
    }

    @Override
    public void delete(long id) throws IOException {
        String content = fileHelper.getFile();
        String p = converter.removePersonsFromList(id, content);
        fileHelper.writeToFile(p);
    }
}
