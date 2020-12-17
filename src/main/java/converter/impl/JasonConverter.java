package converter.impl;

import com.google.gson.Gson;
import converter.IConverter;
import project1.model.Person;

import java.util.List;

public class JasonConverter implements IConverter {
    Gson json = new Gson();
    @Override
    public String getStrFromPersons(List<Person> persons) {
        String resultStr = json.toJson(persons);
        return resultStr;
    }
}
