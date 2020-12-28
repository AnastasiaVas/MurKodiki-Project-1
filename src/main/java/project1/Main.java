package project1;

import converter.IConverter;
import converter.impl.JasonConverter;
import converter.impl.XMLConverter;
import converter.impl.YamlConverter;
import org.json.simple.parser.ParseException;
import project1.cmd.Executable;
import project1.cmd.StringFormatCmdProcessor;
import project1.io.FileHelper;
import project1.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String args[]) throws IOException, ParseException {
        Person person1 = new Person(1111, "Vova", "Popov", 25, "Lviv");
        Person person2 = new Person(1567, "Vika", "Popova", 18, "Lviv");
        Person person3 = new Person(6790, "Andrey", "Volkov", 16, "Kyiv");
        Person person4 = new Person(8997, "Vladislav", "Golovashchenko", 10, "Poltava");
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        JasonConverter converter = new JasonConverter();
        StringFormatCmdProcessor stringFormatCmdProcessor = new StringFormatCmdProcessor(converter);
//        stringFormatCmdProcessor.processCmd(persons, "employees.json");

 //       IConverter xmlConverter = new XMLConverter();
 //       CreateCmd createCmdXML = new CreateCmd(xmlConverter);
 //       createCmdXML.processCmd(persons, "employees.xml");

        IConverter xmlConverter = new XMLConverter();
        Executable xmlStringFormatCMDProcessor = new StringFormatCmdProcessor(xmlConverter);
        xmlStringFormatCMDProcessor.create(persons, "employees.xml");
        List<Person> personsXML = xmlStringFormatCMDProcessor.read("employees.xml");
        System.out.println(personsXML.get(1).getId());


        IConverter yamlConverter = new YamlConverter();
        Executable yamlStringFormatCMDProcessor = new StringFormatCmdProcessor(yamlConverter);
        yamlStringFormatCMDProcessor.create(persons,"employees.yaml");
        List<Person> personsYaml = yamlStringFormatCMDProcessor.read("employees.yaml");
        System.out.println(personsYaml.get(1).getId());

//        FileHelper fl = new FileHelper();
//        String strFile = fl.getFile("employees.json");
//        System.out.println(strFile);
//        List<Person> mainList = converter.getPersonsFromString(strFile);
//        System.out.println(mainList.get(0).getId());
    }
}
