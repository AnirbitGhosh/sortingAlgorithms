package algorithms;

//This algorithm extends the original QuickSort class, so it can be called as a subclass 
public class InsertionQuickSort extends QuickSort{
	//Instantiate insertionSort to call the insertion sort method 
	private InsertionSort insertionSort = new InsertionSort();
	
	public void sort(int[] numbers, int p, int r, int k) {
		int size = (r + 1) - p;
		if (p < r) {
			if (size < k) {
				insertionSort.sort(numbers, p, r);

			} else {
				int q = partition(numbers, p, r);
				sort(numbers, p, q - 1);
				sort(numbers, q + 1, r);
			}
		}
	}

}
