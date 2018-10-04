package lineardataStructures;

public class SortedLinkedList<T extends Comparable<T>>  {

	int size;
	Node<T> head,tail;


	public SortedLinkedList() {

		head=tail=null;
		size=0;

	}

	public void add(T object) {

		if(head==null) {

			head=new Node<T>(object, null);
			tail=head;
		}
		else if (object.compareTo(head.data)<0) {

			Node<T> newnode=new Node<T>(object, head);
			head=newnode;
		}

		else {
			Node<T> prev = null,temp=head;

			while(temp!=null&&temp.data.compareTo(object)<0) {
				prev=temp;
				temp=temp.next;
			}
			if(temp==null) {

				Node<T> last=new Node<T>(object, null);
				tail.next=last;
				tail=last;

			}
			else {
				Node<T> newnode=new Node<T>(object,temp);
				prev.next=newnode;

			}
		}
		size++;

	}

	public T Reomove(T object) {

		if(head==null)
			return null;

		else if(head.data.compareTo(object)==0) {
			head=head.next;
			size--;
			return object;
		}
		else {
			Node<T> prev=null,temp=head;

			while(temp.next!=null&&temp.data.compareTo(object)<0)
			{
				prev=temp;
				temp=temp.next;
			}

			if(temp.next==null&&temp.data.compareTo(object)==0) {
				prev.next=null;
				size--;	
				return object;
			}
			else if(temp.next!=null&&temp.data.compareTo(object)==0) {
				prev.next=temp.next;
				size--;
				return object;
			}
		}

		return null;

	}




	public String toString() {

		String s="[ ";
		Node<T> temp = head;
		while (temp!=null) {
			s+=temp.data.toString();
			if(temp.next!=null)
				s+=" -> ";
			temp=temp.next;
		}
		s+=" ]";
		return s;

	}

	public static void main(String[] args) {

		SortedLinkedList<Integer> sorted=new SortedLinkedList<>();

		sorted.add(3);
		sorted.add(5);
		sorted.add(1);
		System.out.println(sorted);
		sorted.add(2);
		sorted.add(4);
		System.out.println(sorted);
		sorted.add(6);
		sorted.add(0);
		System.out.println(sorted);
		sorted.Reomove(3);
		System.out.println(sorted);
		sorted.Reomove(6);
		System.out.println(sorted);
		sorted.Reomove(0);
		System.out.println(sorted);
		sorted.Reomove(2);
		System.out.println(sorted);

	}


}
