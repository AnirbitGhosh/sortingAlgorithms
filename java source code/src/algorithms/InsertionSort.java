package algorithms;

public class InsertionSort extends SortingAlgs {
	
	public void sort(int[] numbers, int p, int r) {
		for(int i = p+1; i <= r; i++) {
			int key = numbers[i];
			int j = i-1;
			
			while(j>=p && numbers[j] > key) {
				numbers[j+1] = numbers[j];
				j=j-1;
			}
			numbers[j+1] = key;
		}
	}

}
