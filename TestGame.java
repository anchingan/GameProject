package gameProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class TestGame {

	public static void main(String[] args) {
		final JFrame f = new JFrame();
		SkyJPanel sjp = new SkyJPanel();
//		GameJPanel gm = new GameJPanel();
		f.setTitle("Bird game");
		f.setSize(1600, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(sjp);
//		f.add(gm);
		f.setVisible(true);
		Timer timer = new Timer(100,
				new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				f.repaint();
			}
		});
		timer.start();

	}

}
