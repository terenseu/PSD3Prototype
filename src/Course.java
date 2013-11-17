
public class Course {
	private String courseName;
	private String courseGrade;
	
	public Course(String courseName, String courseGrade){
		this.courseName = courseName;
		this.courseGrade = courseGrade;
	}
	
	public String getcourseName(){
		return courseName;
	}
	
	public void setCourseName(String cn){
		courseName = cn;
	}
	
	public String getcourseGrade(){
		return courseGrade;
	}
	
	public void setcourseGrade(String cg){
		courseGrade = cg;
	}
}
