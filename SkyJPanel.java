package gameProject;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import gameProject.GameJPanel.CMyListener1;

public class SkyJPanel extends JPanel {
	Bird bird;
	Sea sea;
	ArrayList<Cloud> clouds;
	Cloud cloud;

	public SkyJPanel() {
		bird = new Bird(100, 300, 80, 80);
		sea = new Sea();
		clouds = new ArrayList<Cloud>();
		cloud = new Cloud();
//		this.addKeyListener(new CKeyListener());
		this.addMouseListener(new CMouseListener1());
		this.addMouseMotionListener(new CMouseListener1());
		
		
		Timer t1 = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bird.move();
				cloud.move();
				if (Math.random() > 0.9 && clouds.size() < 3) {
					Cloud c = new Cloud (((int)Math.random() * 2), (int)(Math.random() * 400));
					clouds.add(c);
				}
				for (int i = 0; i < clouds.size(); i++) {
					if (clouds.get(i).move() == false)
						clouds.remove(i);
					else {
						if (bird.checkCollide(clouds.get(i)))
							System.exit(0);
					}
				}
			}
		});
		t1.start();
	}
	
	class CMouseListener1 extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1)
				bird.accel();
		}
	}
	
	class CKeyListener extends KeyAdapter{
//		@Override
//		public void keyTyped(KeyEvent e) {
//			if (e.getKeyCode() == KeyEvent.VK_SPACE)
//				bird.accel();
//		}
//		@Override
//		public void keyPressed(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
				bird.accel();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		bird.paint(g);
		sea.paint(g);
		cloud.paint(g);
		for (int i = 0; i < clouds.size(); i++) 
			clouds.get(i).paint(g);
	}

	public SkyJPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public SkyJPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public SkyJPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
