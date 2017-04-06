import java.util.Scanner;

public class Runner {
	// global scope
	
	/*
	 * graded assignment
	 * use scanner to read a keyboard, ask
	 * syso "Select a student at random (s), or quit (q)
	 * now, scanner is ready to read keyboard input
	 * if(s) --> select a random student
	 * if(q) --> exit the program
	 * 
	 * when a student is selected, syso the first name and last initial
	 * use string methods, like ArrayName[i].indexof()...etc
	 * example
	 * Roscoe A
	 * Alex D
	 * Peter H
	 * 
	 * !! ARRAY MUST CONTAIN FULL NAME -- Roscoe Ambrose --!!
	 */
	
	Scanner keyboard = new Scanner(System.in);
	
	
	public Runner(){
		
	}

	public static void main(String[] args) {
		Student[] classB4 = new Student[18]; 
		// local scope
		Runner myStudents = new Runner();
		myStudents.fillArray(classB4);
		
		for(int i = 0; i < classB4.length; i++){
			//System.out.println("Index: " + i + ", name: " + classB4[i].getFullname());
			
		}
		
		// YEA! It works ---- so far....
		myStudents.getRandomStudent(classB4);
		
	}

	private void getRandomStudent(Student[] classB4) {
		//int index;
		
		
		
		// Math.random() * 17;
		//for(int i = 0; i < 100; i++){
			// (int) is "type casting" drops the decimal point
			//index = (int) (Math.random()*18.0);
			//System.out.println(index);
		}
		
	//}

	private void fillArray(Student[] classB4) {
		
		classB4[0] = new Student("Drake Mocabey");
		classB4[1] = new Student("Roscoe Ambrose");
		classB4[2] = new Student("Cameron Storm");
		classB4[3] = new Student("Tristan Woodside");
		classB4[4] = new Student("Brandon Christensen");
		classB4[5] = new Student("Toby Brown");
		classB4[6] = new Student("Peter Cai");
		classB4[7] = new Student("Tyler Hartman");
		classB4[8] = new Student("Daniel McCrady");
		classB4[9] = new Student("Alex Davis");
		classB4[10] = new Student("Moises Mares");
		classB4[11] = new Student("Tyler Chilcote");
		classB4[12] = new Student("Chase Maxfield");
		classB4[13] = new Student("Norman Jackman");
		classB4[14] = new Student("Tyler Qualls");
		classB4[15] = new Student("Taylor Mashburn");
		classB4[16] = new Student("Andrew Heiden");
		classB4[17] = new Student("Peter Haase");
		
		//for(int i = 0; i < classB4.length; i++)
		//System.out.println(classB4[i].getFullname());
		
		
		
	}

}
