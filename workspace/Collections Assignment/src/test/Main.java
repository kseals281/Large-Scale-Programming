package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import main.java.*;

public class Main
{
	/**Main driver class for the program
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader input = new BufferedReader(new FileReader("src/main/resources/input.txt"));
		int base, exp;
		while(input.ready())
		{
			BufferedReader operations = new BufferedReader(new FileReader("src/main/resources/operations.txt"));
			String[] line = input.readLine().split(";");
			Polynomial myPolynomial = new Polynomial();
			String name = line[0];
			for(int i = 1; i < line.length; i += 2)
			{
				base = Integer.parseInt(line[i]);
				exp = Integer.parseInt(line[i + 1]);
				Term myTerm = new Term(base, exp);
				myPolynomial.insert(myTerm);
			}
			System.out.println("---------------Polynomial " + name + "---------------");
			while(operations.ready())
			{
				String read = operations.readLine();
				System.out.println(read);
				line = read.split(" ");
				if(line[0].equals("INSERT"))
				{
					Term newTerm = new Term(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
					myPolynomial.insert(newTerm);
				}
				if(line[0].equals("DELETE"))
				{
					Term termToDelete = new Term(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
					myPolynomial.deleteTerm(termToDelete);
				}
				if(line[0].equals("REVERSE"))
				{
					myPolynomial.reverse();
				}
				if(line[0].equals("PRODUCT"))
				{
					System.out.println(myPolynomial.getList());
				}
				System.out.println("");
			}
			operations.close();
			System.out.println("");
		}
		input.close();
//		testTerm();
//		testPolynomial();
	}
	
//	public static void testTerm()
//	{
//		System.out.print("Term test: ");
//		Term myterm = new Term(4, 5);
//		System.out.println(myterm.toString());
//	}
//	
//	public static void testPolynomial() {
//		System.out.println("---------Polynomial test---------");
//		
//		String expression;
//		Term myTerm = new Term(4, 5);
//		Term myTerm2 = new Term(-5, 2);
//		Term myTerm3 = new Term(9, 1);
//		Term myTerm4 = new Term(8, 2);
//		Term myTerm5 = new Term(-5, 2);
//		Polynomial myPolynomial = new Polynomial();
//		myPolynomial.insert(myTerm);
//		myPolynomial.insert(myTerm2);
//		myPolynomial.insert(myTerm3);
//		myPolynomial.insert(myTerm4);
//		
//		expression = myPolynomial.getList();
//		System.out.println("Expression: " + expression);
//		
//		int value = myPolynomial.getTotalValue();
//		System.out.println("Value: " + value);
//		
//		myPolynomial.deleteTerm(myTerm5);
//		expression = myPolynomial.getList();
//		System.out.println("List after deleting a term: " + expression);
//		
//		myPolynomial.reverse();
//		expression = myPolynomial.getList();
//		System.out.println("List after reversing: " + expression);
//	}
}