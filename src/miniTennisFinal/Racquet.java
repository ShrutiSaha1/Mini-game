package miniTennisFinal;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Racquet {
	int x=0;
	int xa=0;
	
	int y=230;
	int WIDTH=60;
	int HEIGHT=10;
	
	private Game3 game;
	
	public Racquet(Game3 game) {
		this.game= game;
	}
	
	public void move()
	{
		if(x+xa>0 && x+xa<game.getWidth()-WIDTH)
			x=x+xa;
		
	}
	
	public void paint(Graphics2D g)
	{
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
			
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			xa=0;
			
		}
		
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_LEFT)
				xa=-game.speed;
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				xa=game.speed;
		
		}
		
		
		public Rectangle getBounds()
		{
			return new Rectangle(x, y, WIDTH, HEIGHT);
		}
		
		public int gteTopY()
		{
			return y;
		}
		
		
	

}
