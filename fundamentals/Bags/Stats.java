package Bags;

import BagAPI.Bag;

public class Stats {

	public static void main(String[] args) {
		Bag<Double> bag = new Bag<Double>();
		Double a[] = {1.0,2.0,3.0};
		for(Double i : a){
			bag.add(i);
		}
		
		int n = bag.size();
		double sum = 0;
		for(double x : bag){
			sum = sum+x;
		}
		double mean = sum/n;
		
		sum=0.0;
		for(double x: a){
			sum = (x-mean)*(x-mean);
		}
		double stddev = Math.sqrt(sum/(n-1));
		
		/*for(Integer i : bag){
			System.out.println(i);
		}*/
		System.out.println("Mean : "+mean);
		System.out.println("Standard Deviation : "+stddev);
	}
}
