package main.java.com.solvd.doublyLinkedList;
import java.util.Iterator; 

public class ListIterator<E> implements Iterator<E>{
	private Node<E> current; 

	public ListIterator(DoublyLinkedList<E> list) {
		super();
		this.current = list.getHead();
	}

	@Override
	public boolean hasNext() { 
        return current != null; 
    } 

	@Override
	public E next() { 
        E data = current.getValue(); 
        current = current.getNext(); 
        return data; 
    } 

}
