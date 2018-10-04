package lineardataStructures;

public class TestArrayStack {

	public static void main(String[] args) {

		ArrayStack<Integer> stack=new ArrayStack<>(20);
		stack.Push(1);
		stack.Push(2);
		stack.Push(3);
		stack.Push(4);
		stack.Push(5);
		stack.Push(6);
		Integer my=stack.Top();
		my=56;
		System.out.println(my);

		System.out.println(stack);



	}
}


