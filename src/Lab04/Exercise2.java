package Lab04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter n: ");
        int n = Integer.parseInt(inp.nextLine());
        File folder = new File("Ex2LuckyNumber");
        folder.mkdir();
        try {
            for (int i = 1; i <= n; i++) {
                FileWriter fw = new FileWriter(new File(folder, "file" + i + ".csv"));
                for (int j = 0; j < 10; j++) { 
                    fw.write((r.nextInt(100) + 1) + "\n");
                }
                fw.close();
            }
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                Scanner sc = new Scanner(new File(folder, "file" + i + ".csv"));
                while (sc.hasNextLine()) {
                    numbers.add(Integer.parseInt(sc.nextLine()));
                }
                sc.close();
            }
            int max = numbers.get(0);
            int min = numbers.get(0);
            for (int num : numbers) {
                if (num > max) max = num;
                if (num < min) min = num;
            }
            System.out.println("Total numbers read: " + numbers.size());
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inp.close();
    }
}