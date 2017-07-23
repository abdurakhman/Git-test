import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class handler extends JFrame {
	JButton[] bt = new JButton[10];
	JButton plus, minus, multiple, div, comma, equally, c;
	JTextField window;
	int rez = 0;
	String op = "";
	eHandler l = new eHandler();
	int k;
	
	public handler(String s) {
		super(s);
		setLayout(new FlowLayout());
		window = new JTextField(11);
		window.setEditable(false);
		plus = new JButton("+");
		minus = new JButton(" -");
		multiple = new JButton("*");
		div = new JButton(" /");
		comma = new JButton("  ");
		equally = new JButton("=");
		c = new JButton(" C ");
		for (int j = 0; j <= 9; j++)
			bt[j] = new JButton(String.valueOf(j));
		
		add(window);
		add(c);
		add(bt[1]);
		add(bt[2]);
		add(bt[3]);
		add(plus);
		add(bt[4]);
		add(bt[5]);
		add(bt[6]);
		add(minus);
		add(bt[7]);
		add(bt[8]);
		add(bt[9]);
		add(multiple);
		add(bt[0]);
		add(comma);
		add(equally);
		add(div);
		
		plus.addActionListener(l);
		minus.addActionListener(l);
		multiple.addActionListener(l);
		div.addActionListener(l);
		equally.addActionListener(l);
		c.addActionListener(l);
		for (int j = 0; j <= 9; j++)
			bt[j].addActionListener(l);
	}
	public class eHandler implements ActionListener {
		public void mathOperation(ActionEvent e, JButton b, String l) {
			if (e.getSource() == b) {				
				if (!window.getText().isEmpty())
					switch(op) {
					case "" : rez = Integer.parseInt(window.getText());
					break;
					case "plus" : rez += Integer.parseInt(window.getText());
					break;
					case "minus" : rez -= Integer.parseInt(window.getText());
					break;
					case "multiple" : rez *= Integer.parseInt(window.getText());
					break;
					case "div" : rez /= Integer.parseInt(window.getText());
					break;
					}
				window.setText(null);
				op = l;
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			try {
				for (int j = 0; j <= 9; j++)
					if (e.getSource() == bt[j])
						window.setText(window.getText() + String.valueOf(j));
				
				if (e.getSource() == c && !window.getText().isEmpty())
					window.setText(window.getText().substring(0, window.getText().length() - 1));
				
				mathOperation(e, plus, "plus");
				mathOperation(e, minus, "minus");
				mathOperation(e, multiple, "multiple");
				mathOperation(e, div, "div");
				if (e.getSource() == equally) {
					if (window.getText().isEmpty())
						window.setText(String.valueOf(rez));
					else
						switch(op) {
						case "" : while (window.getText().charAt(0) == '0' && window.getText().length() > 1) 
							window.setText(window.getText().substring(1, window.getText().length()));
						break;
						case "plus" : window.setText(String.valueOf(rez + Integer.parseInt(window.getText())));
						break;
						case "minus" : window.setText(String.valueOf(rez - Integer.parseInt(window.getText())));
						break;
						case "multiple" : window.setText(String.valueOf(rez * Integer.parseInt(window.getText())));
						break;
						case "div" : window.setText(String.valueOf(rez / Integer.parseInt(window.getText())));
						break;
						}
					op = "";
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "¬ведите в поле число (возможно превышен лимит int)");
			}
		}	
	}
}