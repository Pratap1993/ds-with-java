package com.chagu.ds.recursion;

public class FibonacciUsingRecursion {

	public static int printFibonacciSeries(int number) {
		if (number < 1) {
			throw new RuntimeException("Please Provide Valid Number !!!");
		} else if (number == 1 || number == 2) {
			return number - 1;
		} else {
			return printFibonacciSeries(number - 1) + printFibonacciSeries(number - 2);
		}

	}

	public static void main(String[] args) {
		System.out.println(printFibonacciSeries(10));
	}

}
