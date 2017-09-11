package gameProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*; 
import java.util.ArrayList;


public class ProjectileMotion  {
	
    private double time, deltaTime, x, y, ground;
    private double speed, ax, ay, angle, vx, vy;
    private int originX, originY;
    private int[] xs, ys;
    
    public ProjectileMotion() {
    		this.time = 0;
    		this.deltaTime = 1;
    		this.x = 10;
    		this.y = 10;
    		this.ground = 0;
    		this.speed = 100;
    		this.ay = -10;
    		this.angle = 60;
        this.ax = -1;
        this.originX = 50;
        this.originY = 450;
        this.setSpeedComponent();
    }
    
    public ProjectileMotion(int originX, int originY) {
    		this();
    		if (originX > 0)
    			this.originX = originX;
    		if (originY > 0)
    			this.originY = originY;
    }
    
    private void setSpeedComponent() {
//    		this.vx = this.speed*Math.cos(this.angle*(Math.PI/180.0));
//    		this.vy = this.speed*Math.sin(this.angle*(Math.PI/180.0));
    		this.vx = this.speed*Math.cos(Math.toRadians(this.angle));
    		this.vy = this.speed*Math.sin(Math.toRadians(this.angle));
    }
    
    public double getX() {
    		return this.x;
    }
    
    public double getY() {
    		return this.y;
    }
    
    public double getVx() {
    		return this.vx;
    }
    
    public double getVy() {
    		return this.vy;
    }
    
    public void setSpeed(int speed) {
    		if (speed > 0)
    			this.speed = speed;
    }
    
    public void setGround(int ground) {
    		if (ground > 0) 
    			this.ground = ground;
    }
    
    public void setAngle(double angle) {
    		if (angle < 0)
    			angle *= (-1);
    		if (angle > 90)
    			angle = angle % 90;
    		
    		this.angle = 90 - angle;
    		this.setSpeedComponent();
    }
    
    public double getAngle() {
    		return this.angle;
    }
    
    public void next() {
        if (this.y <= ground) {
        		this.time = 0;
        		this.y = 10;
        		this.vx *= 0.9;
        		this.speed *= 0.6;
        		this.setSpeedComponent();
        }
        if (this.vx < 1) {
    			this.vx = 0;
    			this.vy = 0;
    			this.ax = 0;
    			this.ay = 0;
    			this.y = ground;
        }
        else {
        		this.time += this.deltaTime;
            this.x += this.vx * this.deltaTime;
            this.y += this.vy * this.deltaTime;
            this.vx += this.ax * this.deltaTime;
            this.vy += this.ay * this.deltaTime;
        }

    }
    
    public int[][] predict() {
    		int[][] points = new int[2][];
    		int[] x = new int[12], y = new int[12];
    		points[0] = x;
    		points[1] = y;
    		this.deltaTime = 1;
//    		ArrayList<Integer> xs = new ArrayList<Integer>();//
//    		ArrayList<Integer> ys = new ArrayList<Integer>();//
//    		do {//
//    			xs.add(50 + (int) this.x);//
//    			ys.add(450 - (int) this.y);//
//    			this.next();//
//    		} while (this.y <= this.ground);//
    		for (int i = 0; i < 12; i++) {
    			x[i] = 50 + (int) this.x;
        		y[i] = 550 - (int) this.y;
        		this.next();
    		}
//    		int[] x = xs.stream().mapToInt(i -> i).toArray();//
//    		int[] y = ys.stream().mapToInt(i -> i).toArray();//
//    		points[0] = x;//
//    		points[1] = y;//
    		
    		return points;
    }
	
    public void paintLine(Graphics g) {
    		if (this.x == 10) {
        		int[][] points = this.predict();
        		xs = points[0];
        		ys = points[1];
    		}
    		g.drawPolyline(xs, ys, xs.length);
    }
}
