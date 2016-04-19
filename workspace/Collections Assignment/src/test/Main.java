package test;

import main.java.*;

public class Main
{
	public static void main(String[] args)
	{
		testTerm();
		testPolynomial();
	}
	
	public static void testTerm()
	{
		System.out.print("Term test: ");
		Term myterm = new Term(4, 5);
		System.out.println(myterm.toString());
	}
	
	public static void testPolynomial() {
		System.out.println("---------Polynomial test---------");
		String expression;
		Term myTerm = new Term(4, 5);
		Term myTerm2 = new Term(5, 2);
		Term myTerm3 = new Term(9, 1);
		Term myTerm4 = new Term(8, 2);
		Polynomial myPolynomial = new Polynomial();
		myPolynomial.insert(myTerm);
		myPolynomial.insert(myTerm2);
		myPolynomial.insert(myTerm3);
		myPolynomial.insert(myTerm4);
		expression = myPolynomial.getList();
		System.out.println("Expression: " + expression);
		int value = myPolynomial.getTotalValue();
		System.out.println("Value: " + value);
	}
}