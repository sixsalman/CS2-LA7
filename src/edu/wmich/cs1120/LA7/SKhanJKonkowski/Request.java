package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * Objects of this class store information related to a request, determine years
 * that the requesting student is away from graduation and compare themselves
 * with other Request objects in terms of priority.
 * 
 * @author M. Salman Khan & Jake Konkowski
 *
 */
public class Request implements IRequest, Comparable<Request> {

	private String studentName;
	private String studentDept;
	private String studentLevel;
	private String courseDept;
	private int courseNumber;
	private double[][] GPA_Array;

	/**
	 * Creates an object of the Request class storing all the received parameters
	 * 
	 * @param studentName  receives name of the requesting student
	 * @param studentDept  receives department(major) of the requesting student
	 * @param studentLevel receives academic level(year) of the requesting student
	 * @param courseDept   receives department of the course that the student is to
	 *                     be added to
	 * @param courseNumber receives number of the course that the student is to be
	 *                     added to
	 * @param GPA_Array    receives a two-dimensional array that contains credits
	 *                     and grades for courses
	 */
	public Request(String studentName, String studentDept, String studentLevel, String courseDept, int courseNumber,
			double[][] GPA_Array) {
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.GPA_Array = GPA_Array;
	}

	/**
	 * Gets student's name
	 * 
	 * @return name of the requesting student
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * Gets student's department
	 * 
	 * @return department(major) of the requesting student
	 */
	public String getStudentDept() {
		return studentDept;
	}

	/**
	 * Gets course's department
	 * 
	 * @return department of the course that the student is to be added to
	 */
	public String getCourseDept() {
		return courseDept;
	}

	/**
	 * Gets course's number
	 * 
	 * @return number of the course that the student is to be added to
	 */
	public int getCourseNumber() {
		return courseNumber;
	}

	@Override
	public int yearsFromGraduation(String level) {
		switch (level.toLowerCase().trim()) {
		case "freshman":
			return 3;
		case "sophomore":
			return 2;
		case "junior":
			return 1;
		case "senior":
			return 0;
		}
		return -1;
	}

	/**
	 * Calculate the GPA for a particular student.
	 * 
	 * @param GPA_Array receives a two-dimensional array that contains credits and
	 *                  grades for courses
	 * @return calculated GPA
	 */
	private double GPA_Cal(double[][] GPA_Array) {
		double sumOfCreditsMultGrade = 0;
		for (int i = 0; i < GPA_Array.length; i++) {
			sumOfCreditsMultGrade += GPA_Array[i][0] * GPA_Array[i][1];
		}
		double totCredits = 0;
		for (int i = 0; i < GPA_Array.length; i++) {
			totCredits += GPA_Array[i][1];
		}
		return (sumOfCreditsMultGrade / totCredits);
	}

	@Override
	public int compareTo(Request other) {
		if ((studentDept.equals(courseDept) && (other.studentDept).equals(other.courseDept))
				|| !studentDept.equals(courseDept) && !other.studentDept.equals(other.courseDept)) {
			if (yearsFromGraduation(studentLevel) == yearsFromGraduation(other.studentLevel)) {
				if (GPA_Cal(GPA_Array) == GPA_Cal(other.GPA_Array)) {
					return 0;
				} else if (GPA_Cal(GPA_Array) > GPA_Cal(other.GPA_Array)) {
					return 1;
				} else if (GPA_Cal(GPA_Array) < GPA_Cal(other.GPA_Array)) {
					return -1;
				}
			} else if (yearsFromGraduation(studentLevel) < yearsFromGraduation(other.studentLevel)) {
				return 1;
			} else if (yearsFromGraduation(studentLevel) > yearsFromGraduation(other.studentLevel)) {
				return -1;
			}
		} else if (studentDept.equals(courseDept) && !((other.studentDept).equals(other.courseDept))) {
			return 1;
		}
		return -1;

	}

}
