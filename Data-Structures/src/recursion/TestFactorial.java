package recursion;

import java.util.Scanner;

public class TestFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please insert a positive number to calculate its facturial: ");
		num=scanner.nextInt();
		
		System.out.println("Factorial is: "+Facturial.FactorialViaRecursion(num));
		
		System.out.println("Double checking: "+ Facturial.factorialViaIterative(num));
		
		
		scanner.close();
	}

}
