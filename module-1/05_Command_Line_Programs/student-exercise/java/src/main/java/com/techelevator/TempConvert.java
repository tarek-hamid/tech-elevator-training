package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner temperature = new Scanner(System.in);
		System.out.print("Please enter the desired temperature to be converted: ");
		String value = temperature.nextLine();
		int inputTempNumber = Integer.parseInt(value);

		System.out.print("Is this temperature in F or C?");
		value = temperature.nextLine();

		if (value.equals("C")){
			System.out.println(inputTempNumber + "C is " + (int)((inputTempNumber * 1.8) + 32)  + "F");
		} else {
			System.out.println(inputTempNumber + "F is " + (int)((inputTempNumber - 32) / 1.8)  + "C");
		}
	}

}
