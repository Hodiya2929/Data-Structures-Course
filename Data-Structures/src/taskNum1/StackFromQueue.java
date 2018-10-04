package taskNum1;

public class StackFromQueue {

	private MyArrayQ<Integer> queue;

	public StackFromQueue(int capacity) {

		queue=new MyArrayQ<>(capacity);
	}

	public void Push(int num) {

		queue.add(num);

		int temp;

		for(int i=1;i<queue.size;i++) {

			temp=queue.remove();
			queue.add(temp);
		}


	}

	public int Pop() {

		if(isEmpty()) {
			System.out.println("Can't pop - stack is empty!");
			return -1;
		}
		else
			return	queue.remove();

	}

	public boolean isEmpty() {

		return queue.isEmpty();
	}

	public String toString() {

		String st="[ ";

		int temp;

		for(int i=0;i<this.queue.size;i++)
		{
			temp=queue.remove();
			st+=temp+" ";
			queue.add(temp);
		}
		st+=" ]";
		return st;
	}


}
