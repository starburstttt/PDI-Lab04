package Lab04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Exercise1 {
	public static void main(String[] args) {
		Random r = new Random();
		
	try { 
		FileWriter fw = new FileWriter("LuckyNumber.csv");	
		for ( int i =1; i <=500; i++) {
			int num = r.nextInt(10000);
			fw.write(num + "\n");
		}
		fw.close();
		Scanner inp = new Scanner(new File("LuckyNumber.csv"));
		while (inp.hasNextLine()) {
			String line = inp.nextLine();
			System.out.println(line);
		}
		inp.close();
		}catch (IOException e) {
			 e.printStackTrace();
			
		}
	}
}

