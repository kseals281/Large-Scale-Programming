package main.java;

import java.util.ArrayList;

public class Polynomial
{
	private ArrayList<Term> polynomialExpression;
	public Polynomial()
	{
		polynomialExpression = new ArrayList<>();
	}
	
	public void insert(Term newTerm)
	{
		if (polynomialExpression.isEmpty()) {
			polynomialExpression.add(0, newTerm);
			return;
		}
		Term current = newTerm;
		for (int i = 0; i < polynomialExpression.size(); i++) {
			if (polynomialExpression.get(i).getExponent() > current.getExponent()) {
				Term temp = polynomialExpression.get(i);
				polynomialExpression.set(i, current);
				current = temp;
			}
		}
		polynomialExpression.add(current);
	}
	
	public String getList()
	{
		String myList = "";
		for (int i = 0; i < polynomialExpression.size(); i++) {
			if (i > 0) {
				myList += " + ";
			}
			myList += polynomialExpression.get(i).toString();
		}
		return myList;
	}
	
	public int getTotalValue()
	{
		int total = 0;
		for (int i = 0; i < polynomialExpression.size(); i++) {
			total += polynomialExpression.get(i).getValue();
		}
		return total;
	}
}