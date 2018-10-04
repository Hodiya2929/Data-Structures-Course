package lineardataStructures;

public class LinkedListStack<T> {


	LinkedList<T> lls;
	int size;

	public LinkedListStack() {

		lls=new LinkedList<>();
		size=0;

	}

	public void Add(T obj) {

		lls.add(obj);
		size++;

	}


	public T Top() {

		if(size>0) {
			return lls.tail.data;
		}
		else return null;
	}


	public T Pop() {

		if(size>0) {
			return lls.RemoveLast();
		}
		else return null;
	}

	public String toString() {

		StringBuilder s=new StringBuilder();
		Node<T> temp=lls.head;
		while(temp!=null) {

			s.append(temp.data.toString()+"\n");
			if(temp.next!=null)
				s.append("|"+"\n"+"^"+"\n");
			temp=temp.next;

		}

		return s.reverse().toString();

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListStack<Integer> stack=new LinkedListStack<>();
		stack.Add(1);
		stack.Add(2);
		stack.Add(3);
		stack.Add(4);
		stack.Add(5);
		stack.Add(6);
		
		stack.Pop();
	
		stack.Pop();
		
		System.out.println(stack);
	}

}
