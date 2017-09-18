package gameProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cloud {
	BufferedImage cloud;
	int x, y, vX;
	int sizeX, sizeY;
	

	public Cloud() {
		try {
			cloud = ImageIO.read(getClass().getResource("cloud1.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		x = 1500;
		y = 200;
		vX = -50;
		sizeX = 200;
		sizeY = 100;
	}
	
	public Cloud(int num) {
		this();
		try {
			if (num == 2)
				cloud = ImageIO.read(getClass().getResource("cloud1.png"));
		} catch (IOException e) {}
	}
	
	public Cloud(int num, int y) {
		this(num);
		if (y > 0 && y < 500)
			this.y = y;
	}
	
	public Cloud(int num, int y, int sizeX, int sizeY) {
		this(num, y);
		if (sizeX > 0)
			this.sizeX = sizeX;
		if (sizeY > 0)
			this.sizeY = sizeY;
	}
	
	public boolean move() {
		this.x += this.vX;
		if (x <= -100)
			return false;
		return true;
	}
	
	public void paint(Graphics g) {
		g.drawImage(cloud, x, y, null);
	}
}
