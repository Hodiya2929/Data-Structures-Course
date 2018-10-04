package taskNum1;

public class TestSortingStack {

	public static void main(String[] args) {
		
		MyArrayStack<Integer> stack=new MyArrayStack<>(20);
		
		stack.push(20);
		stack.push(3);
		stack.push(100);
		stack.push(-4);
		stack.push(24);
		
		stack=SortingStack.StackSorting(stack);
		while(!stack.empty())
		System.out.println(stack.pop());
		

	}

}
