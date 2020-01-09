package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

enum Subject_Code {
	CS101, CS634, CS636, CS637, CS624, CS680, CS681, CS630, CS690
}

class Student {

	private String First_Name;
	private String Last_Name;
	private List<Subject_Code> subject;
	private double Grade;
	
	List<ArrayList<String>> ds= new ArrayList<ArrayList<String>>(); 
	public Student(String first_Name, String last_Name, List<Subject_Code> subject, double grade) {
		super();
		First_Name = first_Name;
		Last_Name = last_Name;
		this.subject = subject;
		Grade = grade;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public List<Subject_Code> getSubject() {
		return subject;
	}

	public double getGrade() {
		return Grade;
	}

	@Override
	public String toString() {

		Math.abs(0);
		return "Name: " + getFirst_Name() + " " + getLast_Name() + " Grade: " + getGrade() + " Subjects: "
				+ getSubject();
	
	}
}

class Students {
	List<Student> student_list = new ArrayList<Student>();

	public List<Student> getStudents() {

		student_list.add(new Student("Nihar", "Patel",
				Arrays.asList(Subject_Code.CS101, Subject_Code.CS634, Subject_Code.CS680, Subject_Code.CS637), 3.4));
		student_list.add(new Student("Kush", "Patel",
				Arrays.asList(Subject_Code.CS681, Subject_Code.CS634, Subject_Code.CS624, Subject_Code.CS630), 3.34));
		student_list.add(new Student("Kush", "Shah",
				Arrays.asList(Subject_Code.CS680, Subject_Code.CS636, Subject_Code.CS630, Subject_Code.CS637), 3.45));
		student_list.add(new Student("Vyom", "J",
				Arrays.asList(Subject_Code.CS101, Subject_Code.CS634, Subject_Code.CS680, Subject_Code.CS630), 3.56));
		student_list.add(new Student("Rish", "Cho",
				Arrays.asList(Subject_Code.CS101, Subject_Code.CS637, Subject_Code.CS680, Subject_Code.CS630), 3.8));
		student_list.add(new Student("Teja", "Rane",
				Arrays.asList(Subject_Code.CS680, Subject_Code.CS636, Subject_Code.CS680, Subject_Code.CS637), 3.5));
		student_list.add(new Student("Nirav", "Patel",
				Arrays.asList(Subject_Code.CS101, Subject_Code.CS634, Subject_Code.CS680, Subject_Code.CS637), 3.6));

		return student_list;
	}

}

public class Collections_Methods {

	public static void main(String[] args) {

		Students s = new Students();
		List<Student> Studentlist = s.getStudents();

		Studentlist.sort(Comparator.comparing(Student::getFirst_Name).thenComparing(Student::getLast_Name)
				.thenComparing(Student::getGrade));
		for (Student student : Studentlist) {
			System.out.println(student.toString());
		}
	}

}
