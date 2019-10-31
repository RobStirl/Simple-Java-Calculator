package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CalculatorActionListener implements ActionListener{

	int a, b;
	boolean lastFilled;
	char operator;

	private JTextField textField;

	public CalculatorActionListener(JTextField textField){
		this.textField = textField;
		this.textField.setText("0");
		a = 0;
		b = 0;
		lastFilled = false;
		operator = ' ';
	}
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("ActionEvent: " + e.getActionCommand());
		
		switch (e.getActionCommand())
		{
		case "C": 
			a = 0;
			b = 0;
			operator = ' ';
			textField.setText("0");
			lastFilled = false;
			return; // Finished, do not displayEquation()
		case "=": 
			
			if(!lastFilled) // The full equation has not been enter, ignore this event
				return; // Finished, do not displayEquation()
			displayAnswer();
			b = 0;
			operator = ' ';
			lastFilled = false;
			return; // Finished, do not displayEquation()

		case "x":
			operator = 'x';
			break;
		case "/":
			operator = '/';
			break;
		case "-":
			operator = '-';
			break;
		case "+":
			operator = '+';
			break;
		case "%":
			operator = '%';
			break;
		case "U":
			if(!lastFilled)
				a = -a;
			else
				b = -b;
			break;
		default:
			
			// Nothing in a
			if(a == 0 && operator == ' ')
				a = Integer.parseInt(e.getActionCommand());
			// Something in a and operator not set
			else if(operator == ' ')
			{
				a *= 10;
				a += Integer.parseInt(e.getActionCommand());
				
			}
			// Operator set and nothing in b
			else if(b == 0)
			{
				b = Integer.parseInt(e.getActionCommand());
				lastFilled = true;
			}
			// Something in b
			else
			{
				b *= 10;
				b += Integer.parseInt(e.getActionCommand());
			}
			break;
		}
		displayEquation();
	}
	
	
	private void displayEquation()
	{
		if(operator == ' ')
			textField.setText("" + a);
		else if(!lastFilled)
			textField.setText("" + a + " " + operator);
		else
			textField.setText("" + a + " " + operator + " " + b);
	}
	
	
	private void displayAnswer()
	{
		System.out.println("Display Answer");
		int answer = 0;

		switch(operator)
		{
		case 'x':
			answer = a * b;
			break;
		case '/':
			if(b == 0)
			{
				// Cannot divide by 0
				textField.setText("Err: Div 0");
				a = 0;
				return;
			}
			answer = a / b;
			
			break;
		case '-':
			answer = a - b;
			break;
		case '+':
			answer = a + b;
			break;
		case '%':
			if(b == 0)
			{
				// Modding by 0 is undefined
				textField.setText("Err: Mod 0");
				a = 0;
				return;
			}
			answer = a % b;
			break;
		}
		
		// Display Answer
		textField.setText("" + answer);
		
		a = answer; // Set a as the answer, allowing user to chain equations together 
	}
	

}