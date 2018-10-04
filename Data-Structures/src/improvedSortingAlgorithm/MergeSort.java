package improvedSortingAlgorithm;

/**
 * Merge sort is a very smart sorting algorithm based on "divide and conquer" attitude.
 * 
 * Merge sort "divides" the array into half-size sub-arrays, until we have a single slot
 * sub-array (which is sorted of course) - note that the division is theoretical  
 * and the array keeps it's original length throughout the division process - the 
 * "real" action of sorting is done in the "merge" process - the Merge process assumes
 *  that there are two sorted arrays as input.
 * 
 * Single sized arrays don't make the Merge function call.
 * 
 * How many "divisions" are made through the algorithm? the algorithm "splits" the array
 * into 2 halves and and each one of them is divided until we reach a 1 sized length, so we get
 * log(n), n stands for the input length and the log is at the base of 2.  
 * 
 * Advantages:
 * 
 * 1. The complexity is n*log(n) - the best that we can wish for in the comparison model.
 * 
 * Disadvantages:
 * 
 * 1. The algorithm doesn't test if the array is already sorted.
 * 2. The algorithm is not in "in-place" category, so that it's has to allocate theta (n)
 *    Auxiliary space. (in each level) (there is an "in-placed" version to merge-sort 
 *    but it's not practical because the performance is much worse in terms of time.
 *    
 * Proof to complexity time of merge-sort. every level has theta (n) work - and we 
 * have log(n) levels, so that we can get the following recursion: T(n)=2*T(n/2)+theta(n) - 
 * the solution to this recursion is in recursion tree in the pdf document.
 * 

 * 
 * @author עימנואל
 *
 */
public class MergeSort {

	public static void main(String[] args) {

		int[] arr=sortingAlgorithms.TestSort.Arrayinitialization(10000000, 500000000);

		
		long startime,endtime;
		startime=System.currentTimeMillis();

		MergeWrapper(arr);
		endtime=System.currentTimeMillis();

		System.out.println("Sorting time - mergw-sort: "+ (endtime-startime)+" mili seconds ");


	}

	public static void MergeWrapper(int[] arr) {

		Merge_Sort(arr,0,arr.length-1);

	}

	private static void Merge_Sort(int[] arr, int start, int end) {

		int mid=(end+start)/2;

		if((end-start)>0) {
/*original array "division" into 2-halves sub-arrays - arrays of length 1 
fails in the if condition and thus don't call Merge function*/			

			Merge_Sort(arr, start, mid);
			Merge_Sort(arr, mid+1, end);
			Merge(arr,start,mid,end);
		}


	}
	private static void Merge(int[] arr, int start, int mid, int end) {

		int[] temp=new int[end-start+1];

		int i=start,k=0,j=mid+1;

		while(i<=mid&&j<=end) {// compare the minimum of 2 halves

			if(arr[i]<arr[j])
				temp[k++]=arr[i++];

			else temp[k++]=arr[j++];

		}

		while(i<=mid)
			temp[k++]=arr[i++];// this and the next while copy the other sorted slots

		while (j<=end)
			temp[k++]=arr[j++];

		int templength=temp.length;// copy the sorted temporary array to the original array in the sorted range only  
		for(int s=0;s<templength;s++)
			arr[start+s]=temp[s];
	}



}
