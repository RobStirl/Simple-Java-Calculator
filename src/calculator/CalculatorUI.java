package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorUI {

	public static void main(String[] args) {
		buildUI();
	}
	public static void buildUI() {
		JFrame calculatorFrame = new JFrame();
		calculatorFrame.setTitle("Calculator");

		calculatorFrame.setSize(300, 400);
		calculatorFrame.setResizable(true);
		calculatorFrame.setVisible(true);
		calculatorFrame.setLocationRelativeTo(null);
		calculatorFrame.setLayout(new BoxLayout(calculatorFrame.getContentPane(), BoxLayout.Y_AXIS));

		JTextField textField = new JTextField(10);
		textField.setEditable(false);
		textField.setText("");

		textField.setFont(new Font("Monaco", Font.PLAIN, 40));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		calculatorFrame.add(textField);
		CalculatorActionListener actionListener = new CalculatorActionListener(textField);

		JPanel panel = buildPanel(actionListener);
		calculatorFrame.add(panel);

		calculatorFrame.validate();
		calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static JPanel buildPanel(ActionListener actionListener) {

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4, 3, 3));
		
		panel.setBackground(new Color(192, 192, 192));

		for (int i = 0; i < 10; i++) {
			JButton button = new JButton("" + i);
			button.setActionCommand("" + i);
			button.addActionListener(actionListener);
			panel.add(button);
		}
		JButton fakeButton = new JButton("");
		fakeButton.setEnabled(false);
		panel.add(fakeButton);
		
		JButton clearButton = new JButton("C");
		clearButton.setActionCommand("C");
		clearButton.addActionListener(actionListener);
		panel.add(clearButton);

		JButton addButton = new JButton("+");
		addButton.setActionCommand("+");
		addButton.addActionListener(actionListener);
		panel.add(addButton);

		JButton subtractButton = new JButton("-");
		subtractButton.setActionCommand("-");
		subtractButton.addActionListener(actionListener);
		panel.add(subtractButton);

		JButton mulitplyButton = new JButton("x");
		mulitplyButton.setActionCommand("x");
		mulitplyButton.addActionListener(actionListener);
		panel.add(mulitplyButton);

		JButton divideButton = new JButton("/");
		divideButton.setActionCommand("/");
		divideButton.addActionListener(actionListener);
		panel.add(divideButton);

		JButton modButton = new JButton("%");
		modButton.setActionCommand("%");
		modButton.addActionListener(actionListener);
		panel.add(modButton);

		JButton unaryButton = new JButton("+/-");
		unaryButton.setActionCommand("U");
		unaryButton.addActionListener(actionListener);
		panel.add(unaryButton);
		
		JButton fakeButton1 = new JButton("");
		fakeButton1.setEnabled(false);
		panel.add(fakeButton1);
		
		JButton equalsButton = new JButton("=");
		equalsButton.setActionCommand("=");
		equalsButton.addActionListener(actionListener);
		panel.add(equalsButton);
		return panel;
	}
}
