package main.java;

import java.math.BigInteger;

public class Term {
	
	private int coefficient, exponent, value;
	private String expression;
	
	public Term(int givenCoefficient, int givenExponent)
	{
		coefficient = givenCoefficient;
		exponent = givenExponent;
		value = (int) Math.pow(coefficient, exponent);
	}
	
	public String toString()
	{
		if (exponent == 0) {
			return Integer.toString(coefficient);
		}
		expression = Integer.toString(coefficient) + "x";
		if (exponent > 1) {
			expression = expression + "^" + Integer.toString(exponent);
		}
		
		return expression;
		
	}
	
	public int getExponent()
	{
		return exponent;
	}
	
	public int getValue() {
		return value;
	}
}