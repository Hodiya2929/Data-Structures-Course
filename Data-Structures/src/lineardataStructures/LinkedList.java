package lineardataStructures;

import java.util.InputMismatchException;
import java.util.Iterator;


public class LinkedList<T> {

	int size=0;
	Node<T> head,tail;

	public LinkedList() {
		head=tail=null;
		size=0;
	}

	public void add(T object) {
		if(head==null) {

			head=new Node<T>(object,null);
			tail=head;
			size++;
		}

		else {

			Node<T> temp =new Node<>(object,null);
			tail.next=temp;
			tail=temp;
			size++;
		}

	}

	public void addToIndex(int index,T object) {

		if(size==index)
			add(object);

		else if(index==0&&size>0) {
			Node<T> temp=new Node<>(object,head);
			head=temp;
			size++;
		}

		else if(index>=0&&index<size) {

			Node<T> count=head;
			int counter=1;

			while(counter++<index) 
				count=count.next;

			Node<T> temp=new Node<>(object,count.next);
			count.next=temp;
			size++;

		}	

		else 
			throw new InputMismatchException("Index is wrong");
	}

	public T GetElement(int index) {

		if(index>=0&&index<size) {
			Node<T> temp=head;
			int counter=0;
			while(counter++<index)
				temp=temp.next;
			return temp.data;
		}
		else
			throw new InputMismatchException("Index is wrong");
	}


	public T RemoveFirst() {

		Node<T> temp=head;
		T value=head.data;

		//if(temp==null) 
		//	throw new NoSuchElementException("LinkedList is empty");

		if(temp.next==null) {
			head=tail=null;
			size--;
		}

		else {
			temp=temp.next;
			head=temp;
			size--;
		}

		return value;
	}

	public T RemoveLast() {

		Node<T> last=head,prev=head;
		T temp;

		if(last==null) 
			return null;
		//throw new NoSuchElementException("LinkedList is empty");

		if(last.next==null) {
			temp=head.data;
			size--;
			head=tail=null;
			return temp;

		}

		else {

			while(last.next!=null) {
				prev=last;
				last=last.next;

			}
			temp=tail.data;
			prev.next=null;
			tail=prev;
			return temp;
		}

	}

	@Override
	public String toString() {

		String s="[ ";

		Node<T> temp=head;

		while(temp!=null) {

			s+=temp.data.toString();
			if(temp.next!=null)
				s+=" -> ";
			temp=temp.next;

		}
		return s+" ]";
	}


	public Iterator<T> GetIterator(){

		class LinkedIterator implements Iterator<T>{

			int itersize=0;

			@Override
			public boolean hasNext() {

				return (itersize<size);
			}


			public T next() {
				return (T) GetElement(itersize++);

			}

		}
		return new LinkedIterator();
	}

	public static void main(String[] args) {

		LinkedList<Integer> mylinked=new LinkedList<>();

		mylinked.addToIndex(0, 1);
		System.out.println(mylinked);
		mylinked.add(2);
		mylinked.add(3);
		mylinked.add(4);
		mylinked.add(5);
		mylinked.addToIndex(3, 10);

		System.out.println(mylinked);

	}

}
