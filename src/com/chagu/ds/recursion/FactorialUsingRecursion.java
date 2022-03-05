package com.chagu.ds.recursion;

public class FactorialUsingRecursion {

	// 5! = 5*4*3*2*1
	public static int findFactorial(int number) {
		if (number == 0) {
			return 1;
		} else {
			return (number * findFactorial(number - 1));
		}
	}

	public static void main(String[] args) {
		System.out.println(findFactorial(5));
	}
}