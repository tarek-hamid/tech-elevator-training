package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main (String[] args) {
		Scanner userInputFile = new Scanner(System.in);
		System.out.println("What is the file that should be searched?");
		String userPath = userInputFile.nextLine();
		File outputFile = new File(userPath);

		Scanner userSearchWord = new Scanner(System.in);
		System.out.println("What is the search word you are looking for?");
		String searchWord =  userSearchWord.nextLine();

		Scanner caseSensitive = new Scanner(System.in);
		System.out.println("Should the search be case sensitive? Y/N");
		String yesOrNo = caseSensitive.nextLine();


		int lineNumber = 1;
		try {
			Scanner dataInput = new Scanner(outputFile);
			while (dataInput.hasNext()) {
				String inputLine = dataInput.nextLine();
				if(yesOrNo.equals("N")){
					if(inputLine.toLowerCase().contains(searchWord.toLowerCase())){
						System.out.println(lineNumber + ") " + inputLine);
					}
				} else if (inputLine.contains(searchWord)){
					System.out.println(lineNumber + ") " + inputLine);
				}
				lineNumber++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println("The file was not found. ");
		}
	}
}
