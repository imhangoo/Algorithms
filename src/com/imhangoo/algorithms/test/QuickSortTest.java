package com.imhangoo.algorithms.test;


import java.util.Arrays;

import org.junit.Test;

import com.imhangoo.algorithms.QuickSort;

public class QuickSortTest {

	@Test
	public void testQuickSort() {
		int array[] = {2,1,3,4,7,6,5};
		QuickSort.quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

}
