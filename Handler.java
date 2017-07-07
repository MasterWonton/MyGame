package com.mygame.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	//list of all gameobjects
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	//loop through every gameobject and execute tick
	public void tick()
	{
		for(GameObject myObject : objects)
		{
			myObject.tick();
		}
	}
	//loop through every gameobject and execute render
	public void render(Graphics g)
	{
		for(GameObject myObject : objects)
		{
			myObject.render(g);
		}
	}
	//add object to list objects
	public void addObject(GameObject object)
	{
		this.objects.add(object);
	}
	//remove object from list objects
	public void removeObject(GameObject object)
	{
		this.objects.remove(object);
	}
}
