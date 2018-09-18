package heap;

import java.util.Arrays;

//https://algs4.cs.princeton.edu/24pq/Heap.java.html
//https://algs4.cs.princeton.edu/24pq/MinPQ.java.html
//https://algs4.cs.princeton.edu/24pq/MaxPQ.java.html

class minHeap{
	
	
	private int capacity=5;
	private int size=0;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex){ return 2*parentIndex+1; }
	private int getRightChildIndex(int parentIndex){ return 2*parentIndex+2; }
	private int getParentIndex(int childIndex){ return (childIndex-1)/2; }
	
	private boolean hasLeftChild(int index){ return getLeftChildIndex(index)<size; }
	private boolean hasRightChild(int index){ return getRightChildIndex(index)<size; }
	private boolean hasParent(int index){ return getParentIndex(index)>=0; }
	
	private int leftChild(int index){ return items[getLeftChildIndex(index)]; }
	private int rightChild(int index){ return items[getRightChildIndex(index)]; }
	private int parent(int index){ return items[getParentIndex(index)]; }
	
	private void ensureCapacity(){
		if(size==capacity){
			items = Arrays.copyOf(items, capacity*2);
			capacity = capacity*2;
		}
	}
	
	private void swap(int indexOne, int indexTwo){
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	public int peek(){
		if(size==0){
			throw new IllegalStateException();
		}
		return items[0];
	}
	

	//*********************************************add element and heapify up*********************************************************************
	
	public void add(int elementToBeAdded){
		ensureCapacity();
		items[size] = elementToBeAdded;  //add element to the array in the last position: size
		size++;
		heapifyUp();
	}
	
	public void heapifyUp()//swim
	{
		int index = size - 1; //starts with the last index, size-1, as the size currently is size++
		while(hasParent(index) && parent(index)>items[index]){ // as long there is a parent && the parent is greater than me
			swap(getParentIndex(index),index);					//swap me and my parent
			index = getParentIndex(index);						//move upwards recursively; the parent index is now my current index
		}
	}
	
	//*****************************************************************************************************************************************
	
	//extracts the minimum element and removes it from the array
	public int poll(){
		if(size==0){
			throw new IllegalStateException();
		}
		int temp = items[0]; //storing the item in a variable
		items[0] = items[size-1]; //storing the leaf(last element : size-1) into the root
		size--; //reducing the size
		//this way we can remove the value stored in the root
		heapifyDown(); //while removing we go top-down
		return temp;
	}
	
	
	
	public void heapifyDown()//sink
	{
		int index=0; //start with the root
		//we are checking only for leftchildindex because if the parent doesnt have a left child, then it cant have right child
		while(hasLeftChild(index)){
			//take the element, compare with its left and right child and swap it with the smaller of the them
//if max heap,take the element, compare with its left and right child and swap it with the larger of the them
			int smallerChildIndex = 0; 
			if(hasRightChild(index) && rightChild(index) < leftChild(index)){
				smallerChildIndex = getRightChildIndex(index);
			}
			else{
				smallerChildIndex = getLeftChildIndex(index);
			}
			
			if(items[index] < items[smallerChildIndex]){ //if i'm smaller than my children, then everything is fine so break
				break;
			}else{
				swap(index,smallerChildIndex);//else I need to swap my value with the smaller child 
			}
			index = smallerChildIndex; //i am moving down to the smaller child index which will be my current index
		}
	}
	
	public void print(){
		System.out.println(Arrays.toString(items));
	}
}

public class HeapImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minHeap mh = new minHeap();
		mh.add(20);
		mh.add(30);
		mh.add(12);
		mh.add(45);
		mh.add(50);
		mh.print();
		System.out.println(mh.poll());
		mh.print();
		
	}

}
