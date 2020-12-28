package project1;

import com.fasterxml.jackson.core.JsonProcessingException;
import dialog.UserDialog;
import project1.cmd.Executable;
import project1.model.Person;
import util.Constants.Cmd;

import java.io.IOException;
import java.util.List;

public class UserDialogController {

    private final static char POINT = '.';
    private final FormatFactory factory = new FormatFactory();
    private final UserDialog userDialog = new UserDialog();

    public void command(String cmd, String fileName) throws IOException {
        String format = determineFormat(fileName);
        Executable executor = factory.getInstance(format);
        executeCmd(executor, cmd, fileName);
    }

    private String determineFormat(String fileName) {
        return fileName.substring(fileName.lastIndexOf(POINT)  + 1);
    }

    private void executeCmd(Executable executor, String cmd, String fileName) throws IOException {
        switch (cmd) {
            case Cmd.CREATE:
                List<Person> persons = userDialog.typePersonData();
                executor.create(persons, fileName);
                break;
            default:
                System.out.printf("Command %s is not supported command", cmd);
        }
    }
}
