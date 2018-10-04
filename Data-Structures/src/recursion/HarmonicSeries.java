package recursion;

public class HarmonicSeries {
/**
 * 
 *Let us look at the sum of harmonic series as n tent to infinity
 * - proof that  (sigma) 1/n -  this sum is divergent: as we an infinite
 *  number of terms we can always choose a group of terms in size of 2^n 
 *  and show that this sum is greater than 1/2 and thus we have 1 + (sigma)1/2 as n 
 *  tent to infinity. e.g: 
     1. 1/3+1/4 >1/2 - as 1/3>14 and 1/4= 1/4...
     2. 1/5+1/6+1/7+1/8>1/2 - as 1/5>1/8 and 1/6>1/8 and so on...
 * 
 */
	public static double HarmonicInRecursion(double n) {
		
		if (n==1.0)
			return 1.0;
		
		return ((1.0/n)+HarmonicInRecursion(n-1));
		
	
	}
	
	public static void main(String[] args) {
		
		System.out.println(HarmonicInRecursion(10000));
		
	}

}
