import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Administrator {

	static ArrayList<Student> students = new ArrayList<Student>();
	static Map <Student, ArrayList<Course>> grades = new LinkedHashMap<Student, ArrayList<Course>>();
	public static void popStudentsWithCoursesAndGrades(String name, String id, String cname, String cname2, String cname3, String cname4, String cname5, 
			String cgrade, String cgrade2, String cgrade3, String cgrade4, String cgrade5){

		Student s = new Student(name,id);
		ArrayList<Course> sco = new ArrayList<Course>();
		sco.add(new Course(cname, cgrade));
		sco.add(new Course(cname2, cgrade2));
		sco.add(new Course(cname3, cgrade3));
		sco.add(new Course(cname4, cgrade4));
		sco.add(new Course(cname5, cgrade5));
		students.add(s);
		grades.put(s, sco);
	}

	public static void addStudents(){
		popStudentsWithCoursesAndGrades("BingLu", "2109988G", "AP3", "ALG3","IS3", "PSD3", "PL3", "A", "A", "A", "A", "A");
		popStudentsWithCoursesAndGrades("Joselyn", "2109992L", "AP3", "ALG3","IS3", "PSD3", "PL3", "A", "A", "A", "A", "A");
		popStudentsWithCoursesAndGrades("YongQuan", "2110025T", "AP3", "ALG3","IS3", "PSD3", "PL3", "A", "A", "A", "A", "A");
		popStudentsWithCoursesAndGrades("Terence", "2110003L", "AP3", "ALG3","IS3", "PSD3", "PL3", "A", "A", "A", "A", "A");
		popStudentsWithCoursesAndGrades("TingWen", "2109930T", "AP3", "ALG3","IS3", "PSD3", "PL3", "A", "A", "A", "A", "A");
	}

	public static void main (String[] arg) {

		addStudents();



		Scanner in = new Scanner(System.in);

		String mainmenu = ("Choose An Option: \n"
				+ "1. View Grades For One Student\n"
				+ "2. View All Students Grades\n"
				+ "3. Export Grades For One Student\n"
				+ "4. Export All Grades\n");
		
		
		System.out.println(mainmenu);

		int choice = in.nextInt();

		while (choice < 1 || choice > 4){
			System.out.print("\nError! Incorrect choice.\n");
			System.out.println(mainmenu);
			choice = in.nextInt();
		}
			
		switch(choice){
		case 1: {
		
			System.out.println("Select Student By Typing Student's Name: ");

			for (Student afterselect : students){
				ArrayList<Course> tempcourses = grades.get(afterselect);
				System.out.println(afterselect.getStudentName());
			}
			System.out.println("");
			String tempstud = in.next();
			System.out.println("Select Course By Typing Course Name: ");
			for (Student afterselect : students){
				if (afterselect.getStudentName().equalsIgnoreCase(tempstud)){
					ArrayList<Course> tempcourses = grades.get(afterselect);
					for (Course tc : tempcourses){
						System.out.println(tc.getcourseName());
					}
					String tempcourse = in.next();
					for (Course tcc : tempcourses){
						if(tcc.getcourseName().equalsIgnoreCase(tempcourse)){
							System.out.println(tcc.getcourseName() + ":" +" "+ tcc.getcourseGrade());
						}
					}
				}

			}

			break;
		}

		case 2:{
			for (Student temp : students) {
				ArrayList<Course> sco = grades.get(temp);
				System.out.println(" ");
				System.out.println(temp.getStudentName());
				for (Course c : sco) {
					System.out.println(c.getcourseName() + ": " + c.getcourseGrade());
				}

			}

			break;
		}

		case 3:{
			//System.exit(0);
		}
		
		}

		//in.close();




	}
}

