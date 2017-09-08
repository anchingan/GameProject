package gameProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*; 

//implements ActionListener, MouseMotionListener,ChangeListener

public class ProjectileMotion  {
	
    private double time, deltaTime, x, y;
    private double speed, ax, ay, angle, vx, vy;
    
    public ProjectileMotion() {
    		this.time = 0;
    		this.deltaTime = 0.5;
    		this.x = 10;
    		this.y = 10;
    		this.speed = 100;
    		this.ay = -9.8;
    		this.angle = 60;
        this.ax = 0;
        this.vx = this.speed*Math.cos(this.angle*(Math.PI/180.0));
        this.vy = this.speed*Math.sin(this.angle*(Math.PI/180.0));
    }
    
    public double getX() {
    		return this.x;
    }
    
    public double getY() {
    		return this.y;
    }
    
    public void next() {
    		time += this.deltaTime;
        this.x += this.vx * this.deltaTime;
        this.y += this.vy * this.deltaTime;
        this.vx += this.ax * this.deltaTime;
        this.vy += this.ay * this.deltaTime;
    }
	
	/*
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	*/

}
