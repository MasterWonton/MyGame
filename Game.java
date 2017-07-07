package com.mygame.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -3480268084120731011L;
	//get window resolution
	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static final int WIDTH = gd.getDisplayMode().getWidth(), HEIGHT = gd.getDisplayMode().getHeight();
	
	private Thread myThread;
	private boolean running = false;
	private Handler myHandler;
	private Random r = new Random();
	HUD myHud = new HUD(HUD.MaxHealth);
	
	public Game()
	{
		myHandler = new Handler();
		this.addKeyListener(new KeyInput(myHandler));
		
		new Window(WIDTH, HEIGHT, "Build 0.0.3", this);
		myHandler.addObject(new Player(100, 100, ID.player, 8, myHandler));
		for(int i = 0; i < 12; i++)
		{
			myHandler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, 5));
		}
		

	}
	
	//Opens primary thread
	public synchronized void start()
	{
		myThread = new Thread(this);
		myThread.start();
		running = true;
	}
	
	//closes primary thread
	public synchronized void stop()
	{
		try
		{
			myThread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//primary game loop
	public void run()
	{ 
	long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    while(running)
    {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while(delta >=1)
                        {
                            tick();
                            delta--;
                        }
                        if(running)
                            render();
                        frames++;
                        
                        if(System.currentTimeMillis() - timer > 1000)
                        {
                            timer += 1000;
                            System.out.println("FPS: "+ frames);
                            frames = 0;
                        }
    }
            stop();
	
	}
	//renderer
	private void render() 
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//background		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		myHandler.render(g);
		myHud.render(g);
		g.dispose();
		bs.show();
	}
	//ticker
	private void tick() 
	{
		myHandler.tick();
		myHud.tick();
		
	}
	
	public static void main(String args[])
	{
		new Game();
	}
	

}
