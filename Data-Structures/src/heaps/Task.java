package heaps;;

public class Task {
	
	
	String work;
	int priority;
	
	public Task(String work, int priority) {
		
		this.work=work;
		this.priority=priority;
	}

	@Override
	public String toString() {
		return "Task [work=" + work + ", priority=" + priority + "]";
	}
	

}
