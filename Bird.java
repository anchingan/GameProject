package gameProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird {
	BufferedImage img;
	private int x, y, drawSizeX, drawSizeY;
	private int vy, ay;
	
	public Bird() {
		try {
			img = ImageIO.read(getClass().getResource("dove.png"));
		} catch (IOException e) {}
		this.x = 50;
		this.y = 300;
		this.vy = 30;
		this.ay = -30;
		this.drawSizeX = 100;
		this.drawSizeY = 100;
	}
	
	public Bird(int x, int y) {
		this();
		if (x >= 0)
			this.x = x;
		if (y >= 0)
			this.y = y;
	}
	
	public Bird(int x, int y, int sizeX, int sizeY) {
		this(x, y);
		if (sizeX > 0)
			this.drawSizeX = sizeX;
		if (sizeY > 0)
			this.drawSizeY = sizeY;
	}
	
	public void move() {
		this.y += this.vy;
	}
	
	public void accel() {
		this.y -= 100;
	}
	
	public void paint (Graphics g) {
		if (this.y <= 800)
			g.drawImage(img, x, y, drawSizeX, drawSizeY, null);
	}
	
	public boolean checkCollide(Cloud c) {
		int left1, left2;
		int right1, right2;
		int top1, top2;
		int bottom1, bottom2;
		
		left1 = x;
		left2 = c.x;
		right1 = x + drawSizeX;
		right2 = c.x + c.sizeX;
		top1 = y;
		top2 = c.y;
		bottom1 = y + drawSizeY;
		bottom2 = c.y + c.sizeY;
		
		if (bottom1 < top2)
			return false;
		if (top1 > bottom2)
			return false;
		if (right1 < left2)
			return false;
		if (left1 > right2)
			return false;
		
		return true;
	}

}
