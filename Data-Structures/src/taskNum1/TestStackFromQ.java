package taskNum1;

public class TestStackFromQ {

	public static void main(String[] args) {

		StackFromQueue stack=new StackFromQueue(20);

		stack.Push(1);
		stack.Push(2);
		stack.Push(3);
		stack.Push(4);
		stack.Push(15);
		stack.Push(6);
		System.out.println(stack);
		
		stack.Pop();// 6
		System.out.println(stack);

		stack.Pop();//15
		System.out.println(stack);
		
		stack.Pop();//4
		System.out.println(stack);

		stack.Pop();//3
		System.out.println(stack);
		
		stack.Pop();//2
		System.out.println(stack);
		
		stack.Pop();//1
		System.out.println(stack);
	
		stack.Pop();//1
		System.out.println(stack);
	
	



	}

}
