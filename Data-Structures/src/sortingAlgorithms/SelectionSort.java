package sortingAlgorithms;

public class SelectionSort {

	/* It's much easier to analyze complexity by just describe how this particular algorithm works:
	 we traverse in the first time over n-1 slots, the second time over n-2 slots etc.
	 let's sum (n-1)+(n-2)+(n-3)+...+1= (n*(n-1))/2=  n^2/2 -n/2 =O(n^2)   */

	public static void Selection_Sort(int[] arr) {

		int length=arr.length;
		int minindex;

		for (int i = 0; i < arr.length-1; i++) {   

		 minindex=FindMinIndex(arr, i, length-1);
		 
		 Swap(arr, minindex, i);   
			
		}

	}

	public static int FindMinIndex(int[] arr, int left, int right) {

		int min=left;
		int i;

		for (i=left;i<right;i++) 

			if (arr[i+1]<arr[min])
				min=i+1;

		return min;
	}

	public static void Swap(int[] arr,int index1,int index2) {

		int temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;

	}


}
