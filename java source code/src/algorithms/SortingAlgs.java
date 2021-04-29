package algorithms;

//Abstract class inherited by all sorting algorithm classes
public abstract class SortingAlgs {
	//Every algorithm class must have a sort() method
	public abstract void sort(int[] numbers, int p, int r);
	
	//Only the insertionQuickSort needs a different sort method signature due to the extra parameter, so this method is not abstract
	public void sort_with_Insertion(int[] numbers, int p, int r, int k) {}

}
