import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class WindowPrimo extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Window Prime");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label1 = new JLabel("D'oh",SwingConstants.CENTER);
		label1.setPreferredSize(new Dimension(300,300));
		frame.getContentPane().add(label1,BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
