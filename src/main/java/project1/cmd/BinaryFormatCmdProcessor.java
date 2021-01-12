package project1.cmd;

import org.json.simple.parser.ParseException;
import project1.model.Person;
import static project1.UserDialogController.*;

import static project1.UserDialogController.fileName;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import static project1.UserDialogController.fileName;

public class BinaryFormatCmdProcessor implements Executable {

    @Override
    public void start() throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(personsBeforeSave);
        outputStream.close();
    }

    @Override
    public List<Person> read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Person> person = (List<Person>) ois.readObject();

        return person;
    }

    @Override
    public void update(long id, String valueToBeUpdated, String valueToChange) throws IOException, ParseException, ClassNotFoundException {
        isFileDataDownloaded(isFileDataDownloaded);
        Iterator<Person> iterator = personsBeforeSave.iterator();
        Person reqPerson;
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getId() == id) {
                reqPerson = item;
                switch (valueToBeUpdated) {
                    case "id":
                        reqPerson.setId(Long.parseLong(valueToChange));
                        break;
                    case "fname":
                        reqPerson.setFname(valueToChange);
                        break;
                    case "lname":
                        reqPerson.setLname(valueToChange);
                        break;
                    case "age":
                        reqPerson.setAge(Integer.parseInt(valueToChange));
                        break;
                    case "city":
                        reqPerson.setCity(valueToChange);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
    }

    @Override
    public void delete(long id) throws ParseException, IOException, ClassNotFoundException {
        isFileDataDownloaded(isFileDataDownloaded);
        Iterator<Person> iterator = personsBeforeSave.iterator();
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
            }
        }
    }
}
