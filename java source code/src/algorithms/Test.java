package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Test {
	
	//Method to test if an array is sorted
	//returns true if sorted, and false if not
	public boolean testSorting(int[] numList) {
		System.out.println(Arrays.toString(numList));
		
		for(int i =0; i < numList.length-1; i++) {
			if (numList[i] > numList[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	

	public static void main(String args[]) {
		//Instantiate each algorithm class
		//Call the required sort method from the desired class using <<class name>>.sort(array, start_idx, end_idx)
		QuickSort quickSort = new QuickSort();
		ThreeWayQuickSort threeWayQuick = new ThreeWayQuickSort();
		MedianQuickSort medianQuickSort = new MedianQuickSort();
		InsertionSort insertionSort  = new InsertionSort();
		MergeSort mergeSort = new MergeSort();
		InsertionQuickSort insertionQuickSort = new InsertionQuickSort();
		
		Random rd = new Random();
		Test test = new Test();
	
		
		//create 3 random number arrays of lengths 20, 50 and 100 to test
		//the sorting algorithms on
		int[] l1 = new int[2000];
		for (int i = 0; i < l1.length; i++) {
			l1[i] = rd.nextInt(5000);
		}
		
		int[] l2 = new int[500];
		for (int i = 0; i < l2.length; i++) {
			l2[i] = rd.nextInt(1000);
		}
		
		int[] l3 = new int[1000];
		for (int i = 0; i < l3.length; i++) {
			l3[i] = rd.nextInt(2000);
		}
		
		int[] l4 = new int[500];
		for (int i = 0; i < l4.length; i++) {
			l4[i] = rd.nextInt(10000);
		}

		
		
		//Call the sort method of the algorithm to be tested by using the instantiated class object.
		//Supply the array to be sorted, the starting index 0 and the last index (array.length - 1) as the parameters
		
		insertionSort.sort(l1, 0, l1.length-1);
		System.out.println(test.testSorting(l1));
		
		insertionSort.sort(l2, 0, l2.length-1);
		System.out.println(test.testSorting(l2));
		
		insertionSort.sort(l3, 0, l3.length-1);
		System.out.println(test.testSorting(l3));
		
		//Quick sort with Insertion Sort takes an extra cut off value parameter
		quickSort.sort_with_Insertion(l4, 0, l4.length-1, 10);
		System.out.println(test.testSorting(l4));
	}

}
