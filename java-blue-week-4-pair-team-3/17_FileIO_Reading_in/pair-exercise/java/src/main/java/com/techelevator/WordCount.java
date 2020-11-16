package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.PatternSyntaxException;

public class WordCount {

	public static void main(String[] args) throws FileNotFoundException {

		try {
			Scanner dataInput =  new Scanner(new File("alices_adventures_in_wonderland.txt"));
			int wordCount = 0;
			int sentCount = 0;

			while (dataInput.hasNext()) {
				String lineOfInput = dataInput.nextLine();
				String[] words = lineOfInput.split(" ");
				for (String word: words) {
					if(word.equals("")) {
						wordCount--;
					}
					if (word.contains("?") || word.contains("!") || word.contains(".")){
						sentCount++;
					}
					wordCount++;
				}
			}
				System.out.println("Word Count: " + wordCount);
				System.out.println("Sentence Count: " + sentCount);

		} catch (PatternSyntaxException ex) {
			System.out.println("do something" + ex.getMessage());
		}

	}
}
