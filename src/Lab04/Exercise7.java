package Lab04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise7 {
    static String[] groups = { "group A", "group B", "group C", "group D", "group E" };

    public static void main(String[] args) {
        ArrayList<String[]> data = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("CandidatePerformanceTest.csv"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] p = line.split(",");
                if (p.length < 10) {
                    continue; 
                }
                data.add(p);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Rows loaded: " + data.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(data.get(i)));
        }
        System.out.println();

       
        showGroupCounts(data);
        writeGroupFiles(data);
    }

    static void showGroupCounts(ArrayList<String[]> data) {
        System.out.println("===== STUDENTS IN EACH GROUP =====");
        for (String g : groups) {
            int total = 0;
            int male = 0;
            int female = 0;

            for (String[] row : data) {
                if (row[2].equals(g)) {
                    total++;
                    if (row[1].equals("male")) {
                        male++;
                    } else {
                        female++;
                    }
                }
            }

            System.out.println(g + ": " + total + " students");
            System.out.printf("   Male:   %d (%.2f%%)%n", male, male * 100.0 / total);
            System.out.printf("   Female: %d (%.2f%%)%n", female, female * 100.0 / total);
        }
        System.out.println();
    }

    static void writeGroupFiles(ArrayList<String[]> data) {
        try {
            for (String g : groups) {
                String fileName = g.replace(" ", "") + ".csv"; 
                FileWriter fw = new FileWriter(fileName);

                fw.write("ID,gender,group,Education,test preparation course,Math,English,Computer,Total,Average\n");

                int total = 0;
                int male = 0;
                int female = 0;

                for (String[] row : data) {
                    if (row[2].equals(g)) {
                        fw.write(String.join(",", row) + "\n"); 
                        total++;
                        if (row[1].equals("male")) {
                            male++;
                        } else {
                            female++;
                        }
                    }
                }


                double malePercent = Math.round(male * 10000.0 / total) / 100.0;
                double femalePercent = Math.round(female * 10000.0 / total) / 100.0;

                fw.write("\n");
                fw.write("Total students," + total + "\n");
                fw.write("Male," + male + "," + malePercent + "%\n");
                fw.write("Female," + female + "," + femalePercent + "%\n");

                fw.close();
                System.out.println("Created " + fileName + " (" + total + " students)");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}