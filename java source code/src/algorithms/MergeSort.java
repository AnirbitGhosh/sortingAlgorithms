package algorithms;

public class MergeSort extends SortingAlgs{
	
	
	//Method to merge the subarrays 
	public static void merge(int[] a, int[] l, int[] r, int left, int right) {
		int i = 0, j = 0, k = 0;

		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}

		while (i < left) {
			a[k++] = l[i++];
		}

		while (j < right) {
			a[k++] = r[j++];
		}
	}

	//Method to sort the given array by recursively splitting into subarrays and merging sorted subarrays
	public void sort(int[] a, int p, int r) {
		int n = r + 1;
		if (n < 2) {
			return;
		}

		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}

		for (int i = mid; i < n; i++) {
			right[i - mid] = a[i];
		}

		sort(left, p, mid-1);
		sort(right, p, n - mid-1);

		merge(a, left, right, mid, n - mid);
	}


}
