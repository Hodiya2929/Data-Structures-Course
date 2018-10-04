package lineardataStructures;


public class CircularDoublyLinkedList<T> {

	int size;
	DoublyNode<T> head,tail;

	public CircularDoublyLinkedList(){
		size=0;
		head=tail=null;
	}

	public void add(T object) {

		if(head==null) {

			head=new DoublyNode<>(object,head, null);
			tail=head;
			size++;
		}
		else {

			DoublyNode<T> newNode=new DoublyNode<T>(object,head,tail);
			tail.next=newNode;
			tail=newNode;
			head.prev=tail;
			size++;

		}

	}


	@Override
	public String toString() {

		String s="[ ";

		DoublyNode<T> pass=head;
		int tempsize=size;

		while(tempsize>0)
		{
			s+=pass.data.toString();
			pass=pass.next;
			if(tempsize!=1)
				s+=" -> ";
			tempsize--;
		}


		s+=" ]";
		return s;
	}

	public T RemoveLast() {

		T ans=null;

		if(head==null)
			return ans;

		else if(head.next==head) {
			ans=head.data;
			head=tail=null;
			size--;
		}

		else {
			ans=tail.data;
			tail.prev.next=head;
			tail=tail.prev;
			head.prev=tail;
			size--;
		}
		return ans;

	}
	public T RemoveFirst () {

		T ans=null;

		if (head==null)
			return ans;

		else {

			ans=head.data;
			head=head.next;
			head.prev=tail;
			tail.next=head;
			size--;

		}
		return ans;

	}

	public boolean RemoveElement(T elem) {

		if(head==null)
			return false;

		else if (elem==head.data) {
			RemoveFirst();
			return true;
		}
	
		else {

			DoublyNode<T> temp=head;

			while(temp.next!=head&&temp.data!=elem) {
				temp=temp.next;
			}
			
			if(temp.next==head&&temp.data==elem) {
				RemoveLast();
				return true;
			}

			else if(temp.data==elem) {

				temp.next.prev=temp.prev;
				temp.prev.next=temp.next;
				size--;
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {

		CircularDoublyLinkedList<Integer> circular=new CircularDoublyLinkedList<>();
		circular.add(1);
		circular.add(2);
		circular.add(3);
		circular.add(4);
		circular.add(5);
		System.out.println(circular);
		circular.RemoveElement(4);
		circular.RemoveElement(1);
		System.out.println(circular);
	}


}
