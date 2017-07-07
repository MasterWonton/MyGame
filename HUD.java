package com.mygame.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static final int MaxHealth = 100;
	public static int Health;
	
	public HUD(int myHealth) 
	{
		Health = myHealth;
	}
	
	public void tick()
	{
		Health = Calculations.clamp(Health, 0, MaxHealth);	
	}
	
	
	public 	void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(16, 16, MaxHealth * 2, 16);
		
		g.setColor(Color.green);
		g.fillRect(16, 16, Health * 2, 16);
	}

}
  