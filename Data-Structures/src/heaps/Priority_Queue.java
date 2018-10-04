package heaps;

public class Priority_Queue {

	Task[] heapTasks;
	int size,capasity;

	public Priority_Queue() {

		heapTasks=new Task[11];// We start to fill array from index 1 
		size=0;
		capasity=10;
	}

	public int getParent(int index) {

		return index/2;
	}

	public int getLeftChild(int index) {

		return index*2;
	}

	public int getRightChild(int index) {

		return index*2+1;
	}

	public Priority_Queue(int capasity) {

		heapTasks=new Task[capasity+1];// We start to fill array from index 1 
		size=0;
		this.capasity=capasity;
	}

	public boolean isEmpty() {

		return size==0;
	}

	public boolean isFull() {

		return size==capasity;
	}


	public int size() {

		return size;
	}

	public void insertWork(String work,int priority) {

		if(isFull()) {
			System.out.println("Array is full, can't add new task.");
			return;
		}

		Task newTask=new Task(work,priority);
		heapTasks[++size]=newTask;

		int current=size, parent=getParent(current);
		while (current>1 && heapTasks[current].priority>heapTasks[parent].priority) {

			Task temp=heapTasks[parent];
			heapTasks[parent]=newTask;
			heapTasks[current]=temp;

			current=parent;
			parent=getParent(current);
		}
	}

	public Task removeTask() {//removes the task with max priority

		Task taskToReturn=null;

		if(isEmpty()) 
			System.out.println("Can't remove, heap is empty.");

		else {

			int current=1,left=getLeftChild(current),right=getRightChild(current);

			taskToReturn=heapTasks[current];

			heapTasks[current]=heapTasks[size--];
			int largest=current;


			while(current<size) {

				if(left<=size&&heapTasks[left].priority>heapTasks[current].priority) 
					largest=left;


				if(right<=size&&heapTasks[right].priority>heapTasks[largest].priority) 
					largest=right;

				if(largest!=current) {

					Task temp=heapTasks[current];
					heapTasks[current]=heapTasks[largest];
					heapTasks[largest]=temp;

					current=largest;
					left=getLeftChild(current);
					right=getRightChild(current);
				}
				else break;
			}
		}
		return taskToReturn;
	}


	public static void main(String[] args) {

		Priority_Queue heap=new Priority_Queue();

		heap.insertWork("To be everyday with Tinoket Hadar Sinwany Eyal", 0);
		heap.insertWork("Test in data structure is at 11:30", 100);
		heap.insertWork("Help mama to wash the floor", 10);
		heap.insertWork("Finish all the arrengements to Rosh-Hashana", 0);
		heap.insertWork("Start volunteering in Ramat-Hasharon municipality", 6);
		heap.insertWork("Start to learn to C++", 15);
		heap.insertWork("Learn to Algorithems 2", 20);
		heap.insertWork("Learn to Databases", 25);
		heap.insertWork("Watch 'shababnikim' series tv", -1000000);
		heap.insertWork("Watch 'Breaking Bad' series tv", -2000000);


		for (int i=1;i<=heap.size;i++) 

			System.out.println(heap.heapTasks[i]);
		
		System.out.println();

		int currentsize=heap.size;

		for (int i=1;i<=currentsize;i++) {

			System.out.println(heap.removeTask());
		}
		
		System.out.println(heap.isEmpty());




	}

}
