package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * This interface has been copied from the assignment paper.
 * 
 * @author Assignment Writer
 *
 */
public interface INode<E> {
	/**
	 * Returns the data stored in this node.
	 * 
	 * @return data contained in the node
	 */
	E getData();

	// Returns the node next to this node.
	/**
	 * Returns the node next to this node.
	 * 
	 * @return the next node
	 */
	Node<E> getNext();

	/**
	 * Sets node received as the next node to this node.
	 * 
	 * @param next receives node to set as next
	 */
	void setNext(Node<E> next);
}
