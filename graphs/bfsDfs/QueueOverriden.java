package bfsDfs;

// https://algs4.cs.princeton.edu/41graph/Queue.java.html
	
import java.util.Iterator;
import java.util.NoSuchElementException;

class QueueOverridden<T> implements Iterable<T> {

	private class Node {
		Node next;
		T item;
	}

	public QueueOverridden(){
		head=null;
		tail=null;
		size=0;
	}
	
	public class MyQueueIterator implements Iterator<T> {

		private Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T item = current.item;
			current = current.next;
			return item;
		}

	}

	private Node head, tail;
	private int size;
	
	public boolean isEmpty() {
		return head == null;
	}

	public void enqueue(T item) {
		Node current = tail;
		tail = new Node();
		tail.next = null;// not compulsory
		tail.item = item;
		if (isEmpty()) {
			head = tail;
		} else {
			current.next = tail;
		}
		size++;
	}

	public T dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		T item = head.item;
		head = head.next;
		if (isEmpty()) {
			tail = null; //for garbage collection
		}
		size--;
		return item;
	}

	public int size(){
		return size;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyQueueIterator();
	}

}
