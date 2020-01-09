package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student1 {
	private String name;
	private double cgpa;
	private int id;

	public Student1(String name, double cgpa, int id) {
		this.name = name;
		this.cgpa = cgpa;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public int getId() {
		return id;
	}
}

class Priorities {
	private PriorityQueue<Student1> pq;

	public Priorities() {
		this.pq = new PriorityQueue<>(
				Comparator.comparing(Student1::getCgpa).thenComparing(Student1::getName).thenComparing(Student1::getId));
	}

	public List<Student1> getStudents(List<String> events) {
		
		for(String s : events) {
			String[] event = s.split(" ");
			if(event[0] == "ENTER") {
				pq.add(new Student1(event[1], Double.valueOf(event[2]), Integer.valueOf(event[3])));
			}
			else pq.remove();
		}
			return new ArrayList<Student1>(pq);
	}
}

public class PriorityQueueJava8 {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student1> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student1 st : students) {
				System.out.println(st.getName());
			}
		}
	}
}