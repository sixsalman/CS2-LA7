package edu.wmich.cs1120.LA7.SKhanJKonkowski;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This contents of this class have been copied from the assignment paper.
 * 
 * @author Assignment Writer
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
		LinkedList<Course> courses = new LinkedList<Course>();
		BufferedReader fileIn = new BufferedReader(new FileReader("course.txt"));
		BufferedReader fileIn1 = new BufferedReader(new FileReader("request.txt"));
		IController control = new Controller(requestQueue, courses, fileIn, fileIn1);
		control.readCourseFile();
		control.readRequestFile();
		control.processRequests();
		control.printClassList();
	}

}
