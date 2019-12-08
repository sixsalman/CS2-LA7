package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * Objects of this class store another object along with a reference along with
 * reference to another Node<> object.
 * 
 * @author M. Salman Khan & Jake Konkowski
 *
 * @param <E> can be an object of any class
 */
public class Node<E> implements INode<E> {

	private E dataValue;
	private Node<E> nextNode;

	/**
	 * Creates an object of the Node<> class, storing the received parameter
	 * 
	 * @param dataValue receives an object to store
	 */
	public Node(E dataValue) {
		this.dataValue = dataValue;
	}

	/**
	 * Creates an object of the Node<> class, storing the received parameters
	 * 
	 * @param dataValue dataValue receives an object to store
	 * @param nextNode  receives reference to the Node<E> object to be connected to
	 *                  this object
	 */
	public Node(E dataValue, Node<E> nextNode) {
		this.dataValue = dataValue;
		this.nextNode = nextNode;
	}

	@Override
	public E getData() {
		return this.dataValue;
	}

	@Override
	public Node<E> getNext() {
		return this.nextNode;
	}

	@Override
	public void setNext(Node<E> next) {
		this.nextNode = next;
	}

}
