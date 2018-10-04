package heaps;

import java.util.Arrays;

/**
 * (From Wikipedia)
 * Heap - is a specialized tree-based data structure that satisfies the heap property:
 *  if P is a parent node of C, then the key (the value) of P is either greater than or
 *   equal to (in a max heap) or less than or equal to (in a min heap) the key of C.[1] 
 *   The node at the "top" of the heap (with no parents) is called the root node.
 *   
 *   
 *  A complete binary tree is a tree in which all internal nodes have exactly two children
 *  and the leaves are all in the same level.
 *   A nearly complete binary tree is a tree that preserves 3 properties:
 *	Let H denote the height of the tree.
 *	1. All of the nodes which have (H-2) height have two children.
 *	2. If a node p in H-1 level has a left child, then all of the nodes that are left to it has two children.
 *	3. If a node in H-1 level has a right child, then it has a left child. 
 *
 * A heap is a nearly complete binary tree in which every node is bigger than its children.
 * 
 *
 * @author עימנואל
 *
 */

public class Heap {

	int size=0;
	int[] arr;


	public Heap() {
		size=0;
		arr=new int[100];
	}


	public Heap(int capasity) {

		arr=new int[capasity];
	}

	public void maxHeap(int i) {


		int largest;
		int left=getLeftChild(i),right=getRightChild(i);

		if(left<=size&&arr[i]<arr[left])
			largest=left;
		else largest=i;

		if(right<=size&&arr[largest]<(arr[right]))
			largest=right;

		if(largest!=i) {
			swap(largest,i);
			maxHeap(largest);
		}
	}


	private void swap(int largest, int i) {

		int temp=arr[largest];
		arr[largest]=arr[i];
		arr[i]=temp;
	}


	public int getParent(int index){

		return index/2;	
	}

	public int getLeftChild(int parent) {

		return 2*parent;
	}

	public int getRightChild(int parent) {

		return parent*2+1;
	}

	public void increaseKey(int index,int data) {

		if(arr[index]>(data))
			System.out.println("Key is smaller than current key");
		else {

			arr[index]=data;
			while (index>0&&arr[getParent(index)]<(arr[index])) {
				swap(getParent(index), index);
				index=getParent(index);
			}
		}
	}

	public void insertData(int data) {
		arr[++size]=Integer.MIN_VALUE;
		increaseKey(size, data);
	}

	public static void main(String[] args) {



		Heap my=new Heap();

		my.insertData(1);
		my.insertData(2);
		my.insertData(3);
		my.insertData(4);
		my.insertData(5);
		my.insertData(6);
		my.insertData(7);
		my.insertData(8);
		my.insertData(9);
		my.insertData(10);
		my.insertData(11);
		my.insertData(12);
		my.insertData(13);

		System.out.println(Arrays.toString(my.arr));


	}



}
