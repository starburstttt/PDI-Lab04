package Lab04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {
        ArrayList<String[]> students = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("Ex3StudentData.csv"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                students.add(line.split(","));  
            }
            sc.close();

            System.out.println("Students loaded: " + students.size());
            for (String[] s : students) {
                System.out.println("Name: " + s[0] + " | ID: " + s[1] + " | Gender: " + s[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}