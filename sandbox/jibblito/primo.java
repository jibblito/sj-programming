import java.util.Scanner;
import java.util.Random;

public class primo {
		
	static String version = "1.0";	

	public static void main(String[] args) {
		int numChar;
		int numPass;
		Scanner scan = new Scanner(System.in);
		System.out.println("PASS GEN VERSION " + version + " BY RORY HIBBLER");
		System.out.print("Number of characters: ");
		numChar = scan.nextInt();
		System.out.print("Number of passwords: ");
		numPass = scan.nextInt();
		System.out.println();
		System.out.println("======================");
		if(numPass == 1) System.out.println("Generating 1 password with length  " + numChar + "...");
		else System.out.println("Generating " + numPass + " passwords with length " + numChar + "...");
		
		System.out.println();
		
		String pass = "";
		for(int i = 0; i < numPass; i++) {
			for(int j = 0; j < numChar; j++) {
				pass += (char)((int)(Math.random() * 93)+33);
			}
			System.out.println(pass);
			pass = "";
		}
		System.out.println();
		System.out.println("Process Finished");
		
	}

}
