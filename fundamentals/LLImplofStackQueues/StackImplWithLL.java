package LLImplofStackQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

class StackWithLL<T> implements Iterable<T>{
	
	public StackWithLL(){
		TOP = null;
		size=0;
	}
	
	private class Node{
		Node next;
		T item;
	}
	
	private class StackWithLLIterator implements Iterator<T> {
		
		private Node current;

		public StackWithLLIterator(Node TOP) {
			current=TOP;
		}

		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public T next() {
			T item = current.item;
			current=current.next;
			return item;
		}

	}
	
	private Node TOP;
	private int size;
	
	public boolean isEmpty(){
		return TOP==null;
	}
	
	public int size(){
		return size;
	}
	
	public T peek(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return TOP.item;
	}
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(T t : this){
			s.append(t);
			s.append(" ");
		}
		return s.toString();
	}
	
	public void push(T item){
		Node current = TOP;
		TOP=new Node();
		TOP.next=current;
		TOP.item = item;
		size++;
	}
	
	public T pop(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		T item = TOP.item;
		TOP=TOP.next;
		size--;
		return item;
	}
	public void print(){
		
		/*Node current = TOP;
		while(current!=null){
			System.out.println(current.item);
			current=current.next;
		}*/
		
		/*for(Node current = TOP;current!=null;current=current.next){
			System.out.println(current.item);
		}*/
		
	}

	@Override
	public Iterator<T> iterator() {
		return new StackWithLLIterator(TOP);
	}
}

public class StackImplWithLL {
	
	public static void main(String args[]){
		StackWithLL<Integer> abc = new StackWithLL<Integer>();
		abc.push(10);
		abc.push(20);
		abc.push(30);
		abc.push(40);
		//abc.pop();
		//abc.print();
		System.out.println(abc.size());
		for(Integer i : abc){
			System.out.println(i);
		}
		//System.out.println(abc.toString());
		//System.out.println(abc.iterator().next());
		
		
	}

}
