import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Problem {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("file.dat"));
		int times = file.nextInt(); // how many data sets
		file.nextLine(); // read an entire line, now chop into individual integers
		for (int zz = 0; zz < times; zz++) {
			int total = 0;
			int n = 0;
			Scanner chop = new Scanner(file.nextLine());
			while (chop.hasNextInt()) {
				
				int nextInt = chop.nextInt();
				total += nextInt;
				n += 1;
				// this is where you write the code calculate the parameter
			}
			double ave = (double) total / n;
			// syso "Here is your eagerly anticipated result!!!...
			// this is where you print out the parameter
			
			System.out.printf("Result is %.2f%n", ave);
			
		
		}
		file.close();
		// this is helpful for the NEXT project
		int minInt = Integer.MIN_VALUE;
		int maxInt = Integer.MAX_VALUE;
		System.out.println("smallest possible int = " + minInt);
		System.out.println("largest possible int = " + maxInt);
	}
}