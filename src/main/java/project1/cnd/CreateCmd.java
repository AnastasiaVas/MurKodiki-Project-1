package project1.cnd;

import converter.IConverter;
import project1.io.FileHelper;
import project1.model.Person;

import javax.xml.bind.JAXBException;
import java.util.List;

public class CreateCmd {
    FileHelper fileHelper = new FileHelper();
    IConverter converter;
    public CreateCmd(IConverter converter) {
        this.converter = converter;
    }

    public void processCmd(List<Person> persons, String filename) throws JAXBException {
        String personsStr = converter.getStrFromPersons(persons);
        fileHelper.writeToFile(personsStr, filename);
    }
}
