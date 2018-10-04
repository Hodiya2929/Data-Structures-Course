package recursion;

public class Mystery {
/**
 * 
 * @param s - String as argument
 * @return - The question was - what is the purpose of this function.
 * 
 * 
 * It is possible to use induction to show that the function reverses the string argument. 
Base case n=1: if n=1 that the function returns s. 
Induction hypothesis -the claim holds for any argument in size of |n|.
Induction step: we need to show that the claim holds for strings arguments
 in size of |n+1| - by looking at the code reversed(s)=y+x,
the claim holds for both y and x as they are in size of |(n+1)/2|.
 */
	public static String mystery(String s){
		
		int len = s.length();
		
		if (len <= 1)
			return s;
		
		String a = s.substring(0, len/2);
		String b = s.substring(len/2, len);
		
		String x = mystery(a);
		String y = mystery(b);
		
		return y + x;
		
	}



	public static void main(String[] args) {
		
		String s = mystery("abcde");
		System.out.println(s);
		
		System.out.println(mystery("123456789"));
		
	}
}

