package converter.impl;

import converter.IConverter;
import project1.model.Person;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVConverter implements IConverter {
    @Override
    public String getStrFromPersons(List<Person> persons) {
        String[][] values = new String[persons.size()+1][5];
        values[0] = new String[]{"id", "first name", "last name", "age", "city"};
        int i = 1;
        for (Person person : persons) {
            values[i] = new String[]{String.valueOf(person.getId()), person.getFname(),
                    person.getLname(), String.valueOf(person.getAge()), person.getCity()};
            i++;
        }
        return Arrays.stream(values)
                .map(this::convertToCSV)
                .collect(Collectors.joining("\n"));
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    @Override
    public List<Person> getPersonsFromString(String strPersons) throws IOException {
        System.out.println(strPersons);
        return null;
    }

    @Override
    public String removePersonsFromList(long id, String strPersons) throws IOException {
        return null;
    }

    @Override
    public String updateDataInPerson(long id, String fieldToBeUpdated, String valueToUpdate, String strPersons) throws IOException {
        return null;
    }
}
