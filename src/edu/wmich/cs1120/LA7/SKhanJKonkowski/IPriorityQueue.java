package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * This interface has been copied from the assignment paper.
 * 
 * @author Assignment Writer
 *
 */
public interface IPriorityQueue<E extends Comparable<E>> {
	/**
	 * Determine if the priority queue is empty.
	 * @return true if the queue is empty; false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Add object received to the priority queue taking into consideration the rules
	 * governing priority.
	 * @param data receives data to be added to the queue
	 */
	public void enqueue(E data);

	/**
	 * Remove the next object to be processed from the priority queue.
	 * @return the next object to be processed
	 */
	public E dequeue();

	/**
	 * Print the contents of the queue
	 */
	public void Qprint();
}
