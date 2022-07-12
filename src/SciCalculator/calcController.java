package SciCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class calcController implements ActionListener {

	String formula = "";
	boolean operatorPressed = false;
	final String pi = "3.14";
	Memory memory = new Memory();
	String memoryFormula = "0";

	Evaluator Calculator = new Evaluator();

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String bName = button.getText();

		switch (bName) {

		case "0":
			formula += "0";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "1":
			formula += "1";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "2":
			formula += "2";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "3":
			formula += "3";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "4":
			formula += "4";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "5":
			formula += "5";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "6":
			formula += "6";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "7":
			formula += "7";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "8":
			formula += "8";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "9":
			formula += "9";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case ".":
			formula += ".";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = true;
			break;

		case "+":
			if (!operatorPressed) {
				formula += "+";
				CalculatorGUI.displayFormula.setText(formula);
				operatorPressed = true;
			}
			break;

		case "-":
			if (!operatorPressed) {
				formula += "-";
				CalculatorGUI.displayFormula.setText(formula);
				operatorPressed = true;
			}
			break;

		case "*":
			if (!operatorPressed) {
				formula += "*";
				CalculatorGUI.displayFormula.setText(formula);
				operatorPressed = true;
			}
			break;

		case "/":
			if (!operatorPressed) {
				formula += "/";
				CalculatorGUI.displayFormula.setText(formula);
				operatorPressed = true;
			}
			break;

		case "%":
			if (!operatorPressed) {
				formula += "%";
				CalculatorGUI.displayFormula.setText(formula);
				operatorPressed = true;
			}
			break;

		case "(":
			formula += "(";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case ")":
			formula += ")";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		// Power Of Y
		case "x\u02b8":
			formula += "POW";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		// Squared
		case "x\u00b2":
			formula += "SQRD";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;

			break;

		// Square Root
		case "\u221a":
			formula += "SQRT";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;

			break;

		// Cube Root
		case "\u221b":
			formula += "CBRT";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;

			break;

		case "x!":
			formula += "!";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;

			break;

		case "log":
			formula += "LOG";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;

			break;

		case "tan":
			formula += "TAN";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;

			break;

		case "cos":
			formula += "COS";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "sin":
			formula += "SIN";
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		// Pi
		case "\u03c0":
			formula += pi;
			CalculatorGUI.displayFormula.setText(formula);
			operatorPressed = false;
			break;

		case "MR":
			memoryFormula = memory.getStoredFormula();
			CalculatorGUI.displayResult.setText(Calculator.eval(memoryFormula).toString());

			break;

		case "M+":
			memoryFormula += "+" + CalculatorGUI.displayResult.getText();
			memory.saveToFile(memoryFormula);

			break;

		case "M-":
			memoryFormula += "-" + CalculatorGUI.displayResult.getText();
			memory.saveToFile(memoryFormula);
			break;

		case "MC":
			memoryFormula = "0";
			memory.saveToFile(memoryFormula);
			break;

		// BackSpace
		case "\u2190":
			formula = CalculatorGUI.displayFormula.getText();
			char[] tempString = formula.toCharArray();
			formula = "";
			for (int i = 0; i < tempString.length - 1; i++) {
				formula += tempString[i];
			}
			CalculatorGUI.displayFormula.setText(formula);
			break;

		case "C":
			formula = "";
			CalculatorGUI.displayFormula.setText(formula);
			CalculatorGUI.displayResult.setText(formula);
			break;

		case "=":
			CalculatorGUI.displayResult.setText(Calculator.eval(CalculatorGUI.displayFormula.getText()).toString());
			break;

		}

	}

}
