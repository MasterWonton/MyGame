package com.mygame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject
	{
	
	private Random r = new Random();
	public BasicEnemy(int x, int y, ID id, int maxSpeed)
	{
		super(x, y, id, maxSpeed);
		//randomize velocity and direction
		velX = r.nextInt((2 * MaxSpeed) + 1) - MaxSpeed;
		velY = r.nextInt((2 * MaxSpeed) + 1) - MaxSpeed;
		
	}


	public void tick()
	{
		//ensure velocity != 0
		if(velY == 0) {velY = r.nextInt((2 * MaxSpeed) + 1) - MaxSpeed;}
		if(velX == 0) {velX = r.nextInt((2 * MaxSpeed) + 1) - MaxSpeed;}
		
		x += velX;
		y += velY;
		//Bounce from edges
		if(y <= 0 || y >= Game.HEIGHT) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH) velX *= -1;
	}


	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);

	}


	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

}
