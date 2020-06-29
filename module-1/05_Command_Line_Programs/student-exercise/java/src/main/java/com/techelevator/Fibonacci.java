package com.techelevator;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the Fibonacci number: ");
		String value = scanner.nextLine();
		int fibonacciNumber = Integer.parseInt(value);
		int temporaryVariable = 0;
		int previousTerm = 0;
		int sum = 1;
		System.out.print("0, 1");
		while (sum < fibonacciNumber) {
			temporaryVariable = sum;
			sum += previousTerm;
			previousTerm = temporaryVariable;
			if (sum < fibonacciNumber) {
				System.out.print(", " + sum);
			} else {
				break;
			}
		}
	}
}

