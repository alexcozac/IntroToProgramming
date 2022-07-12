package SciCalculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {

	public static void main(String[] args) {

		try {
			CalculatorGUI Calculator = new CalculatorGUI();
			Calculator.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static JPanel contentPane;
	Color blue = new Color(135, 206, 250);
	Color grey = new Color(169, 169, 169);
	static JTextField displayResult;
	static JTextField displayFormula;
	calcController controller = new calcController();

	public CalculatorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn0 = new JButton("0");
		btn0.setBackground(blue);
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn0.setBounds(166, 292, 50, 50);
		btn0.addActionListener(controller);
		contentPane.add(btn0);
			
		JButton btnDot = new JButton(".");
		btnDot.setBackground(blue);
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDot.setBounds(216, 292, 50, 50);
		btnDot.addActionListener(controller);
		contentPane.add(btnDot);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setBackground(blue);
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEqual.setBounds(266, 292, 50, 50);
		btnEqual.addActionListener(controller);
		contentPane.add(btnEqual);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setBackground(grey);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdd.setBounds(316, 292, 50, 50);
		btnAdd.addActionListener(controller);
		contentPane.add(btnAdd);
		
		JButton btn1 = new JButton("1");
		btn1.setBackground(blue);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn1.setBounds(166, 242, 50, 50);
		btn1.addActionListener(controller);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBackground(blue);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn2.setBounds(216, 242, 50, 50);
		btn2.addActionListener(controller);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBackground(blue);
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn3.setBounds(266, 242, 50, 50);
		btn3.addActionListener(controller);
		contentPane.add(btn3);
		
		JButton btnSubtract = new JButton("-");
		btnSubtract.setBackground(grey);
		btnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSubtract.setBounds(316, 242, 50, 50);
		btnSubtract.addActionListener(controller);
		contentPane.add(btnSubtract);
		
		JButton btn4 = new JButton("4");
		btn4.setBackground(blue);
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn4.setBounds(166, 192, 50, 50);
		btn4.addActionListener(controller);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBackground(blue);
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn5.setBounds(216, 192, 50, 50);
		btn5.addActionListener(controller);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBackground(blue);
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn6.setBounds(266, 192, 50, 50);
		btn6.addActionListener(controller);
		contentPane.add(btn6);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.setBackground(grey);
		btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMultiply.setBounds(316, 192, 50, 50);
		btnMultiply.addActionListener(controller);
		contentPane.add(btnMultiply);
		
		JButton btn7 = new JButton("7");
		btn7.setBackground(blue);
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn7.setBounds(166, 142, 50, 50);
		btn7.addActionListener(controller);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBackground(blue);
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn8.setBounds(216, 142, 50, 50);
		btn8.addActionListener(controller);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBackground(blue);
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn9.setBounds(266, 142, 50, 50);
		btn9.addActionListener(controller);
		contentPane.add(btn9);
		
		JButton btnDivide = new JButton("/");
		btnDivide.setBackground(grey);
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDivide.setBounds(316, 142, 50, 50);
		btnDivide.addActionListener(controller);
		contentPane.add(btnDivide);
		
		JButton btnOpenBracket = new JButton("(");
		btnOpenBracket.setBackground(grey);
		btnOpenBracket.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOpenBracket.setBounds(166, 92, 50, 50);
		btnOpenBracket.addActionListener(controller);
		contentPane.add(btnOpenBracket);
		
		JButton btnCloseBracket = new JButton(")");
		btnCloseBracket.setBackground(grey);
		btnCloseBracket.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCloseBracket.setBounds(216, 92, 50, 50);
		btnCloseBracket.addActionListener(controller);
		contentPane.add(btnCloseBracket);
		
		JButton btnModulo = new JButton("%");
		btnModulo.setBackground(grey);
		btnModulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModulo.setBounds(266, 92, 50, 50);
		btnModulo.addActionListener(controller);
		contentPane.add(btnModulo);
		
		JButton btnClear = new JButton("C");
		btnClear.setBackground(grey);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClear.setBounds(316, 92, 50, 50);
		btnClear.addActionListener(controller);
		contentPane.add(btnClear);
		
		JButton btnPowOf = new JButton("x\u02b8");
		btnPowOf.setBackground(grey);
		btnPowOf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPowOf.setBounds(116, 292, 50, 50);
		btnPowOf.addActionListener(controller);
		contentPane.add(btnPowOf);
		
		JButton btnSquared = new JButton("x\u00b2");
		btnSquared.setBackground(grey);
		btnSquared.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSquared.setBounds(116, 242, 50, 50);
		btnSquared.addActionListener(controller);
		contentPane.add(btnSquared);
		
		JButton btnSqrt = new JButton("\u221a");
		btnSqrt.setBackground(grey);
		btnSqrt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSqrt.setBounds(116, 192, 50, 50);
		btnSqrt.addActionListener(controller);
		contentPane.add(btnSqrt);
		
		JButton btnQbrt = new JButton("\u221b");
		btnQbrt.setBackground(grey);
		btnQbrt.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnQbrt.setBounds(116, 142, 50, 50);
		btnQbrt.addActionListener(controller);
		contentPane.add(btnQbrt);
		
		JButton btnFactorial = new JButton("x!");
		btnFactorial.setBackground(grey);
		btnFactorial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFactorial.setBounds(116, 92, 50, 50);
		btnFactorial.addActionListener(controller);
		contentPane.add(btnFactorial);
		
		JButton btnLog = new JButton("log");
		btnLog.setBackground(grey);
		btnLog.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLog.setBounds(66, 292, 50, 50);
		btnLog.addActionListener(controller);
		contentPane.add(btnLog);
		
		JButton btnTan = new JButton("tan");
		btnTan.setBackground(grey);
		btnTan.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTan.setBounds(66, 242, 50, 50);
		btnTan.addActionListener(controller);
		contentPane.add(btnTan);
		
		JButton btnCos = new JButton("cos");
		btnCos.setBackground(grey);
		btnCos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCos.setBounds(66, 192, 50, 50);
		btnCos.addActionListener(controller);
		contentPane.add(btnCos);
		
		JButton btnSin = new JButton("sin");
		btnSin.setBackground(grey);
		btnSin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSin.setBounds(66, 142, 50, 50);
		btnSin.addActionListener(controller);
		contentPane.add(btnSin);
		
		JButton btnPi = new JButton("\u03c0");
		btnPi.setBackground(grey);
		btnPi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPi.setBounds(66, 92, 50, 50);
		btnPi.addActionListener(controller);
		contentPane.add(btnPi);
		
		JButton btnMemoryClear = new JButton("MC");
		btnMemoryClear.setBackground(grey);
		btnMemoryClear.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMemoryClear.setBounds(16, 292, 50, 50);
		btnMemoryClear.addActionListener(controller);
		contentPane.add(btnMemoryClear);
		
		JButton btnMemorySub = new JButton("M-");
		btnMemorySub.setBackground(grey);
		btnMemorySub.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMemorySub.setBounds(16, 242, 50, 50);
		btnMemorySub.addActionListener(controller);
		contentPane.add(btnMemorySub);
		
		JButton btnMemoryAdd = new JButton("M+");
		btnMemoryAdd.setBackground(grey);
		btnMemoryAdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMemoryAdd.setBounds(16, 192, 50, 50);
		btnMemoryAdd.addActionListener(controller);
		contentPane.add(btnMemoryAdd);
		
		JButton btnMemoryRetrieve = new JButton("MR");
		btnMemoryRetrieve.setBackground(grey);
		btnMemoryRetrieve.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMemoryRetrieve.setBounds(16, 142, 50, 50);
		btnMemoryRetrieve.addActionListener(controller);
		contentPane.add(btnMemoryRetrieve);
		
		JButton btnBackSpace = new JButton("\u2190");
		btnBackSpace.setBackground(grey);
		btnBackSpace.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBackSpace.setBounds(16, 92, 50, 50);
		btnBackSpace.addActionListener(controller);
		contentPane.add(btnBackSpace);
			
		displayResult = new JTextField();
		displayResult.setBounds(16, 48, 350, 35);
		displayResult.setText("");
		displayResult.setEditable(false);
		contentPane.add(displayResult);
		
		displayFormula = new JTextField();
		displayFormula.setBounds(16, 10, 350, 35);
		displayFormula.setText("");
		contentPane.add(displayFormula);
		
	}		
}
