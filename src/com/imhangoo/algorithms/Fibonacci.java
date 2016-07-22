package com.imhangoo.algorithms;

public class Fibonacci {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.print(fibonacci(i)+" ");
		}
		
	}

	private static int fibonacci(int i) {
		return i<=1?1:fibonacci(i-1)+fibonacci(i-2);
		
	}

}
