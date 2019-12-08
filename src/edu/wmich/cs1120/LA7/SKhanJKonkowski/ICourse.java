package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * This interface has been copied from the assignment paper.
 * 
 * @author Assignment Writer
 *
 */
public interface ICourse {
	/**
	 * Determine if the capacity for this course has been reached.
	 * 
	 * @return true is the course if full; false otherwise
	 */
	boolean isFull();

	/**
	 * Add this student to the linkedlist for enrolled students for this course.
	 * 
	 * @param name receives name of the student to add
	 */
	void addStudent(String name);

	/**
	 * Print the classlist for this course.
	 */
	void printClassList();

	/**
	 * Determines if this course object is the same as the object received as
	 * parameter.
	 * @param arg0 receives the object to compare
	 * @return true if the objects contain equivalent information; false otherwise
	 */
	boolean equals(Object arg0);
}
