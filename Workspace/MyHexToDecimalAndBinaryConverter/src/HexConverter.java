import java.util.Scanner;

import javax.swing.JOptionPane;

public class HexConverter {

	public static void main(String[] args) {
		
		// "pseudo-code -- half code / half English
		/*
		 * syso "Enter a hexadecimal number"
		 * Scanner to read that number as a String (0-9, A-F)
		 * parse that String, pulling it apart a char at a time
		 * ex: F03A, pull that apart as A, 3, 0, F
		 * a * b^0 => A * 1 = 10d (A in hex is 10, B is 11...)
		 * 3* b^1 => 3*16 = 48d.
		 * 0 * anything = 0d.
		 * F * b^3 => (15) * 4096 = 
		 * 
		 * add those up to get your final decimal conversion
		 * 
		 */
		
		Scanner keyboard = new Scanner(System.in);
		String hexInput;
		char hexChar;
		int valueOfHexChar;
		int finalDecimal = 0;
		int convertStep;
		
		System.out.println("Please enter a 4 char hex number");
		hexInput = keyboard.next().toUpperCase();
		//hexInput = hexInput.toUpperCase();
		System.out.println("You have entered: " + hexInput);
		System.out.println("Your hex number has this many chars: "
				+ hexInput.length());
		System.out.println();
		
		for (int i = hexInput.length()-1; i >= 0; i-- ){
			hexChar = hexInput.charAt(i);
			valueOfHexChar = hexCharToInt(hexChar);
			System.out.println("count: " + i + " char is " + hexChar
					+ " val of hexChar is " + valueOfHexChar);
			
			if (i == 3){
				convertStep = valueOfHexChar * 1;
				finalDecimal += convertStep;
				System.out.println("i=3 convertStep = " + convertStep
						+ "; finalDecimal = " + finalDecimal);
				System.out.println();
				
			}
			
			if (i == 2){
				convertStep = valueOfHexChar * 16;
				finalDecimal += convertStep;
				System.out.println("i=3 convertStep = " + convertStep
						+ "; finalDecimal = " + finalDecimal);
				System.out.println();
				
			}
			
			if (i == 1){
				convertStep = valueOfHexChar * 256;
				finalDecimal += convertStep;
				System.out.println("i=3 convertStep = " + convertStep
						+ "; finalDecimal = " + finalDecimal);
				System.out.println();
				
			}
			
			if (i == 0){
				convertStep = valueOfHexChar * 4096;
				finalDecimal += convertStep;
				System.out.println("i=3 convertStep = " + convertStep
						+ "; finalDecimal = " + finalDecimal);
				System.out.println();
				System.out.println("Your finaldecimal = " +finalDecimal);
				
			}
			else{
				
			}
		}

	} // end of main
	
	private static int hexCharToInt(char c){
		int convertedInt = 0;
		
		switch(c) {
		
		case '0':
			convertedInt = 0;
			break;
			
		case '1':
			convertedInt = 1;
			break;
			
		case '2':
			convertedInt = 2;
			break;
			
		case '3':
			convertedInt = 3;
			break;
			
		case '4':
			convertedInt = 4;
			break;
			
		case '5':
			convertedInt = 5;
			break;
			
		case '6':
			convertedInt = 6;
			break;
			
		case '7':
			convertedInt = 7;
			break;
			
		case '8':
			convertedInt = 8;
			break;
			
		case '9':
			convertedInt = 9;
			break;
			
		case 'A':
			convertedInt = 10;
			break;
			
		case 'B':
			convertedInt = 11;
			break;
			
		case 'C':
			convertedInt = 12;
			break;
			
		case 'D':
			convertedInt = 13;
			break;
			
		case 'E':
			convertedInt = 14;
			break;
			
		case 'F':
			convertedInt = 15;
			break;
			
		}
		
		return convertedInt;
	}

}
