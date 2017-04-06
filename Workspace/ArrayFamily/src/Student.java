
public class Student {
	
	
	private String fname;
	private String lname;
	private int gradeInSchool;
	
	
	public Student(String firstname, String lastname, int grade){
		this.fname = firstname;
		this.lname = lastname;
		this.gradeInSchool = grade;
	}
		
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getGradeInSchool() {
		return gradeInSchool;
	}
	public void setGradeInSchool(int gradeInSchool) {
		this.gradeInSchool = gradeInSchool;
	}
	
	

}
