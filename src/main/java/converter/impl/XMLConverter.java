package converter.impl;

import converter.IConverter;
import project1.model.Person;
import java.util.List;

public class XMLConverter implements IConverter {

    @Override
    public String getStrFromPersons(List<Person> persons) {
 //       try {
 //           XStream xstream = new XStream();
 //           xstream.alias("person", Person.class);
 //           xstream.alias("persons", Persons.class);
 //           xstream.addImplicitCollection(Persons.class, "list");
//
 //           Persons list = new Persons();
 //           list.add(new Person("ABC",12,"address"));
 //           list.add(new Person("XYZ",20,"address2"));
//
 //           String xml = xstream.toXML(list);
 //       } catch (JAXBException e) {
 //           e.printStackTrace();
 //       }

        return null;
    }

    @Override
    public List<Person> getPersonsFromString(String strPersons) {
        return null;
    }
}
