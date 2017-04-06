package scannertest;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// system.in means read from the keyboard
		
		
		System.out.println("Enter your computer number");
		int compno = sc.nextInt();
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your GPA");
		double gpa = sc.nextDouble();
		System.out.println("Computer Number:" + compno + " Name:" + name + " GPA:" + gpa);
		sc.close();
		

	}

}
