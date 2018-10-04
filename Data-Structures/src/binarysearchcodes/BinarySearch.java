package binarysearchcodes;
/**
 * 
 * @author עימנואל
 *
 *
 *Given a sorted array of n elements we look for efficient way for finding some value.
 *One simple approach is to do a linear search. The time complexity of above 
 *algorithm is O(n). A more efficient approach is searching a certain value by binary search.
 *Binary Search: Search a sorted array by repeatedly dividing the search interval
 * in half. Begin with an interval covering the whole array. If the value of the 
 * search key is less than the item in the middle of the interval, narrow the interval 
 * to the lower half. Otherwise narrow it to the upper half. Repeatedly check until 
 * the value is found or the interval is empty.
 * T(n)=T(n/2) + O(1) we repeatedly do this until T(n)=T(n/2^k)+k*O(1) when
 * n=2^k we stop, and thus k=log(n) (base of 2 - of course) and the complexity is then 
 * log(n)! 
 * 
 * 
 * 
 * 
 */
public class BinarySearch {

	public static int BinarySearchRecursive(int[] arr, int value) {

		if (value<arr[0]||value>arr[arr.length-1])
			return -1;

		else return BinarySearchRec(arr,0,arr.length-1,value);

	}

	private static int BinarySearchRec(int[] arr, int startindex, int endindex, int value) {

		int mid=(endindex-startindex)/2 +startindex;

		if(endindex<startindex)
			return -1;

		else if (value==arr[mid])
			return mid;

		else if(value>arr[mid])
			return BinarySearchRec(arr, mid+1, endindex, value);

		else  
			return BinarySearchRec(arr,startindex, mid-1, value);

	}

	public static int BinarySearchIterative(int[] arr, int value) {

		if (value<arr[0]||value>arr[arr.length-1])
			return -1;

		else return BinarySearchIte(arr,0,arr.length-1,value);

	}

	private static int BinarySearchIte(int[] arr, int startindex, int endindex, int value) {

		int mid;

		while (startindex<=endindex) {
			
			mid=(endindex-startindex)/2+startindex;

			if(arr[mid]==value)
				return mid;
			
			else if(arr[mid]>value)
				endindex=mid-1;
			
			else startindex=mid+1;
			
		}
		
		return -1;
	}

}
