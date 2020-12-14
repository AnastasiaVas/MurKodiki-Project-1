package project1;

import converter.IConverter;
import converter.impl.JasonConverter;
import project1.cnd.CreateCmd;
import project1.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String args[]){
        Person person1 = new Person(1111, "Vova", "Popov", 25, "Lviv");
        Person person2 = new Person(1567, "Vika", "Popova", 18, "Lviv");
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        IConverter converter = new JasonConverter();
        CreateCmd createCmd = new CreateCmd(converter);
        createCmd.processCmd(persons, "employees.json");
    }
}
