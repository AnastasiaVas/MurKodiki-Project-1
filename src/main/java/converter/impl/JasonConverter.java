package converter.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import converter.IConverter;
import project1.model.Person;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class JasonConverter implements IConverter {
    Gson json = new Gson();

    @Override
    public String getStrFromPersons(List<Person> persons) {
        return json.toJson(persons);
    }

    public List<Person> getPersonsFromString(String strPersons) {
        Type collectionType = new TypeToken<List<Person>>() {}.getType();
        return json.fromJson(strPersons, collectionType);
    }

    @Override
    public String removePersonsFromList(long id, String strPersons) throws IOException {
        List<Person> persons = getPersonsFromString(strPersons);
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
            }
        }
        int count = 0;
        if (count < 1) {
            System.out.println("Удаление выполнено успешно" + getStrFromPersons(persons));
        }
        count++;

        return getStrFromPersons(persons);
    }

    @Override
    public String updateDataInPerson(long id, String fieldToBeUpdated, String valueToUpdate, String strPersons) throws IOException {
        List<Person> persons = getPersonsFromString(strPersons);
        return updateDataInPersonFromList(id, fieldToBeUpdated, valueToUpdate, persons);
    }

}
