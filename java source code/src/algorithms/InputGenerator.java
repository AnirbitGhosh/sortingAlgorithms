package algorithms;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class InputGenerator {
	private Random rd = new Random();
	
	
	//Method to return an array of a given size with random integers and no duplicates
	//that will generate quadratic sorting times when sorted with MedianQuickSort
	public int[] createArray(int size) {
		int[] result = new int[size];
		
		HashSet<Integer> used = new HashSet<Integer>();
		
		for(int i = 0; i < size; i++) {
			int add = rd.nextInt(size * 10);
			while(used.contains(add)) {
				add = rd.nextInt(size * 10);
			}
			
			used.add(add);
			result[i] = add;
		}
		
		//the method responsible for arranging the array in a way so as to generate quadratic sorting times
		shuffle(result);
		return result;
	}
	
	
	//Method to rearrange any given array in a way so as to generate the worst case scenario 
	//for median of 3 quicksort 
	public void shuffle(int[] arr) {
		Arrays.sort(arr);
		
		for(int i = 0; i < 1; i++) {
			int j, last;
			last = arr[arr.length-1];
			
			for(j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j-1];
			}
			
			arr[0] = last;
		}
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		InputGenerator ig = new InputGenerator();
		MedianQuickSort median = new MedianQuickSort();
		TimeSortingAlgorithms time = new TimeSortingAlgorithms();
		InsertionSort insertion = new InsertionSort();
		
		
		
		//Generating pathological arrays to test the runtimes
		int[] l1 = ig.createArray(100);
		int[] l2 = ig.createArray(1000);
		int[] l3 = ig.createArray(20000);
		int[] l4 = ig.createArray(500000);
		
		
		//Testing the sorting time of MedianQucikSort and InsertionSort on these arrays
		//Comment out one of the sorting algorithm statements when testing for the other as the array gets sorted in place 
		//Performing both at the same time would mean the second algorithm gets a sorted array as input 
		time.sortingTime_arr(median, l1);
		//time.sortingTime_arr(insertion, l1);
		
		time.sortingTime_arr(median, l2);
		//time.sortingTime_arr(insertion, l2);
		
		time.sortingTime_arr(median, l3);
		//time.sortingTime_arr(insertion, l3);
		
		time.sortingTime_arr(median, l4);
		//time.sortingTime_arr(insertion, l4);
		
	}
}
