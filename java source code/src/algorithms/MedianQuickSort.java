package algorithms;

public class MedianQuickSort extends SortingAlgs {

	//The base sort method that recursively sorts the array
	public void sort(int[] numbers, int p, int r) {
		if (p < r) {
			int pivot = getMedianOf3(numbers, p, r);
			int partition = partition(numbers, p, r, pivot);

			sort(numbers, p, partition - 1);
			sort(numbers, partition + 1, r);

		}
	}

	//Method to get the median of the first, last and middle elements
	public int getMedianOf3(int[] numbers, int p, int r) {
		int mid = (p + r) / 2;

		if (numbers[mid] < numbers[p]) {
			swap(numbers, mid, p);
		}

		if (numbers[r] < numbers[p]) {
			swap(numbers, p, r);
		}

		if (numbers[mid] > numbers[r]) {
			swap(numbers, r, mid);
		}

		swap(numbers, mid, r);
		return numbers[r];
	}

	//Swap method to exchange any to index positions in an array
	public void swap(int[] numbers, int idx1, int idx2) {
		int temp = numbers[idx1];
		numbers[idx1] = numbers[idx2];
		numbers[idx2] = temp;
	}

	//Method to partition the array with any given pivot element 
	public int partition(int[] numbers, int p, int r, int pivot) {
		int left = p - 1;
		int right = r;

		while (left < right) {
			while (numbers[++left] < pivot);
			while (right > 0 && numbers[--right] > pivot);
			if (left >= right) {
				break;
			} else {
				swap(numbers, left, right);
			}
		}

		swap(numbers, left, r);
		return left;
	}

}
