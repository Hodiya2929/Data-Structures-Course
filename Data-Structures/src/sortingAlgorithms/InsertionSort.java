package sortingAlgorithms;

public class InsertionSort {

	/*
	insert sort has its name - because of each value inserted to its real location.
	In the best case, we go through the array only once, as in the worst case (when the array is sorted in
	 the opposite side we have for the 1'st index 1 swap, 2 swaps for the second index and so on, thus, in
	  general, we have 1+ 2+...+n-1=(n-1)*n/2=O(n^2).
	The average time complexity is theta (n^2) since we have (n-1)*n/2 terms in our algorithm and for each
	 inversion, the probability that a swap is needed is 1/2 than in general we have (n-1)*n/4 = theta (n^2).
	*/
	public static void Insertion_Sort(int[] arr) {

		int value;
		
		for (int i=1;i<arr.length;i++) {

			value=arr[i];
			int j=i-1;
			
			while (j>=0&&value<arr[j]){

					SelectionSort.Swap(arr, j, i);
					j--;
					i--;
	
				}
			}

		}

}
