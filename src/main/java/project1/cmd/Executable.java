package project1.cmd;

import org.json.simple.parser.ParseException;
import project1.io.FileHelper;
import project1.model.Person;

import java.io.IOException;
import java.util.List;

import static project1.UserDialogController.isFileDataDownloaded;
import static project1.UserDialogController.personsBeforeSave;

public interface Executable {

    FileHelper fileHelper = new FileHelper();

    default void create(List<Person> persons) throws IOException, ParseException, ClassNotFoundException {
        if (!isFileDataDownloaded) {
            if (!fileHelper.isFileEmpty()) {
                List<Person> personsFromFile = read();
                personsFromFile.addAll(persons);
                personsBeforeSave = personsFromFile;
            }
            isFileDataDownloaded = true;
        }
            personsBeforeSave.addAll(persons);
    }

    void start() throws IOException;

    List<Person> read() throws IOException, ParseException, ClassNotFoundException;

    void update(long id, String valueToBeUpdated, String valueToChange) throws IOException, ParseException, ClassNotFoundException;

    void delete(long id) throws IOException, ParseException, ClassNotFoundException;

    default void isFileDataDownloaded(boolean isFileDataDownloaded) throws ParseException, IOException, ClassNotFoundException {
        if (!isFileDataDownloaded) {
            if (!fileHelper.isFileEmpty()) {
                List<Person> personsFromFile = read();
                personsFromFile.addAll(personsBeforeSave);
                personsBeforeSave = personsFromFile;
            }
        }
    }
}
