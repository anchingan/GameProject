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
	private boolean ballMove;
	
	public GameJPanel() {
		ball = new Ball();
		sx = 0;
		sy = 0;
		ballMove = false;
		
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
		}
		
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (ballMove)
					ballMove = false;
				else
					ballMove = true;
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		ball.paint(g);
	}

}
