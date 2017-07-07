package com.mygame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
		Handler handler;
	
	public Player(int x, int y, ID id, int maxSpeed, Handler myHandler) {
		super(x, y, id, maxSpeed);
		this.handler = myHandler;
		//MaxSpeed = 5;
	}

	public void tick() {

		//Dissalow Exceess Velocity
		velX = Calculations.clamp(velX, -getMaxSpeed(), getMaxSpeed());
		velY = Calculations.clamp(velY, -getMaxSpeed(), getMaxSpeed());
		
		//move the player
		x += velX;
		y += velY;
		
		//dissalow exiting room
		x = Calculations.clamp(x, 0, Game.WIDTH - 32);
		y = Calculations.clamp(y, 0, Game.HEIGHT - 32);
		
		//check for collisions with objects
		collision();
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);
		//show velocity
		g.drawString( ("X " + Integer.toString(velX)), 100, 64);
		g.drawString( ("Y " + Integer.toString(velY)),200, 64);

	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}	
	
	private void collision(){
		
		for(GameObject O : handler.objects)
		{
			if(this.getBounds().intersects(O.getBounds()))
			{
				if(O.id == ID.BasicEnemy)
				{
				HUD.Health-= 25;
				}
			}
		}
		
	}

}
