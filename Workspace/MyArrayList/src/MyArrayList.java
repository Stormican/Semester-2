import java.util.ArrayList;

public class MyArrayList {

	public static void main(String[] args) {
		
		// arrays -- fast, simple, BUT they have a FIXED size!
		// Oh No!!!!!
		
		String [] myStringArray = new String[6];
		myStringArray[0] = "Java";
		System.out.println("Show: " + myStringArray[0]);
		
		// ArrayList is --- dynamic!!!! -----
		// re-size on the fly, while the program is running!
		// ArrayList --- NO, as in NEVER use [] !!!!
		// ArrayList you ALWAYS, as in REALLY ALWAYS use methods!
		
		ArrayList <String> ala = new ArrayList <String> ();
		
		ala.add("Idaho");
		ala.add("Oregon");
		ala.add(1, "Washington");
		System.out.println("Index of Oregon: " + ala.indexOf("Oregon"));
		System.out.println("String at index 0: " + ala.get(0));
		System.out.println("Size (length): " + ala.size());
		ala.remove(1);
		
		System.out.println(); // put a space between prints
		for (int i = 0; i < ala.size(); i++){
			System.out.println("AL at index: " + i + ", is: " + ala.get(i));
		}
		ala.add(1, "Washington");
		System.out.println(); // put a space between prints
		for (int i = 0; i < ala.size(); i++){
			System.out.println("AL at index: " + i + ", is: " + ala.get(i));
		}
		
		
		ArrayList alb = new ArrayList();
		
		
		alb.add("Utah");
		alb.add(25.5);
		alb.add(10);
		System.out.println(); // put a space between prints
		for (int i = 0; i < alb.size(); i++){
			System.out.println("AL at index: " + i + ", is: " + alb.get(i));
		}
		
	
	} // end of main

} // end of class
