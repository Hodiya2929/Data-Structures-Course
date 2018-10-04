package recursion;


public class Facturial {

	/**
	 *In this class, I will introduce 2 implementations to calculate a 
	 *factorial of a number: first via recursion and via the iterative way.
	 */
	public static int FactorialViaRecursion(int number) {

		if (number==1)
			return 1;

		return number*FactorialViaRecursion(number-1);

	}

	public static int factorialViaIterative(int number) {

		int sum=1;

		while (number>1) {

			sum*=number;
			
			number--;
		}

		return sum;
	}

}
