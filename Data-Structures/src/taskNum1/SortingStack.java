package taskNum1;

public class SortingStack {

	public static MyArrayStack<Integer> StackSorting(MyArrayStack<Integer> stack) {

		MyArrayStack<Integer> tempstack=new MyArrayStack<>(stack.capacity());

		Integer temp;

		while(!stack.empty())
		{

			temp = stack.pop();


			while(!tempstack.empty() && tempstack.top() >temp)

			{
				stack.push(tempstack.pop());
			}


			tempstack.push(temp);
		}
		
		return tempstack;
	}

}




