package main.java;

public class Term {
	
	private int coefficient, exponent;
	private String expression;
	
	public Term(int givenCoefficient, int givenExponent)
	{
		coefficient = givenCoefficient;
		exponent = givenExponent;
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
}