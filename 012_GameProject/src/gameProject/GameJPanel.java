package gameProject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.JPanel;

public class GameJPanel extends JPanel {
	Ball ball;
	int sx, sy;
	private boolean ballMove, drawLine;
	private ProjectileMotion trackLine;
	
	public GameJPanel() {
		ball = new Ball(30, 500);
		sx = 0;
		sy = 0;
		ballMove = false;
		drawLine = true;
		trackLine = new ProjectileMotion();
		
		this.addMouseListener(new CMyListener1());
		this.addMouseMotionListener(new CMyListener1());
		
		Timer t1 = new Timer(100,
				new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (ballMove)
					ball.move();
			}
		});
		t1.start();
	}
	
	class CMyListener1 extends MouseAdapter {
		public void mouseMoved(MouseEvent e) {
			trackLine = new ProjectileMotion();
			if (drawLine) {
				if (e.getX() < ball.getX() && e.getY() > ball.getY()) {
					double xT = (double) (e.getX() - ball.getX() - 50);
					double yT = (double) (e.getY() - ball.getY() - 50);
					trackLine.setAngle((float)Math.toDegrees(Math.atan2(yT, xT)));
//					trackLine.setAngle(Math.atan2(yT, xT)*(180.0/Math.PI));//
				}
			}
		}
		
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				drawLine = false;
				ball.changeDir(e.getX(), e.getY());
				if (ballMove)
					ballMove = false;
				else
					ballMove = true;
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if (drawLine) {
			trackLine.paintLine(g);
		}
		ball.paint(g);
	}
	

}
