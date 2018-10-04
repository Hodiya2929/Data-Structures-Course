package hashing;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class InitializeArray {

	List<Character> textFile;

	public InitializeArray() {

		textFile=new ArrayList<>();
	}

	public void Initilization(String nameOfFile) {

		try {
		
			InputStream in = InitializeArray.class.getResourceAsStream(nameOfFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
			int nextChar;
			
			while ((nextChar=reader.read())!=-1)
				textFile.add((char)nextChar);
			
			reader.close();
			
		} catch  (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}
