package project1.io;

import java.io.FileWriter;
import java.io.IOException;

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
}
