import java.awt.Dimension;

import javax.swing.JFrame;

public class Initialize {

	public final static Dimension SIZE = new Dimension(1000, 1000); // Size of window

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Set up main window (using Swing's Jframe)
				JFrame frame = new JFrame("Connect 4");
				Play n = new Play();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(n);
				frame.setResizable(false);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
