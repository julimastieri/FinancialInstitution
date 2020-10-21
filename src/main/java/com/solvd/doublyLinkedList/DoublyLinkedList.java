package main.java.com.solvd.doublyLinkedList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class DoublyLinkedList<E> implements Collection<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public DoublyLinkedList() {
	}

	public Node<E> getHead() {
		return head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public int getSize() {
		return size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object obj) {
		for (E e : this) {
			if (e.equals(obj))
				return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator<E>(this);
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[this.getSize()];
		int i = 0;
		for (E e : this) {
			result[i] = e;
			i++;
		}
		return result;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		a = Arrays.copyOf(a, this.getSize());
		int i = 0;
		for (E e : this) {
			a[i] = (T) e;
			i++;
		}
		return a;
	}

	@Override
	public boolean add(E e) {
		Node<E> add = new Node<E>(e);

		if (size == 0) {
			head = add;
		} else {
			tail.setNext(add);
			add.setPrevious(tail);
		}
		tail = add;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		Node<E> i = head;
		while (i != null) {
			if (i.getValue().equals(obj)) {
				if (i.getPrevious() != null)
					i.getPrevious().setNext(i.getNext());
				else
					head = i.getNext();

				if (i.getNext() != null)
					i.getNext().setPrevious(i.getPrevious());
				else
					tail = i.getPrevious();

				size--;
				return true;
			}
			i = i.getNext();
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object obj : c)
			if (!this.contains(obj))
				return false;

		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean modified = false, added = false;
		for (E e : c) {
			added = this.add(e);
			modified = modified || added;
		}

		return modified;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean modified = false, removed = false;
		for (Object o : c) {
			removed = this.remove(o);
			modified = modified || removed;
		}
		return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean modified = false , removed = false;
		for (Object o : this) {
			if (!c.contains(o)) {
				removed = this.remove(o);
				modified = modified || removed;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

}
