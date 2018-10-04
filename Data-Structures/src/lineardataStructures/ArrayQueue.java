package lineardataStructures;

public class ArrayQueue<T> {

	T arr[];
	int size,capasity;
	int head,tail;

	@SuppressWarnings("unchecked")

	public ArrayQueue(int capasity){

		this.capasity=capasity;

		arr=(T[]) new Object[capasity];

		size=0;

		head=tail=-1;
	}

	public boolean isEmpty() {

		return(size==0);

	}

	public boolean isFull() {

		return (size==capasity);

	}

	public boolean Enqueue(T obj) {

		if (isFull()) {
			System.out.println("queue is full.");

			return false;
		}

		else if(isEmpty()) {
			head=tail=0;

			arr[head]=obj;

		}
		else {

			tail=++tail%capasity;
			arr[tail]=obj;
		}

		size++;
		return true;

	}

	public T Dequeue() {

		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		
		T temp;
		
		if(tail==head) {
			temp=arr[tail];
			head=tail=-1;
		}
		else {
			temp=arr[head];
			head=++head%capasity;
		}
		size--;
		return temp;
		
	}
	
	public String toString() {
		
		StringBuilder builder=new StringBuilder();
		builder.append("[ ");
		int temp=head;
		int counter=1;
				while(counter<=size) {
					builder.append(arr[temp]).append(" ");
					temp=++temp%capasity;
					counter++;
				}
		
		builder.append(" ]");
		return builder.toString();
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayQueue<Integer> queue=new ArrayQueue<>(20);
		
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
