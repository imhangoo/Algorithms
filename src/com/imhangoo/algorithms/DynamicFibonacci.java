package com.imhangoo.algorithms;
import java.util.Arrays;
/**
 * 
 * Dynamic programming for finonacci
 *
 */
public class DynamicFibonacci {
	int[] array = new int[100];
	public static void main(String[] args) {
		DynamicFibonacci df = new DynamicFibonacci();
		System.out.println(df.fib(12));
		
	}
	
	public DynamicFibonacci(){
		Arrays.fill(array, 0);
	}
	public int fib(int i) {
		if(array[i]!=0) return array[i];
		if(i<2){
			array[i] = 1;
		}else{
			array[i] = fib(i-1) + fib(i-2);
		}
		return array[i];
	    
		
	}

}
