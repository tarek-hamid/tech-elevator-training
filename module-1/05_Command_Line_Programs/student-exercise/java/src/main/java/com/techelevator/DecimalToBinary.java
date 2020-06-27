package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		// prompt the user for input, parse, and return as string.
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String[] string = scanner.nextLine().split(" ");

		// first for loop is for every decimal in the input string, second is for conversion (division method)
		for (int i = 0; i < string.length; i++) {
			int decimalValue = Integer.parseInt(string[i]);

			// Create string that will hold binary values to output in command line.
			// The string is reinitialized every iteration for every int in the user input.
			String binaryString = " ";

			// for loop for conversion using division method.
			for (int j = decimalValue; j > 0; j /= 2) {
				binaryString = (j % 2) + binaryString;
			}
			System.out.println(decimalValue + " in decimal is " + binaryString + "in binary.");
		}
	}
}
