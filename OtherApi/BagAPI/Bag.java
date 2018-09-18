package BagAPI;

//see https://algs4.cs.princeton.edu/13stacks/ResizingArrayBag.java.html also

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
	
	private static class Node<T>{
		private T item;
		private Node<T> next;
	}

	private Node<T> first;
	private int size;
	
	public Bag(){
		first = null;
		size = 0;
	}
	
	public void add(T item){
		Node<T> oldFirst = first;
		first = new Node<T>();
		first.item = item;
		first.next = oldFirst;
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ListIterator(first);
	}
	
	class ListIterator implements Iterator<T> {

		private Node<T> current;
		
		public ListIterator(Node<T> first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current!=null;
		}
		
		@Override
		public void remove(){
			try {
				throw new UnsupportedOperation();
			} catch (UnsupportedOperation e) {
				System.out.println("remove() operation is not supported for the bag");
				e.printStackTrace();
			}
		}

		@Override
		public T next() {
			if(!hasNext()){
				try {
					throw new NoFurtherElementExists();
				} catch (NoFurtherElementExists e) {
					System.out.println("no additional elements present in the bag");
					e.printStackTrace();
				}
			}
			T item = current.item;
			current=current.next;
			return item;
		}

	}/*
	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		bag.add("a");
		bag.add("b");
		bag.add("c");
		System.out.println("size of the bag : "+bag.size());
		for(String s : bag){
			System.out.println(s);
		}

	}
*/

}


