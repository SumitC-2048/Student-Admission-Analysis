package INNOVATIVE;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class textFileAppend {
    public void append(String s,File file) {
        try {
            Scanner scFile = new Scanner(file);

            ArrayList<String> arr = new ArrayList<>();
            while (scFile.hasNextLine()) {
                String line = scFile.nextLine();
                arr.add(line);
            }
            scFile.close();

            arr.add(s);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String line : arr) {
                writer.write(line);
                writer.newLine();  // Move to the next line
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
