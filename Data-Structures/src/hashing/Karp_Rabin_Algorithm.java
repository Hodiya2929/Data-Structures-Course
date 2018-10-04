package hashing;

import java.util.LinkedList;
import java.util.List;
import org.apache.commons.math3.primes.Primes;

public class Karp_Rabin_Algorithm {

	public static final int base=256;

	int hOfWord;
	int hOfText;
	int prime;
	
	List<Integer> indexesInArray;

	public Karp_Rabin_Algorithm() {
		hOfWord=0;
		hOfText=0;
		indexesInArray=new LinkedList<>();
	}

	public void getHashOfSearchWord(String word) {

		for(int i=0;i<word.length();i++) 
			hOfWord+=Math.pow(base,i)*(int)(word.charAt(i));

		prime=Primes.nextPrime(hOfWord);

	}

	public void getHashOfArray(List<Character> array, String word) {

		for(int i=0;i<word.length();i++) 
			hOfText+=(Math.pow(base,i))*(int)(array.get(i));

		if(hOfText==hOfWord) {
			if(isAMatch(array, word,0)) 
				indexesInArray.add(0);

		}

		for (int i=word.length();i<array.size();i++) {


			hOfText-=(int)(array.get(i-word.length()));
			hOfText/=base;
			
			hOfText+=(Math.pow(base, word.length()-1))*((int)array.get(i));

			if(hOfText==hOfWord) 
				if(isAMatch(array, word,i-word.length()+1)) 
					indexesInArray.add(i-word.length()+1);
			
		}

	}

	private boolean isAMatch(List<Character> array, String word,int startIndex) {

		boolean match=false;
		int arrayIndex=startIndex;

		for(int j=0;j<word.length();j++) {

			if(word.charAt(j)!=array.get(arrayIndex++)) 
				break;

			if(j==word.length()-1)
				match=true;
		}

		return match;
	}


}
