package com.mygame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	private Handler myHandler;
	
	public KeyInput(Handler handler)
	{
		this.myHandler = handler;
		
	}
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(GameObject object : myHandler.objects)
		{
			if(object.getId() == ID.player)
			{
			 if(key == KeyEvent.VK_W) object.setVelY(object.getVelY() - object.getMaxSpeed());
			 if(key == KeyEvent.VK_S) object.setVelY(object.getVelY() + object.getMaxSpeed());
			 if(key == KeyEvent.VK_A) object.setVelX(object.getVelX() - object.getMaxSpeed());
			 if(key == KeyEvent.VK_D) object.setVelX(object.getVelX() + object.getMaxSpeed());
			}
		}
	}
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		for(GameObject object : myHandler.objects)
		{
			if(object.getId() == ID.player)
			{
			 if(key == KeyEvent.VK_W) object.setVelY(object.getVelY() + object.getMaxSpeed());
			 if(key == KeyEvent.VK_S) object.setVelY(object.getVelY() - object.getMaxSpeed());
			 if(key == KeyEvent.VK_A) object.setVelX(object.getVelX() + object.getMaxSpeed());
			 if(key == KeyEvent.VK_D) object.setVelX(object.getVelX() - object.getMaxSpeed());
			}
		}
	}
}
