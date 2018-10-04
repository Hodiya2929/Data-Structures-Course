package improvedSortingAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 
 * Counting sort and Radix sort are not in the comparison model that is they don't
 * compare the objects, instead they use other technique.
 * Go through the array and increment the counter of the value-array (temporary array) 
 * 
 * 
 * @author עימנואל
 *
 */

public class BoundedSort {

	private static int[] CountingArray(int[] array, int maxvalue) {

		int count[]=new int[maxvalue];

		for (int i = 0; i < array.length; i++) {

			count[array[i]]++;

		}

		return count;
	}


	public static int[] Bounded_Sort(int[] array,int maxval) {

		int[] count=CountingArray(array, maxval);

		int[] sorted=new int[array.length];

		int up=0;

		for (int i = 0; i < count.length; i++) 

			for (int j=0;j<count[i];j++)

				sorted[up++]=i;

		return sorted;
	}

	/**
	 * Bounded_sort also called counting sort. There is another version 
	 * to counting sort that use list instead of arrays.
	 * The advantage of linked lists over arrays is that when we have equals values and
	 * we want to keep the original order(because for example this key represents something
	 * we can use the linked list version.
	 * k - maximum value. If k happens to be order n - we get linear time.
	 * @param <E>
	 */

	public static int[] CountingSort(int[] arr,int maxvalue) {

		ArrayList<LinkedList<Integer>> listsArray=new ArrayList<>(maxvalue);

		for (int i = 0; i < maxvalue; i++) //O(k)
			listsArray.add(i,new LinkedList<Integer>());//O(1)

		for (int i = 0; i < arr.length; i++) //O(n)
			listsArray.get(arr[i]).addLast(arr[i]);//O(1)

		int[] sorted=new int[arr.length];
		int count=0;

		for (LinkedList<Integer> e : listsArray) {//O(n+k)

			while(!e.isEmpty())
				sorted[count++]=e.pollFirst();
		}

		return sorted;

	}





	public static void main(String[] args) {

		int [] arr1=sortingAlgorithms.TestSort.Arrayinitialization(1000000,10000);
		int [] arr2=sortingAlgorithms.TestSort.Arrayinitialization(1000000,10000);

		long start=System.currentTimeMillis();
		arr1=CountingSort(arr1, 10000000);
		long end=System.currentTimeMillis();

		System.out.println("Time to sort through LinkedLists: "+(end-start) +" mili seconds");	

		start=System.currentTimeMillis();
		arr2=Bounded_Sort(arr2, 10000000);
		end=System.currentTimeMillis();

		System.out.println("Time to sort through arrays: "+(end-start) +" mili seconds");	

	}

}
