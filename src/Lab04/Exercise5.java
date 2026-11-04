package Lab04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        ArrayList<String[]> students = new ArrayList<>();
        Scanner inp = new Scanner(System.in);

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

            for (int i = 1; i <= 3; i++) {
                System.out.println("New Student " + i);
                System.out.print("Input Name: ");
                String name = inp.nextLine();
                System.out.print("Input ID: ");
                String id = inp.nextLine();
                System.out.print("Input Gender: ");
                String gender = inp.nextLine();
                students.add(new String[] { name, id, gender });
            }
            students.sort((a, b) -> a[0].compareToIgnoreCase(b[0]));

            FileWriter fw = new FileWriter("Ex3StudentData.csv");
            for (String[] s : students) {
                fw.write(s[0] + "," + s[1] + "," + s[2] + "\n");
            }
            fw.close();

            System.out.println("Saved " + students.size() + " students to Ex3StudentData.csv!");

        } catch (IOException e) {
            e.printStackTrace();
        }
        inp.close();
    }
}