package project1.io;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project1.model.Person;

import java.io.*;

public class FileHelper {
    public void writeToFile(String input, String filename){
        //Write JSON file
        try (FileWriter file = new FileWriter(filename)) {

            file.write(input);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFromFile(Person person, String filename){
        System.out.println(person.toString());
    }

    public String getFile(String name) throws IOException, ParseException {
        String filePath = "C:\\Users\\01\\Desktop\\" + name;
        StringBuilder stringBuilder = new StringBuilder();
        FileReader reader = new FileReader(filePath);
        StringBuilder resultStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        String strLine = bufferedReader.readLine();
        stringBuilder.append(strLine);
        return stringBuilder.toString();
    }
}
