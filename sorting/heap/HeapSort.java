package heap;

import java.util.Arrays;

class HS{

	public static <T extends Comparable<T>> void sort(T[] a) {
		
		int sizeOfArr = a.length;
		/*order/heapify the tree first-create a min-heap or max-heap*/
		for(int i=(sizeOfArr-1)/2;i>=0;i--){
			System.out.println(i);
			heapify(a,sizeOfArr,i);
		}
		
		//take the root and last element, swap them, reduce the size,heapify on the remaining nodes
		//root contains the min/max element(min-heap/max-heap)
		for(int i=sizeOfArr-1;i>=0;i--){
			T temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			
			sizeOfArr=sizeOfArr-1;
			heapify(a, sizeOfArr, 0); //heapifying top-down after swapping
		}
	}
	
	public static <T extends Comparable<T>> void heapify(T[] a,int sizeOfArr,int elementIndex) {
		
		int leftNodeIndex = 2*elementIndex+1;
		int rightNodeIndex = 2*elementIndex+2;
		int largestElementIndex=elementIndex;
		try{
			//for max-heap(for min heap we choose the smaller of left and right child)
		if(leftNodeIndex<sizeOfArr && a[leftNodeIndex].compareTo(a[largestElementIndex])>0){
			largestElementIndex=leftNodeIndex;
		}
		if(rightNodeIndex<sizeOfArr && a[rightNodeIndex].compareTo(a[largestElementIndex])>0){
			largestElementIndex=rightNodeIndex;
		}}catch(Exception e){
			e.printStackTrace();
		}
		
		if(largestElementIndex!=elementIndex){
			T temp = a[largestElementIndex];
			a[largestElementIndex] = a[elementIndex];
			a[elementIndex] = temp;
			heapify(a, sizeOfArr, largestElementIndex);
		}
	}
	
	
}
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[] = {"rohti","acdnk","zced","tnkds","aedcd","re","zfe","cre","rwe"};
				//Integer a[] = {34,23,54,12,76,7623};
				System.out.println(Arrays.toString(a));
				HS.sort(a);
				System.out.println(Arrays.toString(a));
	}

}
