package gameProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Ball {
	BufferedImage img;
	private ProjectileMotion track, trackLine;
	private int[] xs, ys;
	public boolean drawLine;
	private int x, y, drawSizeX, drawSizeY;
	
	public Ball() {
		try {
			img = ImageIO.read(getClass().getResource("ball.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		track = new ProjectileMotion();
		trackLine = new ProjectileMotion();
		drawLine = true;
		this.x = 0;
		this.y = 500;
		this.drawSizeX = 100;
		this.drawSizeY = 100;
	}
	
	public Ball(int x, int y) {
		this();
		if (x > 0)
			this.x = x;
		if (y > 0)
			this.y = y;
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
		double xT = (double) (x - this.x - (drawSizeX / 2));
		double yT = (double) (y - this.y - (drawSizeY / 2));
//		track.setAngle(Math.atan2(yT, xT)*(180.0/Math.PI)); //
		track.setAngle((float)Math.toDegrees(Math.atan2(yT, xT)));
	}
	
	public void move() {
		this.x = (int) track.getX();
		this.y = 500 - (int) track.getY();
		if (track.getVx() != 0)
			track.next();
	}
	

}
