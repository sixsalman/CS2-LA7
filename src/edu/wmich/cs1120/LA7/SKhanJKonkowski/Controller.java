package edu.wmich.cs1120.LA7.SKhanJKonkowski;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Date: 11/13/2019 CS1120-545 LA7 Objects of this class read and store courses
 * and requests, add students to courses in accordance with the stored
 * requests, and print class lists too.
 * 
 * @author M. Salman Khan & Jake Konkowski
 *
 */
public class Controller implements IController {

	private PriorityQueue<Request> requestQueue;
	private LinkedList<Course> courses;
	private BufferedReader fileIn;
	private BufferedReader fileIn1;

	private String thisLine;
	private String[] requestDetails;
	private double[][] GPA_Array;
	private Request toProcess;

	/**
	 * Creates an object of the Controller class storing all the received parameters
	 * 
	 * @param requestQueue receives a queue to add requests to
	 * @param courses      receives a linked list to add courses to
	 * @param fileIn       receives the file to read courses from
	 * @param fileIn1      receives the file to read requests from
	 */
	public Controller(PriorityQueue<Request> requestQueue, LinkedList<Course> courses, BufferedReader fileIn,
			BufferedReader fileIn1) {
		this.requestQueue = requestQueue;
		this.courses = courses;
		this.fileIn = fileIn;
		this.fileIn1 = fileIn1;
	}

	@Override
	public void readCourseFile() {
		try {
			thisLine = fileIn.readLine();
			while (thisLine != null) {
				System.out.println(thisLine);
				String[] courseDetails = thisLine.split(",");
				courses.add(new Course(courseDetails[0], Integer.parseInt(courseDetails[1]),
						Integer.parseInt(courseDetails[2])));
				thisLine = fileIn.readLine();
			}
			fileIn.close();
		} catch (IOException e) {
			System.out.println("An error occurred\nThe program will now quit");
			System.exit(1);
		}
	}

	@Override
	public void readRequestFile() {
		try {
			thisLine = fileIn1.readLine();
			while (thisLine != null) {
				requestDetails = thisLine.split(",");
				GPA_Array = new double[4][2];
				int j = 0;
				for (int i = 6; i < requestDetails.length; i++) {
					if (i % 2 == 0) {
						GPA_Array[j][0] = Double.parseDouble(requestDetails[i]);
					} else {
						GPA_Array[j][1] = Double.parseDouble(requestDetails[i]);
						j++;
					}
				}
				addRequest(new Request(requestDetails[0], requestDetails[2], requestDetails[1], requestDetails[3],
						Integer.parseInt(requestDetails[4]), GPA_Array));
				thisLine = fileIn1.readLine();
			}
			fileIn1.close();
			System.out.print("\n");
			requestQueue.Qprint();
			System.out.print("\n");
		} catch (IOException e) {
			System.out.println("An error occurred\nThe program will now quit");
			System.exit(2);
		}
	}

	@Override
	public void addRequest(Request req) {
		requestQueue.enqueue(req);
	}

	@Override
	public void processRequests() {
		while (!requestQueue.isEmpty()) {
			toProcess = requestQueue.dequeue();
			System.out.printf("%s processed.\n", toProcess.toString().substring(37));
			Course toAddto = getCourse(toProcess.getCourseDept(), toProcess.getCourseNumber());
			if (toAddto != null && !toAddto.isFull()) {
				toAddto.addStudent(toProcess.getStudentName());
				System.out.printf("%s successfully registered %s %d\n", toProcess.getStudentName(),
						toProcess.getCourseDept(), toProcess.getCourseNumber());
			} else {
				System.out.printf("%s cannot register for %s %d\n", toProcess.getStudentName(),
						toProcess.getCourseDept(), toProcess.getCourseNumber());
			}
		}
		System.out.print("\n");
		requestQueue.Qprint();
		System.out.print("\n");
	}

	@Override
	public Course getCourse(String courseDept, int courseNumber) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseDept().equals(courseDept) && courses.get(i).getCourseNumber() == courseNumber)
				return courses.get(i);
		}
		return null;
	}

	@Override
	public void printClassList() {
		System.out.print("\n");
		for (int i = 0; i < courses.size(); i++) {
			courses.get(i).printClassList();
		}
	}

}
