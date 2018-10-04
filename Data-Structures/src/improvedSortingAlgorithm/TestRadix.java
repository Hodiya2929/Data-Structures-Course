package improvedSortingAlgorithm;

public class TestRadix {

	public static void main(String[] args) {

		int[] array1=sortingAlgorithms.TestSort.Arrayinitialization(10000000, 500000000);
		int[] array2=sortingAlgorithms.TestSort.Arrayinitialization(1000000, 500000000);

		long end,start;

		start=System.currentTimeMillis();
		array1=RadixSort.Radix_Sort(array1, 9);
		end=System.currentTimeMillis();

		System.out.println("Time to sort by arrays version: "+ (end-start)+" miliseconds ");

		start=System.currentTimeMillis();
		array2=RadixSort.RadixByLinkedList(array2, 9);
		end=System.currentTimeMillis();

		System.out.println("Time to sort by LinkedList version: "+ (end-start)+" miliseconds \n");


	}

}
