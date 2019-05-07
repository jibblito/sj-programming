import javax.swing.*;
import java.awt.Graphics;

public class WindowPrimo extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Window Prime");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
