package binarysearchcodes;

import java.util.Scanner;

import sortingAlgorithms.InsertionSort;
import sortingAlgorithms.TestSort;

public class TestBinarySearch {

	public static void main(String[] args) {
	

		int[] array=TestSort.Arrayinitialization(100, 100);

		InsertionSort.Insertion_Sort(array);

		for (int i = 0; i < array.length; i++) {

			if(array[i]<10)
				System.out.print(" ");

			System.out.print(array[i]+" ");

			if ((i+1)%10==0)
				System.out.println();

		}

		Scanner scanner=new Scanner(System.in);


		System.out.println("\nPlease insert a value between 0 to 100 to search in the array: ");
		int value=scanner.nextInt();
		int index=BinarySearch.BinarySearchRecursive(array, value);

		System.out.println("Recursive binary search  for value "+value+" is in index: "+index);

		index=BinarySearch.BinarySearchIterative(array, value);
		System.out.println("Iterative binary search  for value "+value+" is in index: "+index);

		scanner.close();


	}

}
