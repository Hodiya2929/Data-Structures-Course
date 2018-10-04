package lineardataStructures;

public class DoublyNode <T> {

	T data;
	DoublyNode<T> next,prev;
	
	public DoublyNode(T data, DoublyNode<T> next, DoublyNode<T> prev) {
		
		this.data = data;
		this.next = next;
		this.prev = prev;
	}






}
