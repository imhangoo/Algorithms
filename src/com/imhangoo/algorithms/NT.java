package com.imhangoo.algorithms;

import java.util.LinkedList;

public class NT {
	/**
	 * dp[i][j]的含义：
	 * 1.是否存在arr[0...i-1]的子集，使得子集和为j，若存在为true，不存为false。
	 * 2.当dp[i-1][j]为true时，dp[i][j]以及dp[i][j+arr[i]]必然也为true（当然，j+arr[i]不能越界）。
	 */
	public boolean SubSetSum(int[] arr, int s) {
	    if (arr == null || arr.length == 0 || s < 0)
	        return false;
	    boolean dp[][] = new boolean[arr.length+1][s + 1];
	    int i, j;
	    dp[0][0] = true;
	 
	    // 构造其他行
	    for (i = 1; i < arr.length+1; i++) {
	        for (j = 0; j < s + 1; j++) {
	            if (dp[i - 1][j]) {
	                dp[i][j] = true;
	                if (j + arr[i-1] <= s){
	                    dp[i][j + arr[i-1]] = true;}
	            }
	        }
	    }
	    if(!dp[arr.length][s])// 表示不存在和为s的子集，直接返回
	        return false;
	    else
	    	return true;
	   
	}
}
