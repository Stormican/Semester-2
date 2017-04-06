
public class NestedLoops {

	public static void main(String[] args) {

		int total = 0;
		for(int i = 1; i <= 5;i = i + 2)
			for(int x = 1; x<= i;x = x + 2)
				total = total + x;
		System.out.println(total);
		
	}

}
