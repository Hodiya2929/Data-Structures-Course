package recursion;

public class Power {
	
	/**
	 * In this class, I will introduce 2 implementations to calculate 
	 * an x power of a given number: the iterative way and through the recursion way.
	 */
	
	public static int PowerViaRecursion(int number,int base) {
		
		if (base==1)
			return number;
		
		return number* PowerViaRecursion(number, base-1);
		
	}
	
	public static int PowerViaIterative(int number, int base) {
		
		int sum=1;
		for(int i=1;i<=base;i++) {
			
			sum*=number;
		}
		
		return sum;
		
	}
	
	/**
	 * Both functions have a runtime of O(n) - and we can make even better,
 	   Let us examine the equation x^n=(x^n/2)^2 - thus we can change the algorithm
 	   Through the recursion, we return base^(power/2) or base * base^(power/2)
	   accordingly to the remainder of power module 2
	 */
	
	public static int PowerLogComplexity(int base,int power) {
		
		if (power==1)
			return base;
		
		if(power%2==0) {
			int calc=PowerLogComplexity(base, power/2);
			return calc*calc;
		}		
		else {
			
			int calc=PowerLogComplexity(base, power/2);
			return base*calc*calc;
		}
		
	}
	
	
	
}
