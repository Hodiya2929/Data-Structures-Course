package taskNum1;

import java.util.Arrays;

public class Peaks {

	public static void main(String[] args) {
		
		int [] arr=sortingAlgorithms.TestSort.Arrayinitialization(10, 100);
		System.out.print(Arrays.toString(arr));

		System.out.println("\n"+peakfinding(0,9, arr));	

	}

	public static int peakfinding(int start, int end,int[] arr) {

		int length=end-start;

		int mid=length/2+start;

		 if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == arr.length-1 ||
	             arr[mid+1] <= arr[mid]))
	            return mid;

		if (arr[mid]<=arr[mid+1])
			return	peakfinding(mid+1,end,arr);

		else if(arr[mid]<=arr[mid-1])
			return	peakfinding(start,mid-1,arr);

		else return mid;


	}

}
