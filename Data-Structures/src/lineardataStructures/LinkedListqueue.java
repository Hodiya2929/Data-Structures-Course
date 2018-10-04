package lineardataStructures;

public class LinkedListqueue<T> {

	LinkedList<T> queue;
	int size;

	public LinkedListqueue() {

		queue=new LinkedList<>();
		size=0;
	}

	public boolean Enqueue(T obj) {
		
		if(obj!=null) {
			
			queue.add(obj);
			size++;
			return true;
			
		}
		
		else return false;
	}

	public T Dequeue() {
		size--;
		return queue.RemoveFirst();

	}

	public boolean isEmpty() {

		return (size==0);
	}

	@Override

	public String toString() {

		StringBuilder builder=new StringBuilder();
		builder.append("[ ");

		Node<T> temp=queue.head;
		while(temp!=null) {

			builder.append(temp.data.toString()+" ");
			temp=temp.next;


		}
		builder.append("]");

		return builder.toString();

	}



	public static void main(String[] args) {
		LinkedListqueue<Integer> queue=new LinkedListqueue<>();

		for (int i = 0; i < 20; i++) {

			int x=(int)(Math.random()*100+1);

			System.out.println("Enqueue: "+x );

			queue.Enqueue(x);

			System.out.println(queue);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		for (int i = 0; i < 20; i++) {

			Integer x=queue.Dequeue();

			System.out.println("Dequeue: "+x );
			System.out.println(queue);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

	}

}


