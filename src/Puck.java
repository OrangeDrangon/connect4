import java.awt.Color;
import java.awt.Graphics;

public class Puck {
	public Color c;
	public int gridX;
	public int gridY;
	public int x;
	public int y;
	private Board b;

	public Puck(Color c, Board b) {
		this.c = c;
		this.gridX = 3;
		this.gridY = -1;
		this.b = b;
	}

	private Puck(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}

	public void locationUpdate() {
		this.x = this.gridX * (this.b.width / 7) + 65;
		this.y = this.gridY * (this.b.height / 6) + 110;
	}

	public void paint(Graphics g) {
		g.setColor(this.c);
		g.fillOval(x, y, 100, 100);
	}

	public void move(int k) {
		Puck[][] p = b.getPucks();
		if (k == 37 && this.gridX > 0) {
			this.gridX -= 1;
		} else if (k == 39 && this.gridX < 6) {
			this.gridX += 1;
		} else if (k == 40) {
			try {
				if (p[this.gridX][this.gridY + 1] == null) {
					for (int j = 0; j < 7; j++) {
						if (p[this.gridX][this.gridY + 1] == null) {
							this.gridY += 1;
							continue;
						} else {
							break;
						}
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {
			}
			try {
				this.locationUpdate();
				p[this.gridX][this.gridY] = new Puck(this.x, this.y, this.c);
				this.b.setPucks(p);
				if (this.c == Color.RED) {
					this.c = Color.YELLOW;
				} else {
					this.c = Color.RED;
				}
				this.gridX = 3;
				this.gridY = -1;
			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}
	}
}