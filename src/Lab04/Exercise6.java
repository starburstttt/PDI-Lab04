package Lab04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise6 {

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

        question1(data);
        question2(data);
        question3(data);
        question4(data);
    }

    static void question1(ArrayList<String[]> data) {
        int total = data.size();
        int male = 0;
        int female = 0;

        for (String[] row : data) {
            if (row[1].equals("male")) {
                male++;
            } else {
                female++;
            }
        }

        System.out.println("===== QUESTION 1 =====");
        System.out.println("Total candidates: " + total);
        System.out.printf("Male:   %d (%.2f%%)%n", male, male * 100.0 / total);
        System.out.printf("Female: %d (%.2f%%)%n", female, female * 100.0 / total);
        System.out.println();
    }

    static void question2(ArrayList<String[]> data) {
        int total = 0;
        int male = 0;
        int female = 0;

        for (String[] row : data) {
            double average = Double.parseDouble(row[9]);
            if (average >= 90) {
                total++;
                if (row[1].equals("male")) {
                    male++;
                } else {
                    female++;
                }
            }
        }

        System.out.println("===== QUESTION 2 =====");
        System.out.println("Candidates with average >= 90: " + total);
        System.out.printf("Male:   %d (%.2f%% of them)%n", male, male * 100.0 / total);
        System.out.printf("Female: %d (%.2f%% of them)%n", female, female * 100.0 / total);
        System.out.println();
    }

    static void question3(ArrayList<String[]> data) {
        int math = 0;
        int english = 0;
        int computer = 0;
        int all = 0;

        for (String[] row : data) {
            int m = Integer.parseInt(row[5]);
            int e = Integer.parseInt(row[6]);
            int c = Integer.parseInt(row[7]);

            if (m >= 85) {
                math++;
            }
            if (e >= 85) {
                english++;
            }
            if (c >= 85) {
                computer++;
            }
            if (m >= 85 && e >= 85 && c >= 85) {
                all++;
            }
        }

        System.out.println("===== QUESTION 3 =====");
        System.out.println("Math score >= 85:     " + math);
        System.out.println("English score >= 85:  " + english);
        System.out.println("Computer score >= 85: " + computer);
        System.out.println("85 or more in ALL 3 subjects: " + all);
        System.out.println();
    }

    static void question4(ArrayList<String[]> data) {
        String[] groups = { "group A", "group B", "group C", "group D", "group E" };

        System.out.println("===== QUESTION 4 =====");
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
    }
}