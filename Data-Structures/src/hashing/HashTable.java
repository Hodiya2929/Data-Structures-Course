package hashing;

import java.util.HashMap;


public class HashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> myHashMap =new HashMap<>();
		
		myHashMap.put(1, "To learn to Data-Structure");
		myHashMap.put(2, "To learn to Algorithms");
		myHashMap.put(3, "To learn to CPP");
		
		System.out.println(myHashMap);
		
		myHashMap.put(1, "To watch GameOfThrones");
		
		System.out.println(myHashMap);
		
		String x="c";
		System.out.println(x.hashCode());
		
		
	}

}
