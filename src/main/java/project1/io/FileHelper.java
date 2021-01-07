package project1.io;

import static project1.UserDialogController.fileName;

import java.io.*;

public class FileHelper {

    public boolean fileExists() {
        File tempFile = new File(fileName);
        return tempFile.exists();
    }

    public boolean fileIsEmpty(){
        File file = new File(fileName);
        if (file.length() != 0){
            return false;
        } else{
            return true;
        }
    }

    public void writeToFile(String input) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {

            fileWriter.write(input);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFile() throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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
