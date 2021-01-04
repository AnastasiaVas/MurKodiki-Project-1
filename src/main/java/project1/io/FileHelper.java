package project1.io;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project1.model.Person;

import java.io.*;

public class FileHelper {
    StringBuilder resultStringBuilder = new StringBuilder();

    public void writeToFile(String input, String filename) {

        try (FileWriter file = new FileWriter(filename)) {

            file.write(input);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFromFile(Person person, String filename) {
        System.out.println(person.toString());
    }

    public String getFile(String name) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
//        int count = 0;
//        if (count < 1) {
//            System.out.println(resultStringBuilder.toString());
//        }
//        count++;
        return resultStringBuilder.toString();
    }

}
