package com.imhangoo.algorithms;

public class Recursion {
	public static void main(String[] args) {
		recursion(100000);
	}
	
	public static void recursion(int i){
		if(i < 0){
			return;
		}else{
			recursion(i-1);
		}
		
		
	}

}
