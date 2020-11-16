package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the file that should be searched?");
		String inputFile = input.nextLine();
		String outputFile = "replace_" + inputFile;

		try (Scanner dataInput = new Scanner(new File(inputFile));
			 PrintWriter dataOutput = new PrintWriter(new File(outputFile));) {
			System.out.println("What is the search word you are looking for?");
			String searchWord = input.nextLine();
			System.out.println("What is the replace word you are looking for?");
			String replaceWord = input.nextLine();

			while (dataInput.hasNext()) {
				String lineOfInput = dataInput.nextLine();
				if (lineOfInput.contains(searchWord)){
					dataOutput.println(lineOfInput.replace(searchWord, replaceWord));
				} else {
					dataOutput.println(lineOfInput);
				}
			}
		} catch(FileNotFoundException ex){
			System.out.println("This must be an existing file" + ex.getMessage());
			System.exit(1);
		}
	}
}
