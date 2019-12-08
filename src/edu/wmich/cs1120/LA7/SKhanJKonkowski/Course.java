package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * Objects of this class store information related to a course, determine
 * whether the course is full, add a student to it, print the list of enrolled
 * students and check themselves for equivalence other Course objects.
 * 
 * @author M. Salman Khan & Jake Konkowski
 *
 */
public class Course implements ICourse {

	private String courseDept;
	private int courseNumber;
	private int capacity;
	private LinkedList<String> studentList;

	/**
	 * Creates an object of the Course class storing all the received parameters
	 * 
	 * @param courseDept   receives department of the course that the student is to
	 *                     be added to
	 * @param courseNumber receives number of the course that the student is to be
	 *                     added to
	 * @param capacity     receives capacity of the course
	 */
	public Course(String courseDept, int courseNumber, int capacity) {
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.capacity = capacity;
		studentList = new LinkedList<>();
	}

	@Override
	public boolean isFull() {
		if (studentList.size() == this.capacity) {
			return true;
		}
		
		return false;
	}

	@Override
	public void addStudent(String name) {
		if (!this.isFull()) {
			this.studentList.add(name);
		}
	}

	@Override
	public void printClassList() {
		System.out.printf("Class List for %s %d\n", this.courseDept, this.courseNumber);
		System.out.println(this.studentList);
	}

	/**
	 * Gets course's department
	 * 
	 * @return department of the course that the student is to be added to
	 */
	public String getCourseDept() {
		return this.courseDept;
	}

	/**
	 * Gets course's number
	 * 
	 * @return number of the course that the student is to be added to
	 */
	public int getCourseNumber() {
		return this.courseNumber;
	}


	@Override
	public boolean equals(Object arg0) {
		if (this == arg0)
			return true;
		if (arg0 == null)
			return false;
		if (getClass() != arg0.getClass())
			return false;
		Course other = (Course) arg0;
		if (capacity != other.capacity)
			return false;
		if (courseDept == null) {
			if (other.courseDept != null)
				return false;
		} else if (!courseDept.equals(other.courseDept))
			return false;
		if (courseNumber != other.courseNumber)
			return false;
		return true;
	}

}
