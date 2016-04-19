package main.java;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial
{
	private ArrayList<Term> polynomialExpression;
	public Polynomial()
	{
		polynomialExpression = new ArrayList<>();
	}
	
	/**Inserts new terms into the polynomial in the correct spot
	 * @param newTerm Must be a term object
	 */
	public void insert(Term newTerm)
	{
		if (polynomialExpression.isEmpty()) {
			polynomialExpression.add(0, newTerm);
			return;
		}
		Term current = newTerm;
		for (int i = 0; i < polynomialExpression.size(); i++) {
			if (polynomialExpression.get(i).getExponent() > current.getExponent()) {
				Term temp = polynomialExpression.set(i, current);
				current = temp;
			}
		}
		polynomialExpression.add(current);
	}
	
	/**Concatenates the entire arraylist into a string and returns it
	 * @return
	 */
	public String getList()
	{
		String myList = "";
		for (int i = 0; i < polynomialExpression.size(); i++) {
			if (i > 0 && polynomialExpression.get(i).getCoefficient() >= 0) {
				myList += " + ";
			}
			else if (i > 0)
			{
				myList += " ";
			}
			myList += polynomialExpression.get(i).toString();
		}
		return myList;
	}
	
	/**Calculates the value of the expression
	 * @return
	 */
	public int getTotalValue()
	{
		int total = 0;
		for (int i = 0; i < polynomialExpression.size(); i++) {
			total += polynomialExpression.get(i).getValue();
		}
		return total;
	}
	
	/**Deletes a term from the array list by removing it and then removing the space from the list
	 * @param termToDelete
	 */
	public void deleteTerm(Term termToDelete)
	{
		boolean removed = polynomialExpression.remove(termToDelete);
		if (!removed) {
			System.out.println("Term given was not in the polynomial and was therefore not removed");
		}
		polynomialExpression.removeAll(Collections.singleton(null));
	}
	
	/**Reverses the list by swapping each element. Only runs for half the length of the list
	 * 
	 */
	public void reverse()
	{
		for (int i = 0; i < polynomialExpression.size() / 2; i++) {
			Term temp = polynomialExpression.set(i, polynomialExpression.get(polynomialExpression.size() - 1 - i));
			polynomialExpression.set(polynomialExpression.size() - 1 - i, temp);
		}
	}
}