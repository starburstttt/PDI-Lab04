package Lab04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {
        try {
            ArrayList<Candidate> candidates = readCsv("CandidatePerformanceTest.csv");
            System.out.println("Objects created from the csv: " + candidates.size());

            saveToSer(candidates, "candidates.ser");     
            saveToCsv(candidates, "candidates_out.csv");   
            System.out.println("Saved candidates.ser and candidates_out.csv");

            ArrayList<Candidate> fromSer = loadFromSer("candidates.ser");
            ArrayList<Candidate> fromCsv = readCsv("candidates_out.csv");
            System.out.println("Objects loaded from candidates.ser:      " + fromSer.size());
            System.out.println("Objects loaded from candidates_out.csv:  " + fromCsv.size());

           
            System.out.println();
            System.out.println("First 3 objects loaded from candidates.ser:");
            for (int i = 0; i < 3; i++) {
                System.out.println(fromSer.get(i));
            }

            int different = 0;
            for (int i = 0; i < candidates.size(); i++) {
                String original = candidates.get(i).toCsv();
                if (!original.equals(fromSer.get(i).toCsv()) || !original.equals(fromCsv.get(i).toCsv())) {
                    different++;
                }
            }
            System.out.println();
            System.out.println("Objects that changed after saving and loading: " + different);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Candidate> readCsv(String fileName) throws IOException {
        ArrayList<Candidate> list = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.split(",").length < 10) {
                continue; 
            }
            list.add(Candidate.fromCsv(line));
        }
        sc.close();
        return list;
    }

    static void saveToCsv(ArrayList<Candidate> list, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        for (Candidate c : list) {
            fw.write(c.toCsv() + "\n");
        }
        fw.close();
    }

    static void saveToSer(ArrayList<Candidate> list, String fileName) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(list);
        out.close();
    }

   
    @SuppressWarnings("unchecked") 
    static ArrayList<Candidate> loadFromSer(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Candidate> list = (ArrayList<Candidate>) in.readObject();
        in.close();
        return list;
    }
}