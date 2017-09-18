package gameProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sea {
	BufferedImage sea1, sea2;
	private int x, y, turn;
	

	public Sea() {
		try {
			sea1 = ImageIO.read(getClass().getResource("sea1.png"));
			sea2 = ImageIO.read(getClass().getResource("sea2.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		x = 0;
		y = 580;
		turn = 1;
	}
	
	public void paint(Graphics g) {
		if (turn % 2 == 0) {
			g.drawImage(sea1, x, y, null);
			turn++;
		}
		else {
			g.drawImage(sea2, x, y, null);
			turn--;
		}
	}
	

}
