package miniTennisFinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game3 extends JPanel {
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	
	int speed=1;
	
	private int getScore()
	{
		return speed-1;
	}

	public Game3() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				racquet.keyReleased(e);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				racquet.keyPressed(e);

			}
		});

		setFocusable(true);

	}

	public void move() {
		ball.move();
		racquet.move();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		
		g2d.setColor(Color.gray);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}

	public void gameOver() {
		JOptionPane.showMessageDialog(this, "your score is:  "+getScore(), "game over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
		
	}
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("mini tennis");
		Game3 obj = new Game3();
		frame.add(obj);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			obj.move();
			obj.repaint();
			Thread.sleep(10);
		}
	}
}
