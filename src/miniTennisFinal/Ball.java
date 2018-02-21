package miniTennisFinal;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

	int x=0;
	int y=0;
	int xa=1;
	int ya=1;
	int diameter=30;
	
	
	private Game3 game3;
	
		public Ball(Game3 game3)
	{
		this.game3=game3;
	}
	
	void move()
	{
		if(x+xa<0)
		{
			xa=game3.speed;
		}
		if(x+xa>game3.getWidth()-diameter)
		{
			xa=-game3.speed;
		}
		if(y+ya<0)
		{
			ya=game3.speed;
		}
		if(y+ya>game3.getHeight()-diameter)
		{
			game3.gameOver();
		}
		if(collision())
		{
			ya=-game3.speed;
			y=game3.racquet.gteTopY()-diameter;
			game3.speed++;
		}
		
		x=x+xa;
		y=y+ya;
	}
	
	public void paint(Graphics2D g)
	{
		g.fillOval(x, y, 30, 30);
	}
	
	private boolean collision()
	{
		return game3.racquet.getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 30, 30);
	}
	
}
