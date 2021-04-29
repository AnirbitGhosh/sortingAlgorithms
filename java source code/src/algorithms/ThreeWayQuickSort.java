package algorithms;

public class ThreeWayQuickSort extends SortingAlgs {

	//Base sort method that splits the array into 3 parts, the left
	//part is elements less than the pivot, middle part is elements equal
	//to the pivot and the right part is elements greater than the pivot
	public void sort(int[] numbers, int p, int r) {
		if (r <= p) {
			return;
		}

		int lt = p;
		int gt = r;
		int i = p + 1;

		int pivotIndex = p;
		int pivotValue = numbers[pivotIndex];

		while (i <= gt) {
			if (numbers[i] < pivotValue) {
				swap(numbers, i++, lt++);

			} else if (pivotValue < numbers[i]) {
				swap(numbers, i, gt--);

			} else {
				i++;
			}
		}

		sort(numbers, p, lt - 1);
		sort(numbers, gt + 1, r);

	}

	//Helper function to exchange any two indexes of a given array
	public void swap(int[] numbers, int idx1, int idx2) {
		int temp = numbers[idx1];
		numbers[idx1] = numbers[idx2];
		numbers[idx2] = temp;
	}

}
