package improvedSortingAlgorithm;

import java.util.Arrays;

public class QuickSort {
	/**
	 * Quick sort is a "Divide and conquer" algorithm. There are some versions of quick sort.
	 * For each iteration we pick a pivot and then we iterate over the array and moves bigger/smaller to the
	 * right/left correspondingly. 
	 * The important point here is to choose wisely the pivot. If the algorithm picks the maximum finally we get O(n^2),
	 *  therefore there are some versions of randomized quick sort that guaranteed O(nlog(n)) - proof is needed.
	 * 
	 * 
	 * Note: it's worth to mention that there is a version that uses the median finding algorithm
	 *  (see the MedianFinding class) O(n) ant use this as
	 * a pivot - but this version fails in reality (it's a good example where reality contradicts the theory -
	 *  T(n)=2*T(n/2)+theta (n)+ theta (n))
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		int[] array=sortingAlgorithms.TestSort.Arrayinitialization(200, 100);

		System.out.println(Arrays.toString(array));

		QuickSortWrapper(array);

		System.out.println(Arrays.toString(array));

	}

	public static void QuickSortWrapper(int[] array) {

		Quick_Sort(array,0,array.length-1);

	}

	private static void Quick_Sort(int[] array, int start, int end) {

		if((end-start)>0) {

			int pivotIndex=Partition(array,start, end);

			Quick_Sort(array, start, (pivotIndex-1));
			Quick_Sort(array, (pivotIndex+1), end);

		}

	}

	private static int Partition(int[] array, int start, int end) {

		// Permanently picks the first element as a pivot

		int pivot=start+    (int) Math.random()*(end-start+1);
		Swap(array, pivot, end);


		int L=start, H=end-1;

		while(H>=L) {


			if(array[H]>=array[pivot])
				H--;
			else if(array[L]<array[pivot])
				L++;
			else Swap(array,L,H);

		}

		Swap(array,L,pivot);

		return L;
	}

	public static void Swap(int[] array, int i, int j) {

		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;

	}
}
