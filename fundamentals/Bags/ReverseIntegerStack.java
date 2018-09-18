package Bags;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Stack;

public class ReverseIntegerStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Integer a[] = {1,2,3,4,5};
		for(Integer i : a){
			stack.push(i);
		}
		for(Integer i : stack){
			System.out.println(i);
		}
	}
	

}
