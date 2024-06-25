package INNOVATIVE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * rank
 */
public class rank{
    protected Double read(File file, double perc) {
        try {
            Scanner scFile = new Scanner(file);
            ArrayList<String> arr = new ArrayList<>();
            ArrayList<Double> arr2 = new ArrayList<>();
            while (scFile.hasNextLine()) {
                String line = scFile.nextLine();
                arr.add(line);
            }
            scFile.close();
            for (String it : arr) {
                String[] x = it.split(" ");
                arr2.add(Double.parseDouble(x[2]));
            }
            Collections.sort(arr2, Collections.reverseOrder());
            return (double)arr2.indexOf(perc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0d;
    }
}