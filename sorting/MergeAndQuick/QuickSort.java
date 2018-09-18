package MergeAndQuick;
//   https://algs4.cs.princeton.edu/23quicksort/QuickX.java.html
import java.util.Arrays;

class QS{

	public static <T extends Comparable<T>> void sort(T[] a) {
		sort(a,0,a.length-1);		
	}

	private static <T extends Comparable<T>> void sort(T[] a, int left, int right) {
		/*if(left>=right){
			return;
		}*/
		if(left<right){
			insertionSort(a, left, right);
		int pivotIndex = (left+right)/2;
		int partitionIndex = partition(a,left,right,pivotIndex);
		sort(a,left,partitionIndex-1);
		sort(a,partitionIndex,right);
		}
	}
	
	private static <T> void insertionSort(Comparable<T>[] a, int leftStart, int rightEnd) {
		for(int i=0;i<a.length;i++){
			for(int j = i;j>=0 && (j<j-1); j--){
				Comparable<T> temp = a[i];
				a[i] = a[j];
				a[j]=temp;
			}
		}
		
	}
	private static <T extends Comparable<T>> int partition(T[] a, int left, int right, int pivotIndex) {
		while(left<=right){
			while(a[left].compareTo(a[pivotIndex])<0){
				left++;
			}
			while(a[right].compareTo(a[pivotIndex])>0){
				right--;
			}
			if(left<=right){
				swap(a,left,right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static <T> void swap(T[] a, int left, int right) {
		T temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
}
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String a[] = {"b","w","f","a","s"};
		Integer a[] = {34,23,54,12,76,7623};
		System.out.println(Arrays.toString(a));
		QS.sort(a);
		System.out.println(Arrays.toString(a));
		
	}

}

