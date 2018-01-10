import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Play extends JPanel implements KeyListener {

	private static int width = Initialize.SIZE.width;
	private static int height = Initialize.SIZE.height;

	private static Board b = new Board(width, height);

	private static Puck p = new Puck(Color.RED, b);

	public Play() {
		setMinimumSize(Initialize.SIZE);
		setMaximumSize(Initialize.SIZE);
		setPreferredSize(Initialize.SIZE);
		addKeyListener(this);
//		Thread gameThread = new Thread() {
//			public void run() {
//				while (true) {
//					repaint();
//					if (b.checkGameOver()) {
//						break;
//					}
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		gameThread.start();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.width, this.height);
		b.paint(g);
		p.locationUpdate();
		p.paint(g);
		if (b.gameOver) {
			b.paintWinner(g);;
		}
	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if (!b.checkGameOver()) {
			p.move(k);
			b.checkGameOver();
			repaint();
		}
		if (k == 10) {
			b.reset();
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}