
public interface Monster {
	
	
	/* RULES for "Interfaces"
	 * 1. Any variables must be CONSTANTS - only -
	 * 2. Methods have a "signature ONLY -- that means they have a name,
	 * but nothing inside!
	 * 3. You can NEVER instantiate an interface
	 * 3a. No constructor - because you never instantiate
	 */
	
	//public static final double PIFIXED = 3.14; // 1
	
	//public int methodABC();  // 2
	
	// Monster myMonster = new Monster() -- NO WAY!!
	
	public int getHowBig();
	public String getName();
	public boolean isBigger(Monster other);	
	public boolean isSmaller(Monster other);
	public boolean namesTheSame(Monster other);

}
