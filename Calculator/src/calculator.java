import javax.swing.JFrame;

public class calculator {
	public static void main(String args[]) {
		handler h = new handler("Недо-Калькулятор");
		h.setVisible(true);
		h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		h.setSize(210, 195);
		h.setLocationRelativeTo(null);
		h.setResizable(false);
	}
}
