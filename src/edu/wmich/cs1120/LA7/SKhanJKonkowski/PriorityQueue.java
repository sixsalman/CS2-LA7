package edu.wmich.cs1120.LA7.SKhanJKonkowski;

/**
 * Objects of this class enqueue-considering priority-, dequeue and print data
 * from itself.
 * 
 * @author M. Salman Khan & Jake Konkowski
 *
 * @param <E> can be an object of any class that implements the Comparable<>
 *            interface
 */
public class PriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {

	private Node<E> front;

	@Override
	public boolean isEmpty() {
		return (front == null);
	}

	@Override
	public void enqueue(E data) {
		if (front == null) {
			front = new Node<E>(data);
		} else if (data.compareTo(front.getData()) >= 0) {
			front = new Node<E>(data, front);
		} else {
			Node<E> toCheck = front;
			boolean added = false;
			while (toCheck.getNext() != null && !added) {
				if (data.compareTo(toCheck.getNext().getData()) >= 0) {
					toCheck.setNext(new Node<E>(data, toCheck.getNext()));
					added = true;
				} else {
					toCheck = toCheck.getNext();
				}
			}
			if (!added)
				toCheck.setNext(new Node<E>(data));
		}
	}

	@Override
	public E dequeue() {
		Node<E> toReturn = front;
		front = front.getNext();
		return toReturn.getData();
	}

	@Override
	public void Qprint() {
		System.out.println("<<<<<<<<<<<< Beginning of Queue Contents >>>>>>>>>>>>>>>>>");
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			Node<E> toPrint = front;
			while (toPrint != null) {
				System.out.println(toPrint.getData().toString().substring(37));
				toPrint = toPrint.getNext();
			}
		}
		System.out.println("<<<<<<<<<<<< End of Queue Contents >>>>>>>>>>>>>>>>>");
	}

}
