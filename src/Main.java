
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

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
		popStudentsWithCoursesAndGrades("BingLu", "2109988G", "AP3", "ALG3","IS3", "PSD3", "PL3", "A", "B", "C", "D", "E");
		popStudentsWithCoursesAndGrades("Joselyn", "2109992L", "AP3", "ALG3","IS3", "PSD3", "PL3", "B", "C", "D", "E", "A");
		popStudentsWithCoursesAndGrades("YongQuan", "2110025T", "AP3", "ALG3","IS3", "PSD3", "PL3", "C", "D", "E", "A", "B");
		popStudentsWithCoursesAndGrades("Terence", "2110003L", "AP3", "ALG3","IS3", "PSD3", "PL3", "D", "E", "A", "B", "C");
		popStudentsWithCoursesAndGrades("TingWen", "2109930T", "AP3", "ALG3","IS3", "PSD3", "PL3", "E", "A", "B", "C", "D");
	}

	public static void exportAll(String fname){

		try {
			FileWriter file = new FileWriter(fname);

			file.append("StudentID");
			file.append(",");
			file.append("StudentName");
			file.append(",");
			file.append("AP3");
			file.append(",");
			file.append("ALG3");
			file.append(",");
			file.append("IS3");
			file.append(",");
			file.append("PSD3");
			file.append(",");
			file.append("PL3");
			file.append("\n");

			for (Student all : students){
				ArrayList<Course> allc =  grades.get(all);
				file.append(all.getStudentID());
				file.append(",");
				file.append(all.getStudentName());
				file.append(",");
				for (Course c : allc){
					file.append(c.getcourseGrade());
					file.append(",");
				}
				file.append("\n");
			}
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void exportOne(String input, String fname){
		try{
			FileWriter file = new FileWriter(fname);

			file.append("StudentID");
			file.append(",");
			file.append("StudentName");
			file.append(",");
			file.append("AP3");
			file.append(",");
			file.append("ALG3");
			file.append(",");
			file.append("IS3");
			file.append(",");
			file.append("PSD3");
			file.append(",");
			file.append("PL3");
			file.append("\n");

			for (Student afterselect :students){
				if(afterselect.getStudentName().equalsIgnoreCase(input)){
					System.out.println(afterselect.getStudentName());
					ArrayList<Course> selco = grades.get(afterselect);
					file.append(afterselect.getStudentID());
					file.append(",");
					file.append(afterselect.getStudentName());
					file.append(",");
					for (Course studco : selco){
						file.append(studco.getcourseGrade());
						file.append(",");
					}
				}
			}

			file.flush();
			file.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}

	}

	public static void main (String[] args) {
		addStudents();
		gradesMenu();

	}



	public static void gradesMenu(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("GRADES MENU");
		System.out.println("Select your choice with the number that represents it.");
		System.out.println("1. View Grades For One Student");
		System.out.println("2. View All Students Grades");
		System.out.println("3. Export Grades For One Student");
		System.out.println("4. Export All Grades");
		System.out.println("5. Quit");

		int number = scanner.nextInt();
		if ((number > 0) && (number < 6)){
			selection(number);
		}else {
			System.err.println("Please select from choice 1 to 5\n");
			gradesMenu();
		}
		scanner.close();
	}
	public static void selection(int i){
		boolean exit = false;



		while (exit != true){
			Scanner scanner = new Scanner(System.in);

			switch(i){
			case 1:{

				System.out.println("Select Student By Typing Student's Name: ");

				for (Student afterselect : students){
					//ArrayList<Course> tempcourses = grades.get(afterselect);
					System.out.println(afterselect.getStudentName());
				}
				System.out.println("");
				String tempstud = scanner.next();
				System.out.println("Select Course By Typing Course Name: ");
				for (Student afterselect : students){
					if (afterselect.getStudentName().equalsIgnoreCase(tempstud)){
						ArrayList<Course> tempcourses = grades.get(afterselect);
						for (Course tc : tempcourses){
							System.out.println(tc.getcourseName());
						}
						String tempcourse = scanner.next();
						for (Course tcc : tempcourses){
							if(tcc.getcourseName().equalsIgnoreCase(tempcourse)){
								System.out.println(tcc.getcourseName() + ":" +" "+ tcc.getcourseGrade());
								System.out.println("");
							}
						}
					}

				}
				gradesMenu();
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
				System.out.println("");
				gradesMenu();
				break;

			}

			case 3:{
				System.out.println("Choose A Student: ");
				
				for (Student all : students){
					System.out.println(all.getStudentName());
				}
				String input = scanner.next();
				exportOne(input, input + ".csv");
				System.out.println("Export Successful!");
				System.out.println("");
				gradesMenu();
				break;
			}


			case 4:{
				exportAll("AllGrades.csv");
				System.out.println("Export Successful!");
				System.out.println("");
				gradesMenu();
				break;
			}
			case 5:{
				// Quit
				exit = true;
				System.out.println("You are now exiting the program.");
				break;
			}
			
			}
		}
	}
}
