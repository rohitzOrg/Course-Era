package elementarySorts;

// visualizing :   https://algs4.cs.princeton.edu/21elementary/ShellBars.java.html
// see also : https://algs4.cs.princeton.edu/21elementary/InsertionPedantic.java.html
import java.util.Arrays;

class InsertionSort{

	public static <T extends Comparable<T>> boolean less(T v, T w){
		return v.compareTo(w)<0;
	}
	
	public static void swap(Object[] a,int i,int j){
		Object temp = a[i];
		a[i] = a[j];
		a[j]=temp;
	}
	
	public static <T extends Comparable<T>> void sort(T[] a){
		for(int i=0;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(less(a[j],a[j-1])){
					swap(a,i,j-1);
				}else{
					break;
				}
			}
		}
	}
}
public class InsertionSortImpl {

	public static void main(String[] args) {

		Integer a[] = {2,43,12,56,78,76};
		InsertionSort.sort(a);
		System.out.println(Arrays.asList(a));
	}

}
