package sortingAlgorithms;

public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1,arr2,arr3;

	
		arr1= Arrayinitialization(100000, 1000000);
		arr2= Arrayinitialization(100000, 1000000);
		arr3= Arrayinitialization(100000, 1000000);

		long starttime=System.currentTimeMillis();
		SelectionSort.Selection_Sort(arr1);
		long time=System.currentTimeMillis()-starttime;
		System.out.println("Time for selection sort is: "+time+" milisec");
		starttime=System.currentTimeMillis();
		BubbleSort.Bubble_Sort(arr2);
		time=System.currentTimeMillis()-starttime;
		System.out.println("Time for bubble sort is: "+time+" milisec");
		starttime=System.currentTimeMillis();
		InsertionSort.Insertion_Sort(arr3);
		time=System.currentTimeMillis()-starttime;
		System.out.println("Time for insertion sort is: "+time+" milisec");

	}

	public static int[] Arrayinitialization (int size,int max ) {

		int[] array=new int[size];

		for (int j = 0; j < array.length; j++) 
			array[j]=(int) (Math.random()*max);

		return array;


	}
}