package project1.cmd;

import org.json.simple.parser.ParseException;
import project1.model.Person;
import java.io.IOException;
import java.util.List;
import static project1.UserDialogController.fileName;
public class BinaryFormatCmdProcessor implements Executable {
    @Override
    public void create(List<Person> persons) {

    }

    @Override
    public List<Person> read() throws IOException, ParseException {
        return null;
    }

    @Override
    public void update(long id, String valueToBeUpdated, String valueToChange) throws IOException {

    }

    @Override
    public void delete(long id) {

    }
}
