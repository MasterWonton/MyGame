package com.mygame.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject
{
 protected int x, y, velX, velY,  MaxSpeed;
 protected ID id;
 
 //default object constructor
 public GameObject(int x, int y, ID id, int maxSpeed)
 {
	 this.x = x;
	 this.y = y;
	 this.id = id;
	 this.MaxSpeed = maxSpeed;
	 
 }
 //abstracts
 public abstract void tick();
 public abstract void render(Graphics g);
 
 public abstract Rectangle getBounds(); //Boundries
 
 //setters
 public void setX(int x){ this.x = x; }
 public void setY(int y){ this.y = y; }
 public void setId(ID id){this.id = id;}
 public void setVelX(int velX){this.velX = velX;}
 public void setVelY(int velY){this.velY = velY;}
 public void setmaxSpeed(int MaxSpeed) {this.MaxSpeed = MaxSpeed;}
 //getters
 public int getX(){ return x; }
 public int getY(){ return y; }
 public ID getId(){ return id; }
 public int getVelY(){ return velY;}
 public int getVelX(){ return velX;}
 public int getMaxSpeed() {return MaxSpeed;}

}
