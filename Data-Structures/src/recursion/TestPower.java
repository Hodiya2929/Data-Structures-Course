package recursion;

import java.util.Scanner;

public class TestPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int base,power;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please insert a base and a power: ");
		base=scanner.nextInt();
		power=scanner.nextInt();

		System.out.println(base+" in power of "+power +"is: "+Power.PowerViaRecursion(base,power));

		System.out.println("Double checking: "+ Power.PowerViaIterative(base,power));

		System.out.println("Power in improved way: "+ Power.PowerLogComplexity(base, power));
		
		scanner.close();
	}




}

