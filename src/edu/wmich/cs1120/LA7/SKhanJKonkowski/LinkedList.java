package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * Objects of this class determine whether the linked list is empty, add new
 * items to it and get its size and items at specific positions from it.
 * 
 * @author M. Salman Khan & Jake Konkowski
 *
 * @param <E> can be an object of any class
 */
public class LinkedList<E> implements ILinkedList<E> {

	private Node<E> first;
	private int size = 0;

	@Override
	public boolean isEmpty() {
		if (this.first == null) {
			return true;
		}
		
		return false;
	}

	@Override
	public void add(E item) {
		if (this.first == null) {
			this.first = new Node<>(item);
		} else {
			Node<E> toCheck = this.first;
			while (toCheck.getNext() != null) {
				toCheck = toCheck.getNext();
			}
			toCheck.setNext(new Node<>(item));
		}
		size++;
	}

	@Override
	public E get(int position) {
		Node<E> toReturn = this.first;
		for(int i = 0; i < position; i++) {
			toReturn = toReturn.getNext();
		}
		
		return toReturn.getData();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder toReturn = new StringBuilder("");
		Node<E> toPrint = this.first;
		while (toPrint != null) {
			toReturn.append(toPrint.getData() + "\n");
			toPrint = toPrint.getNext();
		}
		return toReturn.toString();
	}

}
