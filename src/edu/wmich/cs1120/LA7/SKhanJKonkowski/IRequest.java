package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * This interface has been copied from the assignment paper.
 * 
 * @author Assignment Writer
 *
 */
public interface IRequest {
	/**
	 * Returns number of years to graduation (0 for seniors, 1 for juniors etc.).
	 * This is determined from the student’s level – senior, junior, etc.
	 * 
	 * @param level receives student's level(year)
	 * @return number of years that the student is away from graduation
	 */
	public int yearsFromGraduation(String level);

	// Calculate the GPA for a particular student.
	// private double GPA_Cal(double[][] GPA_Array);

}
