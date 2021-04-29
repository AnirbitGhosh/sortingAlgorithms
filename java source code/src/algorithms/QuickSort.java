package algorithms;

public class QuickSort extends SortingAlgs {
	private InsertionSort insertionSort = new InsertionSort();

	//Base sort method which recursively sorts a given array
	public void sort(int[] numbers, int p, int r) {
		if (p < r) {
			int q = partition(numbers, p, r);
			sort(numbers, p, q - 1);
			sort(numbers, q + 1, r);

		}
	}

	//Method to partition a given array by returning a pivot valuye
	public int partition(int[] numbers, int p, int r) {
		int x = numbers[r];
		int i = p - 1;

		for (int j = p; j <= r - 1; j++) {
			if (numbers[j] < x) {
				i += 1;
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
			}
		}
		int temp2 = numbers[i + 1];
		numbers[i + 1] = numbers[r];
		numbers[r] = temp2;

		return i + 1;
	}

	//Method signature for insertionQuickSort with a cut-off value parameter
	public void sort_with_Insertion(int[] numbers, int p, int r, int k) {
		int size = (r + 1) - p;
		if (p < r) {
			if (size < k) {
				insertionSort.sort(numbers, p, r);

			} else {
				int q = partition(numbers, p, r);
				sort_with_Insertion(numbers, p, q - 1, k);
				sort_with_Insertion(numbers, q + 1, r, k);
			}

		}
	}

}
