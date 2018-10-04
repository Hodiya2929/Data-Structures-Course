package recursion;


/**
 * 
 * @author òéîğåàì
 *
 *GCD - Greatest Common Divisor.  The GCD of two integers A and B is the largest number that divides both A and B.
The Euclidean Algorithm is a technique for quickly finding the GCD of two integers.
When we say that Y divides X - we mean that n exist, so that: n*Y=X. We can conclude that for any given number: 0*X=0 
and thus we can say that X divides 0 as X belongs to the natural numbers. Now its easy to understand why GCD(X,0)=X for any integer X. 
(The largest number which x divide is itself).
Suppose we have two integers A and B (lets say A>B) - we can always write 
A=B*Q+R, as R>=0 and R <b.In order to prove that GCD(A,B)=GCD(B,R), first we need to prove that GCD(A,B)=GCD(A,A-B)
Proof: by definition the GCD of A and B divide both A and B, thus we can write x*GCD(A,B)=A and y*GCD(A,B)=B. Lets
denote C=A-B = x*GCD(A,B) -y*GCD(A,B)=GCD(A,B)(X-Y)=C , hence GCD(A,B) divides C. Using the same way, 
we can also prove that GCD(B,C) divides A.
GCD(A, B) must be less than or equal to, GCD(B, C) because GCD(B, C) is the “greatest” common divisor of B and C.
GCD(B, C) must be less than or equal to, GCD(A, B) because GCD(A, B) is the “greatest” common divisor of A and B.
Given that GCD(A,B)<=GCD(B,C) and GCD(B,C)<=GCD(A,B) we can conclude that: GCD(a,b)=GCD(b,c).
Proof that GCD(A,B) = GCD(B,R)
We proved that GCD(A,B)=GCD(B,A-B)
The order of the terms does not matter so we can say GCD(A,B)=GCD(A-B,B)
We can repeatedly apply GCD(A,B)=GCD(A-B,B) to obtain:
GCD(A,B)=GCD(A-B,B)=GCD(A-2B,B)=GCD(A-3B,B)=...=GCD(A-Q*B,B)
But A= B*Q + R so  A-Q*B=R
Thus GCD(A,B)=GCD(R,B)
The order of terms does not matter, thus:
GCD(A,B)=GCD(B,R)
*/


public class GCD {

	public static int GCDrecursion(int a, int b) {

		if (b==0)
			return a;

		return GCDrecursion(b, a%b);

	}
	
	public static int GCDiterative (int a ,int b) {

		int temp;

		while (b!=0) {
			
			temp=Math.max(a, b);
			a=Math.min(a, b);
			b=temp%a;

		}

		return a;
	}

	public static void main(String[] args) {

		System.out.println(GCDiterative(1071, 1029));
		System.out.println(GCDrecursion(1071, 1029));

	}

}
