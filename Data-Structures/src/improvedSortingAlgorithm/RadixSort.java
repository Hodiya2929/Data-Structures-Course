package improvedSortingAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {

	/**
	 * 
	 * @param array - to be sorted.
	 * In this class I'm going to implement 2 versions of radix sort. The
	 * first version is through arrays ant the other is through linked-lists. 
	 * 
	 * Radix-sort is a subroutine of counting sort. 
	 * Sort by the least significant digit .... finally sort by the most significant digit.
	 * The big advantage of this algorithm when compared to counting sort is that k- the maximum value is not 
	 * bounded. (k can by polynomial in n ) k=n^O(1). 
	 * d - # digits -> d = ( log b (k) + 1 ) - we make d iterations.
	 * For each iteration we have O(n+b) and we do it d iterations, so we have
	 * O(n+b)*d)=(n+b)*log b(k) - what should b to be (or not to be ): ) if we want 
	 * to get minimal time? b should be n, and if k is polynomial in n we get k=n^c ant thus
	 * O(nlog(n)(k) - O(n*c)
	 * 
	 * 
	 * The assumption is that we are sorting integers(this is a big assumption),
	 * but its not quite difficult to represent an object by an integer. In addition its a 
	 * much more convenient to work with positive numbers.
	 * 

	 */

	public static int[] Radix_Sort(int[] array, int numOfDigits) {

		int digitindex,position=0,whichdigit=1;

		int length=array.length;

		for(int i=0;i<numOfDigits;i++) {

			if(i!=0)
				whichdigit*=10;	
			
			int [] temparray=new int [length];

			position=0;

			for(int j=0;j<10;j++) {

				for(int r=0;r<length;r++) {

					digitindex=DigitInIthPlace(array[r],whichdigit);

					if(digitindex==j)
						temparray[position++]=array[r];

				}
			}
			array=temparray;
		}


		return array;
	}

	public static int[] RadixByLinkedList (int[] array,int numOfDigits) {

		int whichdigit=1;
		int length=array.length;
		int remainder,position=0;

		for (int i=0;i<numOfDigits;i++) {
			position=0;

			if(i!=0)
			whichdigit*=10;

			List<LinkedList<Integer>> arraylists=new ArrayList<>(10);

			for (int f = 0; f <10; f++) 
				arraylists.add(new LinkedList<Integer>());
			
			for(int k=0;k<10;k++)
			for (int j=0;j<length;j++)
				 {
					remainder=DigitInIthPlace(array[j], whichdigit);
					if(remainder==k)
						arraylists.get(k).add(array[j]);
				}

			for (LinkedList<Integer> linkedList : arraylists) {
				while(!linkedList.isEmpty())
					array[position++]=linkedList.pollFirst();

			}

		}

		return array;
	}

	public static int DigitInIthPlace(int num,int digit) {

		int temp=num;

		temp/=digit;

		return temp%10;
	}

}
