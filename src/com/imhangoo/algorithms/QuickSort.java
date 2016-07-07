package com.imhangoo.algorithms;

public class QuickSort {
	public static void quickSort(int[] array, int startIndex, int endIndex){
		// Tried to use startIndex==endIndex, get stackOverflowError
		if(startIndex>=endIndex) return;
		
		int pivotIndex = partition(array, startIndex, endIndex);
		quickSort(array,startIndex,pivotIndex-1);
		quickSort(array,pivotIndex+1,endIndex);
		
	}

	private static int partition(int[] array, int startIndex, int endIndex) {
		int i = startIndex;
		int pivot = array[startIndex];
		int temp = 0;
		for(int j = startIndex+1; j <= endIndex; j++){
			if(array[j] <= pivot){
				i++;
				temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		array[startIndex] = array[i];
		array[i] = pivot;
		return i;
	}

}
