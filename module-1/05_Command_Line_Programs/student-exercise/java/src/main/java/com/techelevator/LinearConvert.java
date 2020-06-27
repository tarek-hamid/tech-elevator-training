package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner length = new Scanner(System.in);
		System.out.print("Please enter the desired length to be converted: ");
		String input = length.nextLine();
		int inputLength = Integer.parseInt(input);

		System.out.print("Is this length in (m)eters or (f)eet?");
		input = length.nextLine();

		if (input.equals("m")){
			System.out.println(inputLength + " meters is " + (int)(inputLength * 3.2808399)  + " feet");
		} else {
			System.out.println(inputLength + " feet is " + (int)(inputLength * 0.3048)  + " meters");
		}
	}
}


