package marchforarraylists;

import java.awt.List;
import java.util.ArrayList;

public class starthere {

	public static void main(String[] args) {
		ArrayList<String> namelist = new ArrayList<String>();
		
		namelist.add(0, "Cameron");
		namelist.add(1, "Roscoe");
		System.out.println(namelist);
		
		namelist.remove(0);
		System.out.println(namelist);
		
		

	}

}
