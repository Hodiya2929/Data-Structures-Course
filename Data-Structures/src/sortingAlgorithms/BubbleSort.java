package sortingAlgorithms;
/**
 * 
 * @author עימנואל
 *
 */
public class BubbleSort {
	/**
	 * The so called Bubble-sort algorithm, smaller/larger number "bubble" to the top of the list
	 * Complexity: best case - the array is sorted and thus no swaps needed at all - O(n),
	 * worst-case occurs when the array is sorted completely in descending instead of ascending order
	 * there are in general n-1 numbers to be swapped, as the first number has n-1 the second n-2 and the 
	 * last one has 1 swap and thus the average is 1/2n = 1/2n*(n-1) = O(n^2). 
	 * 
	 * note - Bubble sort is in general less efficient than insertion sort even though they both have worst case
	 * complexity of O(n^2) 
	 * 
	 * 
	 * @param arr - array to be sorted
	 */

	public static void Bubble_Sort(int[] arr) {

		int i=0;
		boolean flag=true;

		while (i<arr.length&&flag) { 

			for (int j=0;j<arr.length-1-i;j++) {
				
				flag=false;

				if (arr[j]>arr[j+1]) {

					flag=true;
					SelectionSort.Swap(arr, j, j+1);	//Too lazy to rewrite new one...
				}
			}

			i++;
		}

	}

}
