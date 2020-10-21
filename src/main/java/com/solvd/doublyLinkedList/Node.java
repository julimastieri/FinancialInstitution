package main.java.com.solvd.doublyLinkedList;


public class Node<E> {
	private E value;
	private Node<E> previous;
	private Node<E> next;
	
	public Node() {}

	public Node(E value) {
		this.value = value;
	}

	public Node(E value, Node<E> previous, Node<E> next) {
		super();
		this.value = value;
		this.previous = previous;
		this.next = next;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Node<E> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
	
}