package SciCalculator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Evaluator {

	/**
	 * Uses parser to separate the elements within the input string
	 * 
	 * @see #calcParsedInput(List)
	 * @see #parser(String)
	 * @param String input containing the full mathematical expression
	 * @return Double containing the result
	 */
	public Double eval(String input) {
		return calcParsedInput(parser(input));
	}

	/**
	 * Loops through each index within the input string and adds the complete
	 * numbers and operators to the list to be returned.
	 * 
	 * @see #isPartOfNum(char)
	 * @see #isPartOfOrder(char)
	 * @param input String with full Mathematical Expression
	 * @return List containing all of the numbers and operators
	 */
	private List<Object> parser(String input) {

		List<Object> list = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			char token = input.charAt(i);

			// Forming Numbers out of digits
			if (isPartOfNum(token)) {
				String number = "";
				for (; i < input.length(); i++) {
					token = input.charAt(i);
					if (!isPartOfNum(token))
						break;
					number += token;
				}
				// Add Number to list
				list.add(Double.parseDouble(number));

				// Stop outer loop if i reached the end of the expression
				if (i == input.length())
					break;
			}

			// Forming Orders
			if (isPartOfOrder(token)) {
				String order = "";
				for (; i < input.length(); i++) {
					token = input.charAt(i);
					if (!isPartOfOrder(token))
						break;
					order += token;
				}
				// Add Order to list
				list.add(order);
				i--;
				if (i == input.length()) {
					break;
				}
			}

			// Add Math operators
			switch (token) {

			case '(':
				list.add(token);
				break;
			case ')':
				list.add(token);
				break;
			case '/':
				list.add(token);
				break;
			case '*':
				list.add(token);
				break;
			case '%':
				list.add(token);
				break;
			case '+':
				list.add(token);
				break;
			case '-':
				list.add(token);
				break;
			}
		}
		return list;
	}

	/**
	 * Calculates the parsed input with BODMAS order given by the order of methods
	 * calling.
	 * 
	 * @see #huntBrackets(List)
	 * @see #huntOrder(List)
	 * @see #huntOperator(List, char)
	 * @param list
	 * @return double - result of calculation
	 * @throws IllegalArgumentException if after all of the calculation the result
	 *                                  list does not contain only one element
	 */
	private double calcParsedInput(List<Object> list) {

		if (list.size() == 1) {
			return (double) list.get(0);
		}
		// BODMAS is only present within the order of calling brackets and operators methods
		huntBrackets(list);
		huntOrder(list);
		huntOperator(list, '%', '%');
		huntOperator(list, '*', '/');
		huntOperator(list, '+', '-');

		Object resultToken = list.get(0);
		if (list.size() != 1) {
			JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Something ain't right!", "WARNING.",
					JOptionPane.WARNING_MESSAGE);
			throw new IllegalArgumentException("Something ain't right!");
		}
		return Double.parseDouble(resultToken.toString());
	}

	/**
	 * Looks for a bracket opening to start calculating what is inside it.
	 * 
	 * @see #calcInBrackets(List, int)
	 * @param list
	 * @throws IllegalArgumentException if only closing bracket is detected
	 */
	private void huntBrackets(List<Object> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).toString().charAt(0) == ')') {
				JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Only closing bracket detected", "WARNING.",
						JOptionPane.WARNING_MESSAGE);
				throw new IllegalArgumentException("Only closing bracket detected");
			}
			if (list.get(i).toString().charAt(0) == '(') {
				calcInBrackets(list, i);
			}
		}
	}

	/**
	 * Removes the bracket opening found in huntBrackets() and checks if the
	 * brackets openings and closings are balanced. During the checks it adds the
	 * elements within the bracket in a temporary list and removes them from the
	 * original list. The closing bracket will become the result of the calculation.
	 * 
	 * @see #calcParsedInput(List)
	 * 
	 * @param list - original list
	 * @param i    - starting index inside the bracket
	 * @throws IllegalArgumentException if there is no elements between the brackets
	 *                                  or the bracket is not closed
	 */
	private void calcInBrackets(List<Object> list, int i) {
		// Object used is deleted from the list
		list.remove(i);

		int openedBrakets = 1;
		List<Object> tempList = new ArrayList<>();
		for (; i < list.size();) {
			Object token = list.get(i);
			if (token.toString().charAt(0) == '(')
				openedBrakets++;

			if (token.toString().charAt(0) == ')')
				openedBrakets--;

			if (openedBrakets == 0)
				break;

			tempList.add(token);
			list.remove(i);
		}

		if (tempList.size() == 0) {
			JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Empty Brackets Detected", "WARNING.",
					JOptionPane.WARNING_MESSAGE);
			throw new IllegalArgumentException("Empty Brackets Detected");
		} else if (openedBrakets != 0) {
			JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Brackets were not closed", "WARNING.",
					JOptionPane.WARNING_MESSAGE);
			throw new IllegalArgumentException("Brackets were not closed");
		} else {
			// Set result to the index of the closing bracket
			list.set(i, calcParsedInput(tempList));
		}

	}

	/**
	 * Looks for the given parameter inside the expression, performing the
	 * calculation, replacing all of the elements involved with the result.
	 * 
	 * @param list
	 * @param operator
	 * @throws IllegarArgumentException if an operator is misplaced
	 */
	private void huntOperator(List<Object> list, char op1, char op2) {
		for (int i = 0; i < list.size(); i++) {
			Object token = list.get(i);
			// Keeps order of operation from left to right with operators of the same order
			if (token.toString().charAt(0) == op1 || token.toString().charAt(0) == op2) {
				char firstMet = token.toString().charAt(0);
				if (i == 0 || i == list.size() - 1) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Operator needs to be between numbers", "WARNING.",
							JOptionPane.WARNING_MESSAGE);
					throw new IllegalArgumentException(op1 + " sign should be" + " between numbers");
				}
				Object prevToken = list.get(i - 1);
				Object nextToken = list.get(i + 1);
				double result = 0;
				double a = Double.parseDouble(prevToken.toString());
				double b = Double.parseDouble(nextToken.toString());

				switch (firstMet) {
				case '*':
					result = a * b;
					break;

				case '%':
					result = a % b;
					break;

				case '/':
					result = a / b;
					break;

				case '+':
					result = a + b;
					break;

				case '-':
					result = a - b;
					break;
				}
				// Set first index as result, then remove operator and second number;
				list.set(i - 1, result);
				list.remove(i);
				list.remove(i);
				i--;
			}
		}
	}

	/**
	 * Looks for all of the orders(functions) present within the given expresion,
	 * after it performs the calculation will replace all used elements with the
	 * result of the calulation.
	 * 
	 * @param list
	 * @throws IllegalArgumentException if the operators are misplaced
	 */
	private void huntOrder(List<Object> list) {
		for (int i = 0; i < list.size(); i++) {
			Object token = list.get(i);
			// Orders with Number Before them
			if (token.toString().equalsIgnoreCase("SQRD")) {
				if (i == 0) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Squared sign should be after number", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Squared sign should be after number");
				}
				Object prevToken = list.get(i - 1);
				list.set(i - 1, Math.pow((double) prevToken, 2));
				list.remove(i);
			}

			if (token.toString().equals("!")) {
				if (i == 0) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Squared sign should be after number", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Squared sign should be after number");
				}
				Object prevToken = list.get(i - 1);
				list.set(i - 1, factorial((double) prevToken));
				list.remove(i);
			}

			// Orders with Number After them
			if (token.toString().equalsIgnoreCase("SQRT")) {
				if (i == list.size() - 1) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Square root sign should be before number", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Square root sign should be before number");
				}
				Object nextToken = list.get(i + 1);
				list.set(i, Math.sqrt((double) nextToken));
				list.remove(i + 1);
			}

			if (token.toString().equalsIgnoreCase("CBRT")) {
				if (i == list.size() - 1) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Cube root sign should be before number", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Cube root sign should be before number");
				}
				Object nextToken = list.get(i + 1);
				list.set(i, Math.cbrt((double) nextToken));
				list.remove(i + 1);
			}

			if (token.toString().equalsIgnoreCase("SIN")) {
				if (i == list.size() - 1) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Sin sign should be before number", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Sin sign should be before number");
				}
				Object nextToken = list.get(i + 1);
				list.set(i, Math.sin((double) nextToken));
				list.remove(i + 1);
			}

			if (token.toString().equalsIgnoreCase("COS")) {
				if (i == list.size() - 1) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Cos sign should be before number", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Cos sign should be before number");
				}
				Object nextToken = list.get(i + 1);
				list.set(i, Math.cos((double) nextToken));
				list.remove(i + 1);
			}

			if (token.toString().equalsIgnoreCase("TAN")) {
				if (i == list.size() - 1) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Tan sign should be before number", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Tan sign should be before number");
				}
				Object nextToken = list.get(i + 1);
				list.set(i, Math.tan((double) nextToken));
				list.remove(i + 1);
			}

			if (token.toString().equalsIgnoreCase("LOG")) {
				if (i == list.size() - 1) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Log sign should be before number", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Log sign should be before number");
				}
				Object nextToken = list.get(i + 1);
				list.set(i, Math.log10((double) nextToken));
				list.remove(i + 1);
			}

			// Orders with Numbers Before and After them
			if (token.toString().equalsIgnoreCase("POW")) {
				if (i == 0 || i == list.size() - 1) {
					JOptionPane.showMessageDialog(CalculatorGUI.contentPane, "Power sign of needs to be between numbers", "WARNING.",
							JOptionPane.WARNING_MESSAGE);					
					throw new IllegalArgumentException("Power sign of needs to be between numbers");
				}
				Object prevToken = list.get(i - 1);
				Object nextToken = list.get(i + 1);
				list.set(i - 1, Math.pow((double) prevToken, (double) nextToken));
				list.remove(i);
				list.remove(i);
			}

		}

	}

	/**
	 * Checks if the parameter is a digit or not, as well as '.' which is part of
	 * Double numbers.
	 * 
	 * @param c - character to be checked
	 * @return True if c is a digit or '.'
	 */
	private boolean isPartOfNum(char c) {
		return Character.isDigit(c) || c == '.';
	}

	/**
	 * Checks if the parameter given is part of the order characters.
	 * 
	 * @param c - character to be checked
	 * @return True if the character is a letter or '!'
	 */
	private boolean isPartOfOrder(char c) {
		if (c >= 'A' && c <= 'Z' || c == '!')
			return true;
		return false;
	}

	/**
	 * Performs the factorial of the number given Limit is long variable capability
	 * 
	 * @param x
	 * @return long - result of x!
	 */
	private long factorial(double x) {
		long result = 1;
		for (; x > 0; x--) {
			result = (long) (result * x);
		}
		return result;
	}

}
