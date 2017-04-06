import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int size;
		String name;
		
		//Monster myMonster = new Monster(); FORBIDDEN
		
		out.print("Enter 1st monster's name : ");
		name = keyboard.next();
		
		out.print("Enter 1st monster's size : ");
		size = keyboard.nextInt();
		
		Monster m0ne = new Skeleton(name, size); // you do this part
		
		out.print("Enter 2nd monster's name : ");
		name = keyboard.next();
		
		out.print("Enter 2nd monster's size : ");
		size = keyboard.nextInt();
		
		Monster mTwo = new Skeleton(name, size); // you do this part
		
		

	}

}
