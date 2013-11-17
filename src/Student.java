import java.util.ArrayList;

public class Student {
	
	private String studentName;
	private String studentID;
	private ArrayList<Course> courselist;
	
	public Student(String studentName, String studentID){
		this.studentName = studentName;
		this.studentID = studentID;
		this.courselist = new ArrayList<Course>();
	}
	
	public String getStudentName(){
		return studentName;
	}
	
	public void setStudentName(String n){
		studentName = n;
	}
	
	public String getStudentID(){
		return studentID;
	}
	
	public void setStudentID(String id){
		studentID = id;
	}
	
	public ArrayList<Course> getStudentCourse(){
		return courselist;
	}
	
	
	
}
