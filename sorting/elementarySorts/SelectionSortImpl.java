package elementarySorts;

import java.util.Arrays;
import java.util.Comparator;

class SelectionSort<T>{

	private boolean less(Comparable<T> v, Comparable<T> w){
		return v.compareTo((T) w)<0;
	}
	
	private static void swap(Object[] a,int i,int j){
		Object temp = a[i];
		a[i] = a[j];
		a[j]=temp;
	}
	
	public void sort(Comparable<T>[] a){
		for(int i=0;i<a.length;i++){
			int min = i;
			for(int j=i+1;j<a.length;j++){
				if(less(a[j],a[min])){
					min=j;	
				}
			}
			swap(a,i,min);
			assert isSorted(a,i,min);
		}
	}

	private boolean isSorted(Comparable<T>[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
	}
}

public class SelectionSortImpl {

	public static void main(String[] args) {
		
		SelectionSort<Integer> ss = new SelectionSort<>();
		Integer a[] = {43,2,43,12,56,78,76};
		ss.sort(a);
		System.out.println(Arrays.asList(a));
	}

}
