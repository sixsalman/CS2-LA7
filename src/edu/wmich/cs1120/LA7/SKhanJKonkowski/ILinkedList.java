package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * This interface has been copied from the assignment paper.
 * 
 * @author Assignment Writer
 *
 */
public interface ILinkedList<E> {
	/**
	 * Determine if the LinkedList is empty.
	 * @return true if the LinkedList is empty; false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Add object received to the linked list if he/she has the priority.
	 * @param item receives the object to be added
	 */
	public void add(E item);

	/**
	 * get the object in specific position in the LinkedList used to print the
	// enrolled student contents inside the Course class and return the name
	 * @param position receives position of the node whose data is to be returned
	 * @return data of the node whose position was received
	 */
	public E get(int position);

	/**
	 * Return number of elements in the list.
	 * @return number of nodes in the LinkedList
	 */
	public int size();

}
