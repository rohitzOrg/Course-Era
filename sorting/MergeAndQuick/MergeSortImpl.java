package MergeAndQuick;

//    https://algs4.cs.princeton.edu/22mergesort/MergeX.java.html

import java.util.Arrays;

class MS{
	
	private static final int CUTOFF=7;

	public static <T> void sort(Comparable<T>[] a) {
		// TODO Auto-generated method stub
		Comparable<T>[] values = a.clone();
		mergeSort(a,values,0,a.length-1);
	}

	private static <T> void mergeSort(Comparable<T>[] a, Comparable<T>[] tempArr, int leftStart, int rightEnd) {
		// TODO Auto-generated method stub
		/*if(leftStart>=rightEnd){
			return;
		}*/
		if(leftStart<rightEnd){
			insertionSort(a, leftStart, rightEnd);
		int middle = (leftStart+rightEnd)/2;
		
		mergeSort(a,tempArr,leftStart,middle);
		System.out.println(Arrays.toString(a)+","+Arrays.toString(tempArr)+","+leftStart+","+middle);
		System.out.println("merge sort left side");
		
		mergeSort(a,tempArr,middle+1,rightEnd);
		System.out.println(Arrays.toString(a)+","+Arrays.toString(tempArr)+","+(middle+1)+","+rightEnd);
		System.out.println("merge sort right side");
		
		mergeBothHalves(a,tempArr,leftStart,rightEnd);
		System.out.println(Arrays.toString(a)+","+Arrays.toString(tempArr)+","+leftStart+","+rightEnd);
		System.out.println("merge halves");
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

	private static <T> void mergeBothHalves(Comparable<T>[] a, Comparable<T>[] tempArr, int leftStart, int rightEnd) {
		// TODO Auto-generated method stub
		int leftEnd = (leftStart+rightEnd)/2;
		int rightStart = leftEnd+1;
		int size = rightEnd-leftStart+1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		//System.out.println(a[left]+" "+a[right]);
		while(left<=leftEnd && right<=rightEnd){
			if(a[left].compareTo((T) a[right])<0){
				tempArr[index]=a[left];
				left++;
			}
			else{
				tempArr[index]=a[right];
				right++;
			}
			index++;
		}
		//System.out.println(Arrays.toString(tempArr));
		System.arraycopy(a, left, tempArr, index, leftEnd-left+1);
		System.arraycopy(a, right, tempArr, index, rightEnd-right+1);
		System.arraycopy(tempArr, leftStart, a, leftStart, size);
	}

}

public class MergeSortImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[] = {"b","w","f","a","s"};
		//Integer a[] = {34,23,54,12,76,7623};
		System.out.println(Arrays.toString(a));
		MS.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
