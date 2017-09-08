package gameProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ball {
	BufferedImage img;
	private ProjectileMotion track = new ProjectileMotion();
	private int x, y, dir;
	
	public Ball() {
		try {
			img = ImageIO.read(getClass().getResource("ball.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = 0;
		this.y = 500;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void paint (Graphics g) {
		g.drawImage(img, x, y, 100, 100, null);
	}
	
	public void changeDir() {
		if (this.y > 650)
			dir = 1;
		else
			dir = 0;
	}
	
/*	public void move() {
		if (dir == 0) {
			this.x += 1;
			this.y = 2 * (int) Math.pow(this.x, 2);
		}
		else {
			this.x += 1;
			this.y = (int) Math.pow(this.x, 2);
		}
	}
*/
	public void move() {
		this.x = (int) track.getX();
		this.y = 500 - (int) track.getY();
		track.next();
	}
	

}
