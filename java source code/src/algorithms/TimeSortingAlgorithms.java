package algorithms;


import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TimeSortingAlgorithms {
	
	//Method to test the sorting time of a sorting algorithm on an input file
	public static void sortingTime_file(SortingAlgs alg, String filename) throws FileNotFoundException{
		
		//Scanner objects associated to each file to be read
		Scanner scanner1 = new Scanner(new File("int10.txt"));
		Scanner scanner2 = new Scanner(new File("int100.txt"));
		Scanner scanner3 = new Scanner(new File("int20k.txt"));
		Scanner scanner4 = new Scanner(new File("int50.txt"));
		Scanner scanner5 = new Scanner(new File("int1000.txt"));
		Scanner scanner6 = new Scanner(new File("int500k.txt"));
		Scanner scanner7 = new Scanner(new File("dutch.txt"));
		Scanner scanner8 = new Scanner(new File("intBig.txt"));
		
		//Make a balnk ArrayList to add integers from file into
		ArrayList<Integer> intList = new ArrayList<>();
		
		//Switch cases to determine which file is being tested based on input
		switch(filename) {
		case "int10.txt":
			int i = 0;
			while (scanner1.hasNextLine()) {
				intList.add(i++, Integer.parseInt(scanner1.nextLine()));
			}
			break;
		
		case "int100.txt":
			int[] int2 = new int[100];
			int j = 0;
			while (scanner2.hasNextLine()) {
				intList.add(j++, Integer.parseInt(scanner2.nextLine()));
			}
			break;
		
		case "int20k.txt":
			int[] int3 = new int[20000];
			int k = 0;
			while (scanner3.hasNextLine()) {
				intList.add(k++, Integer.parseInt(scanner3.nextLine()));
			}
			break;
		
		case "int50.txt":
			int l = 0;
			while (scanner4.hasNextLine()) {
				intList.add(l++, Integer.parseInt(scanner4.nextLine()));
			}
			break;
			
		case "int1000.txt":
			int m = 0;
			while (scanner5.hasNextLine()) {
				intList.add(m++, Integer.parseInt(scanner5.nextLine()));
			}
			break;
		
		case "int500k.txt":
			int n = 0;
			while (scanner6.hasNextLine()) {
				intList.add(n++, Integer.parseInt(scanner6.nextLine()));
			}
			break;
		
		case "dutch.txt":
			int o = 0;
			while (scanner7.hasNextLine()) {
				intList.add(o++, Integer.parseInt(scanner7.nextLine()));
			}
			break;
			
		case "intBig.txt":
			int p = 0;
			while (scanner8.hasNextLine()) {
				intList.add(p++, Integer.parseInt(scanner8.nextLine()));
			}
			break;
		}
		
		//Convert ArrayList of integers into an Array of integers
		int[] intArray = intList.stream().mapToInt(y->y).toArray();
		
		
		
		System.out.println("----------------------------------");
		System.out.println("Time taken to Sort: " + filename);
		
		//Check if InsertionQuickSort is being called, as it needs a 4th parameter in the sort() method
		if(alg.getClass().getSimpleName() == "InsertionQuickSort") {
			long time1 = System.nanoTime();
			alg.sort_with_Insertion(intArray, 0, intArray.length-1, 5);
			long time2 = System.nanoTime();
			double timeTaken = (double)(time2-time1)/1000000;
			
			System.out.println(alg.getClass().getSimpleName() + ": " + timeTaken + " milliseconds");	
			System.out.println("----------------------------------");
			
		//All other algorithms take 3 parameters in the sort() method
		}else { 
			long time1 = System.nanoTime();
			alg.sort(intArray, 0, intArray.length-1);
			long time2 = System.nanoTime();
			double timeTaken = (double)(time2-time1)/1000000;
			
			System.out.println(alg.getClass().getSimpleName() + ": " + timeTaken + " milliseconds");	
			System.out.println("----------------------------------");
		}	
	}
	
	
	//Method to test sorting time on an array directly
	public void sortingTime_arr(SortingAlgs alg, int[] arr){
		System.out.println("----------------------------------");
		System.out.println("Time taken to Sort: " + arr.length + " integers" );
		
		if(alg.getClass().getSimpleName() == "InsertionQuickSort") {
			long time1 = System.nanoTime();
			alg.sort_with_Insertion(arr, 0, arr.length-1, 100);
			long time2 = System.nanoTime();
			double timeTaken = (double)(time2-time1)/1000000;
			
			System.out.println(alg.getClass().getSimpleName() + ": " + timeTaken + " milliseconds");	
			System.out.println("----------------------------------");
		}else { 
			long time1 = System.nanoTime();
			alg.sort(arr, 0, arr.length-1);
			long time2 = System.nanoTime();
			double timeTaken = (double)(time2-time1)/1000000;
			
			System.out.println(alg.getClass().getSimpleName() + ": " + timeTaken + " milliseconds");	
			System.out.println("----------------------------------");
		}	
	}
	
	
	
	public static void main(String args[]) throws FileNotFoundException{
		QuickSort quickSort = new QuickSort();
		ThreeWayQuickSort threeWayQuick = new ThreeWayQuickSort();
		MedianQuickSort medianQuickSort = new MedianQuickSort();
		InsertionSort insertionSort  = new InsertionSort();
		MergeSort mergeSort = new MergeSort();
		InsertionQuickSort insertionQuickSort = new InsertionQuickSort();
		
		
		//Method calls for various test cases
		TimeSortingAlgorithms.sortingTime_file(insertionQuickSort, "int10.txt");	
		TimeSortingAlgorithms.sortingTime_file(insertionQuickSort, "int50.txt");	
		TimeSortingAlgorithms.sortingTime_file(insertionQuickSort, "int100.txt");		
		TimeSortingAlgorithms.sortingTime_file(insertionQuickSort, "int1000.txt");
		TimeSortingAlgorithms.sortingTime_file(insertionQuickSort, "int20k.txt");
		TimeSortingAlgorithms.sortingTime_file(insertionQuickSort, "int500k.txt");		
		TimeSortingAlgorithms.sortingTime_file(insertionQuickSort, "intBig.txt");	
		TimeSortingAlgorithms.sortingTime_file(insertionQuickSort, "dutch.txt");	
		
	}
	
	

}
