package main.java;

public class Term {
	
	private int coefficient, exponent, value;
	
	/**Saves the coefficient, exponent, and calculates the total value
	 * @param givenCoefficient
	 * @param givenExponent
	 */
	public Term(int givenCoefficient, int givenExponent)
	{
		coefficient = givenCoefficient;
		exponent = givenExponent;
		value = (int) Math.pow(coefficient, exponent);
	}
	
	public String toString()
	{
		String expression = "";
		if (exponent == 0) {
			return Integer.toString(coefficient);
		}
		if(coefficient > 1)
		{
			expression = Integer.toString(coefficient);
		}
		expression += "x";
		if (exponent > 1) {
			expression = expression + "^" + Integer.toString(exponent);
		}
		
		return expression;
		
	}
	
	public int getExponent()
	{
		return exponent;
	}
	
	public int getCoefficient()
	{
		return coefficient;
	}
	
	public int getValue() {
		return value;
	}
}