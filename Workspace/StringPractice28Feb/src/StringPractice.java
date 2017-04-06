import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class StringPractice {

	public static void main(String[] args) {

		String pString = "I Totally Love Java!";
		String pString2 = "I Totally Love Java!";
		
		
		/*
		 System.out.println(pString.length());
		 
		System.out.println(pString.charAt(0));
		System.out.println(pString.charAt(pString.length()-1));
		System.out.println(pString.substring(2, 9));
		System.out.println(pString.substring(2));
		// System.out.println(pString == pString 2); // Wrong!
		System.out.println(pString.equals(pString2)); // Correct!
		*/
		
		Scanner tester = new Scanner(System.in);
		System.out.println("What is the word?:");
		String test = tester.next();
		if(test.length() <= 4){
			System.out.println(test);
		
			
		}
		else if (test.length() > 4){
			char character1 = test.charAt(0);
			char character2 = test.charAt(1);
			char character3 = test.charAt(test.length()-2);
			char character4 = test.charAt(test.length()-1);
			String test1 = "The result is: " + character1 + character2 + character3 + character4;
			System.out.println(test1);
			
			
			
		}
		
		
		
		
		

	}

}
