package taskNum1;


public class MyArrayStack<T> {

	T[] a;
	int size = 0;
	
	@SuppressWarnings("unchecked")
	public MyArrayStack(int capacity) {
		a = (T[]) new Object[capacity];
	}
	
	public boolean push(T data) {
		if(size == a.length) return false;
		a[size] = data;
		size++;
		return true;
	}
	
	public T pop() {
		if(size == 0) return null;
		return (T)a[--size];
	}
	
	public T top() {
		if(size == 0) return null;
		return (T)a[size-1];
	}
	
	public boolean empty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return a.length;
	}
	
	public void clear() {
		size = 0;
	}
	
	public boolean search(T data) {
		for(int i=0; i<size; i++)
			if(a[i].equals(data))
				return true;
		return false;
	}
}
