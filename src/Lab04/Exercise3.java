package Lab04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("Ex3StudentData.csv");
            Scanner inp = new Scanner(System.in);

            for (int i = 1; i <= 3; i++) {
                System.out.println("Student " + i);

                System.out.print("Input Name: ");
                String name = inp.nextLine();

                System.out.print("Input ID: ");
                String id = inp.nextLine();

                System.out.print("Input Gender: ");
                String gender = inp.nextLine();
                
                fw.write(name + "," + id + "," + gender + "\n");
            } 
            fw.close();
            inp.close();
            System.out.println("Saved to Ex3StudentData.csv!");

        } catch (IOException e) {
        	
        }
    }
}