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
               StringBuilder resultStringBuilder = new StringBuilder();
               try (BufferedReader br
                            = new BufferedReader(new FileReader(name))) {
                   String line;
                   while ((line = br.readLine()) != null) {
                       resultStringBuilder.append(line).append("\n");
                   }
               }
               return resultStringBuilder.toString();
       }

}
