package lineardataStructures;
/**
 * A class that represents a generic stack. Stack is an abstract data structure, in which elements comes off in LIFO
 * order. In this class the stack is implemented using an array.
 * 
 * @version 1.0
 * @author Imanuel Eyal.
 */
public class ArrayStack<T> {

	private T array[];
	private int out,size,capacity;

	/**
	 * Construct an empty stack.
	 * @param capasity - The initial capacity of the array.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity){
		this.capacity=capacity;
		array=(T[])new Object[capacity];
		size=0;out=-1;
	}
	/**
	 * Add elements to the stack.
	 * @param obj - The element to be added to the stack. 
	 * @return true if the actual size of the stack is less than the capacity, flase otherwise.
	 */
	public boolean Push(T obj) {

		if(size<capacity) {
			array[++out]=obj;
			size++;
			return true;
		}

		else 
			return false;
	}
	/**
	 * 
	 * @return The number of elements that are in the stack.
	 */

	public int Size() {
		return size;
	}
	/**
	 * 
	 * @return true if the stack is empty, flase otherwise.
	 */
	public boolean isEmpty() {
		return(size==0);
	}
	/**
	 * 
	 * @return true is the stack is full, false otherwise.
	 */
	public boolean isFull() {
		return(size==capacity);
	}
	/**
	 * 
	 * @return The top element of the stack, that is the last element that was pushed.
	 */
	public T Top() {

		if(size>0)
			return array[out];
		else return null;
	}
	/**
	 * 
	 * @return And removes the top elements. If the stack is empty returns null.
	 */
	public T Pop() {

		if(size>0) {
			size--;
			return array[out--];
		}
		else return null;
	}

/**
 * return a string representation of this stack.
 */
	@Override
	public String toString() {

		StringBuilder builder=new StringBuilder();
		int counter=out;
		while(counter>-1) {
			builder.append(array[counter].toString()+"\n");
			if(counter!=0)
				builder.append("^"+"\n"+"|"+"\n");
			counter--;
		}
		return builder.toString();

	}


}
