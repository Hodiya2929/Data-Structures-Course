package hashing;


import java.util.Iterator;
import java.util.Scanner;

public class StartMenu {

	String wordToSearch;
	String nameOfFile;
	Scanner scan;



	public StartMenu() {

		scan=new Scanner(System.in);
	}

	public void StartApp() {

		
		System.out.println("Please insert a name of text file in resources folder: ");
		//nameOfFile=scan.nextLine();
	
		
		InitializeArray charArray=new InitializeArray();
		charArray.Initilization("data.txt");
		
		System.out.println("Please insert a word to search: ");
		wordToSearch=scan.nextLine();
		
		Karp_Rabin_Algorithm karp=new Karp_Rabin_Algorithm();
		
		karp.getHashOfSearchWord(wordToSearch);
		karp.getHashOfArray(charArray.textFile, wordToSearch);
		Iterator<Integer> myIterator=karp.indexesInArray.iterator();
		
		while(myIterator.hasNext())
			System.out.println(myIterator.next());
		
	}
	
	public static void main(String[] args) {
		
	StartMenu menu=new StartMenu();
	menu.StartApp();
	
	
	
	
	}
	
}
