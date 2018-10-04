package lineardataStructures;

public class DoublyLinkedList<T> {

	int size;
	DoublyNode<T> head,tail;


	public DoublyLinkedList() {

		size=0;
		head=new DoublyNode<T>(null,null,null);
		tail=new DoublyNode<T>(null,null,null);
	}

	public void AddLast(T object) {

		if (size==0) {
			head.data=object;
			tail=head;
			size++;
		}

		else {
			DoublyNode<T> temp = new DoublyNode<T>(object, null, tail);
			tail.next=temp;
			tail=temp;
			size++;
		}
	}

	public T RemoveFirst() {

		T ans=null;

		if(head!=null) {		
			ans=head.data;
			head=head.next;
			size--;


			if(head!=null)
				head.prev=null;
		}
		return ans;
	}

	public T RemoveLast() {

		T ans=null;

		if(tail!=null) {
			ans=tail.data;
			tail=tail.prev;
			size--;
			if (tail!=null)
				tail.next=null;
		}
		return ans;
	}

	public DoublyNode<T> Search(T object) {

		DoublyNode<T> iterate=head;
		while (iterate!=null&&iterate.data!=object)
			iterate=iterate.next;



		return iterate;
	}

	public T Remove(T object) {

		DoublyNode<T> temp=Search(object);

		T ans=null;

		if (temp!=null)
		{
			if(temp.prev==null)
				ans=RemoveFirst();
			else if(temp.next==null)
				ans=RemoveLast();
			else {
				ans=temp.data;
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
				size--;

			}
			
		}
		return ans;

	}


	public int size() {
		return size;
	}


	public String toString() {

		String s="[ ";

		DoublyNode<T> iterate=head;
		while (iterate!=null) {
			s+=iterate.data.toString();

			if(iterate.next!=null)
				s+=" -> ";

			iterate=iterate.next;
		}

		s+=" ]";
		return s;

	}

	public String BackwardsString() {

		String s="[ ";

		DoublyNode<T> iterate=tail;
		while (iterate!=null) {
			s+=iterate.data.toString();

			if(iterate.prev!=null)
				s+=" -> ";

			iterate=iterate.prev;
		}

		s+=" ]";
		return s;
	}

	public static void main(String[] args) {


		DoublyLinkedList<Integer> linked=new DoublyLinkedList<>();
		linked.AddLast(1);
		System.out.println(linked);

		linked.AddLast(2);
		System.out.println(linked);

		linked.AddLast(3);
		System.out.println(linked);
		
		linked.Remove(2);
		System.out.println(linked);


	}

}
