package gameProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Ball {
	BufferedImage img;
	private ProjectileMotion track;
	private int x, y, drawSizeX, drawSizeY, yOrigin;
	
	public Ball() {
		try {
			img = ImageIO.read(getClass().getResource("apple.png"));
		} catch (IOException e) {
//			e.printStackTrace();
		}
		track = new ProjectileMotion();
		this.x = 0;
		this.y = 500;
		yOrigin = this.y;
		this.drawSizeX = 64;
		this.drawSizeY = 64;
	}
	
	public Ball(int x, int y) {
		this();
		if (x > 0)
			this.x = x;
		if (y > 0)
			this.y = y;
		yOrigin = this.y;
	}
	
	public Ball(int x, int y, int xsize, int ysize) {
		this(x, y);
		
		if (xsize > 0)
			this.drawSizeX = xsize;
		if (y > 0)
			this.drawSizeY = ysize;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void paint (Graphics g) {
		g.drawImage(img, x, y, drawSizeX, drawSizeY, null);
	}
	
	public void changeDir(int x, int y) {
//		double xT = (double) (x - this.x - (drawSizeX / 2));
//		double yT = (double) (y - this.y - (drawSizeY / 2));
		double xT = (double) (x - this.x - 50);
		double yT = (double) (y - this.y - 50);
		track.setAngle((float)Math.toDegrees(Math.atan2(yT, xT)));
	}
	
	public void move() {
		this.x = (int) track.getX();
		this.y = yOrigin - (int) track.getY();
		if (track.getVx() != 0)
			track.next();
	}
	
	public void setSpeed(int speed) {
		this.track.setSpeed(speed);
	}

}
