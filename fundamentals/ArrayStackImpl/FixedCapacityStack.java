package ArrayStackImpl;

//    see also https://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html
import java.util.Arrays;
//https://algs4.cs.princeton.edu/13stacks/FixedCapacityStack.java.html
import java.util.Iterator;

public class FixedCapacityStack<T> implements Iterable<T> {

	private T[] a;
	private int size;

	public FixedCapacityStack(int capacity) {
		// a = (T[]) new Object[capacity];
		a = (T[]) new Object[capacity];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == a.length;
	}

	public void push(T item) {
		if (size == a.length) {
			resize(2 * a.length);
		}
		a[size++] = item;
	}

	private void resize(int capacity) {
		a = Arrays.copyOf(a, capacity);
		
		/*T[] temp = (T[]) new Object[capacity];
		for(int i=0;i<a.length;i++){
			temp[i]=a[i];
		}
		a=temp;*/
	}

	public T pop() {
		if(size>0&&size==a.length/4){
			resize(a.length/2);
		}
		return a[--size];
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}

	public class ArrayIterator implements Iterator<T> {

		private int i = size - 1;

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@Override
		public T next() {
			return a[i--];
		}

	}

	public static void main(String[] args) {
		FixedCapacityStack<String> fcs = new FixedCapacityStack<>(10);
		String a[] = { "to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is" };
		for (String s : a) {
			if (!s.equals("-")) {
				fcs.push(s);
			} else if (fcs.isEmpty()) {
				System.out.println("bad input");
			} else {
				fcs.pop();
			}
		}
		for (String s : fcs) {
			System.out.println(s);
		}
	}

}
