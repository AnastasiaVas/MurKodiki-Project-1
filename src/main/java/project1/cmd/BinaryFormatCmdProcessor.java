package project1.cmd;

import org.json.simple.parser.ParseException;
import project1.model.Person;

import static project1.UserDialogController.fileName;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import static project1.UserDialogController.fileName;

public class BinaryFormatCmdProcessor implements Executable {
    @Override
    public void create(List<Person> persons) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(persons);
        outputStream.close();
    }

    @Override
    public List<Person> read() throws IOException, ParseException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Person> person = (List<Person>) ois.readObject();

        return person;
    }

    @Override
    public void update(long id, String valueToBeUpdated, String valueToChange) throws IOException, ParseException, ClassNotFoundException {
        List<Person> persons = read();
        Iterator<Person> iterator = persons.iterator();
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
                }
            }
        }
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(persons);
        outputStream.close();
    }

    @Override
    public void delete(long id) throws ParseException, IOException, ClassNotFoundException {
        List<Person> persons = read();
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
            }
        }
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(persons);
        outputStream.close();
    }
}
