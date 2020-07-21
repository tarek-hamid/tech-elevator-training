package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// Part 1: New object to test methods, testing toString, getBalance, and validCardNumber.
		TellerMachine test = new TellerMachine("TestManufacturer", new BigDecimal("100.00"),
				new BigDecimal ("20.00"));
		System.out.println(test.toString());
		System.out.println(test.getBalance());
		System.out.println(test.validCardNumber("5785461235849756"));


		// Part 2: Reading csv file and printing out total balance.
		File dataFile = new File("data-files/TellerInput.csv");
		List<TellerMachine> listOfATMs = new ArrayList<TellerMachine>();
		BigDecimal totalBalance = new BigDecimal("0.00");
		try (Scanner dataInput = new Scanner(dataFile)) {
			while(dataInput.hasNext()){
				String lineOfInput = dataInput.nextLine();
				String[] parsedInput = lineOfInput.split(",");
				TellerMachine newInput = new TellerMachine(parsedInput[0], new BigDecimal(parsedInput[1]),
						new BigDecimal(parsedInput[2]));
				listOfATMs.add(newInput);
				totalBalance = totalBalance.add(newInput.getBalance());
			}
		} catch (FileNotFoundException ex){
			System.out.println("The file was not found.");
		}
		System.out.println("The total balance is: " + totalBalance);
	}

}
