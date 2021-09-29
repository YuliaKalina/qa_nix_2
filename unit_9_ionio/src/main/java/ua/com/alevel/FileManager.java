package ua.com.alevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class FileManager {
    public String read() {
        // read file
        String data = "";
        try {
            File file = new File("input.txt");
            Scanner myReader = new Scanner(file);
            StringBuilder sb = new StringBuilder();
            while (myReader.hasNextLine()) {
                sb.append(myReader.nextLine()).append(" ");
            }
            data = sb.toString();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
    public void writeResult(Map<String, Integer> sortedByCount, Integer count, Integer sentenceCount) {
        // write information
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(sortedByCount + System.lineSeparator() + count + System.lineSeparator() + sentenceCount);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
