import java.util.Scanner;
import java.util.Random;

public primo {
		
	String version = "1.0";	

	public static void main(String[] args) {
		int numChar;
		Scanner scan = new Scanner(System.in);
		System.out.println("PASS GEN VERSION " + version + " BY RORY HIBBLER");
		System.out.print("Number of characters: ");
		numChar = scan.nextInt();
		System.out.println("\n==================\nGenerating " + numChar + " Char pass...");
		
		
		String pass = "";
		for(int i = 0; i < numChar; i++) {
			pass += (char)((int)(Math.random() * 93)+33);
		}
		System.out.println(pass);
		System.out.println("Process Finished");
		
	}

}
