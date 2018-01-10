import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Board {

	public int width;
	public int height;

	public int xStart = 65;
	public int yStart = 110;

	private Puck[][] pucks = new Puck[7][6];

	public boolean gameOver = false;
	private String winner = null;

	public Puck[][] getPucks() {
		return pucks;
	}

	public void setPucks(Puck[][] pucks) {
		this.pucks = pucks;
	}

	public Board(int width, int height) {
		this.width = width - (2 * xStart);
		this.height = height - (2 * yStart);
	}

	public void paint(Graphics g) {
		g.setColor(new Color(255, 206, 0));
		g.fillRect(50, 90, width, height);
		g.setColor(Color.DARK_GRAY);
		int x = 65;
		int y = 110;
		for (int j = 0; j < 6; j++) {
			for (int k = 0; k < 7; k++) {
				g.fillOval(x, y, 100, 100);
				x += this.width / 7;
			}
			y += this.height / 6;
			x = this.xStart;
		}
		for (int j = 0; j < 7; j++) {
			for (int k = 0; k < 6; k++) {
				if (pucks[j][k] != null) {
					Puck p = pucks[j][k];
					p.paint(g);
				}
			}
		}
	}

	public boolean checkGameOver() {
		if (!gameOver) {
			if (this.pucks[0][0] == null || this.pucks[1][0] == null || this.pucks[2][0] == null
					|| this.pucks[3][0] == null || this.pucks[4][0] == null || this.pucks[5][0] == null
					|| this.pucks[6][0] == null) {
				gameOver = false;
			} else {
				gameOver = true;
			}
			if (gameOver) {
				return gameOver;
			} else {
				for (int j = 0; j < 7; j++) {
					for (int k = 0; k < 6; k++) {
						try {
							if (pucks[j][k] != null && pucks[j + 1][k] != null && pucks[j + 2][k] != null
									&& pucks[j + 3][k] != null) {

								if (pucks[j][k].c.equals(Color.RED) && pucks[j + 1][k].c.equals(Color.RED)
										&& pucks[j + 2][k].c.equals(Color.RED) && pucks[j + 3][k].c.equals(Color.RED)) {
									System.out.println("Red Wins");
									gameOver = true;
									winner = "Red";

								} else if (pucks[j][k].c.equals(Color.YELLOW) && pucks[j + 1][k].c.equals(Color.YELLOW)
										&& pucks[j + 2][k].c.equals(Color.YELLOW)
										&& pucks[j + 3][k].c.equals(Color.YELLOW)) {
									System.out.println("Yellow Wins");
									gameOver = true;
									winner = "Yellow";
								}
							}
						} catch (ArrayIndexOutOfBoundsException e) {

						}
						try {
							if (pucks[j][k] != null && pucks[j][k + 1] != null && pucks[j][k + 2] != null
									&& pucks[j][k + 3] != null) {

								if (pucks[j][k].c.equals(Color.RED) && pucks[j][k + 1].c.equals(Color.RED)
										&& pucks[j][k + 2].c.equals(Color.RED) && pucks[j][k + 3].c.equals(Color.RED)) {
									System.out.println("Red Wins");
									gameOver = true;
									winner = "Red";

								} else if (pucks[j][k].c.equals(Color.YELLOW) && pucks[j][k + 1].c.equals(Color.YELLOW)
										&& pucks[j][k + 2].c.equals(Color.YELLOW)
										&& pucks[j][k + 3].c.equals(Color.YELLOW)) {
									System.out.println("Yellow Wins");
									gameOver = true;
									winner = "Yellow";
								}
							}
						} catch (ArrayIndexOutOfBoundsException e) {

						}
						try {
							if (pucks[j][k] != null && pucks[j + 1][k + 1] != null && pucks[j + 2][k + 2] != null
									&& pucks[j + 3][k + 3] != null) {

								if (pucks[j][k].c.equals(Color.RED) && pucks[j + 1][k + 1].c.equals(Color.RED)
										&& pucks[j + 2][k + 2].c.equals(Color.RED)
										&& pucks[j + 3][k + 3].c.equals(Color.RED)) {
									System.out.println("Red Wins");
									gameOver = true;
									winner = "Red";

								} else if (pucks[j][k].c.equals(Color.YELLOW)
										&& pucks[j + 1][k + 1].c.equals(Color.YELLOW)
										&& pucks[j + 2][k + 2].c.equals(Color.YELLOW)
										&& pucks[j + 3][k + 3].c.equals(Color.YELLOW)) {
									System.out.println("Yellow Wins");
									gameOver = true;
									winner = "Yellow";
								}
							}
						} catch (ArrayIndexOutOfBoundsException e) {

						}
						try {
							if (pucks[j][k] != null && pucks[j - 1][k + 1] != null && pucks[j - 2][k + 2] != null
									&& pucks[j - 3][k + 3] != null) {

								if (pucks[j][k].c.equals(Color.RED) && pucks[j - 1][k + 1].c.equals(Color.RED)
										&& pucks[j - 2][k + 2].c.equals(Color.RED)
										&& pucks[j - 3][k + 3].c.equals(Color.RED)) {
									System.out.println("Red Wins");
									gameOver = true;
									winner = "Red";

								} else if (pucks[j][k].c.equals(Color.YELLOW)
										&& pucks[j - 1][k + 1].c.equals(Color.YELLOW)
										&& pucks[j - 2][k + 2].c.equals(Color.YELLOW)
										&& pucks[j - 3][k + 3].c.equals(Color.YELLOW)) {
									System.out.println("Yellow Wins");
									gameOver = true;
									winner = "Yellow";
								}
							}
						} catch (ArrayIndexOutOfBoundsException e) {

						}

					}
				}
			}
		}
		return gameOver;
	}

	public void paintWinner(Graphics g) {
		g.setColor(new Color(64, 64, 64, 200));
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", Font.BOLD, 90));
		String gameover = winner + " Wins";
		g.drawString(gameover, 50, 250);
		g.setFont(new Font("Arial", Font.BOLD, 72));
		g.drawString("Press Enter to Play Again", 50, 350);
	}

	public void reset() {
		for (int j = 0; j < 7; j++) {
			for (int k = 0; k<6; k++) {
				if (this.pucks[j][k] != null) {
					this.pucks[j][k] = null;
				}
			}
		}
		gameOver = false;
		winner = null;
	}
}