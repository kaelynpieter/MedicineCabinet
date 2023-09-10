import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.*;  
import java.util.*;
import java.time.*;
import java.util.concurrent.TimeUnit;

import Utilities.*;


public class InterfaceMain extends myDrive{
	static int xWidth = 600,yHeight = 600;
	int pageState =0;
	
	
	cabinet home = new cabinet();
	
	int timerM = 0, timeUses = 1;
	
	static Color purple = new Color(223,162,245);
	Color blueVio = new Color(138,43,226);
	Color niceG = new Color(255,215,0);
	Random rand = new Random();

	
	
	public InterfaceMain() {
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		InterfaceMain begin = new InterfaceMain();
		begin.setFrames(80);
		begin.setBackground(purple);
		begin.start(xWidth, yHeight, "My Medicine Cabinet");

		 
		
	}
	
	@Override
	public void update(){
		// TODO Auto-generated method stub
		if(myDrive.KeysPressed[KeyEvent.VK_SPACE])
		{
			home.addMed("Advil", 2, 30, 100, 2, 2);
			System.out.print("Advil Added");
			minWait();
			System.out.print(home.getMedicineInHouse());
		}
		
		if(myDrive.KeysPressed[KeyEvent.VK_1])
		{}
		if(myDrive.KeysPressed[KeyEvent.VK_2])
		{}
		if(myDrive.KeysPressed[KeyEvent.VK_3])
		{}
		if(myDrive.KeysPressed[KeyEvent.VK_4]){}
		 
		if(myDrive.KeysPressed[KeyEvent.VK_A])
		{
			
		}
	
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
	
		if(pageState == 0)
		{
			win.setColor(Color.BLUE);
			win.setFont(new Font("Purisa", Font.PLAIN, 30));
			win.drawString("Press Space to Play", 275, 450);
			win.setFont(new Font("Helvetica", Font.BOLD, 45));
			win.drawString("Welcome to Breakout", 175, 50);
			win.setFont(new Font("Purisa", Font.PLAIN, 10));
			win.drawString("By: Kaelyn Pieter", xWidth/2-35, yHeight-15);
			win.setColor(Color.WHITE);
			drawStar(win, 4, 350, 250);
		}
		if(pageState == 3)
		{
			win.setColor(Color.BLUE);
			win.setFont(new Font("Purisa", Font.PLAIN, 30));
			win.drawString("Press Enter To Play Again", 225, 450);
			win.setFont(new Font("Helvetica", Font.BOLD, 45));
			win.drawString("Thank You For Playing", 165, 50);
			win.setFont(new Font("Helvetica", Font.BOLD, 25));
			win.drawString("Your Score Was: " , xWidth/2-125, 100);
			win.setColor(Color.WHITE);
			drawStar(win, 4, 350, 250);
		}
		if(pageState == 2)
		{
					
			win.setFont(new Font("Helvetica", Font.BOLD, 15));
			win.setColor(blueVio);
			win.drawString("Below is Controlled with the Arrow Keys", xWidth-545, yHeight-77);
			win.drawString("Below Shows What Level You Are Playing", xWidth-550, yHeight-30);
			win.setColor(purple);
			win.drawString("This Ball Can Destroy the Above Bricks",350, 270);
			win.drawString("Each Brick Has Three Lives",275, 50);
			win.drawString("Level ", xWidth-350, yHeight-15);
			win.drawString("Score: " , 300, yHeight-15);
			win.drawString("Lives: " , 200, yHeight-15);
			win.setFont(new Font("Helvetica", Font.BOLD, 45));
			win.drawString("Hold Space To Begin",175, 150);
		}
		
	}
	
	public void miniTimer(int maxTimeM)
	{
		
		if(timerM>maxTimeM)
		{
			timerM=0;
			timeUses = 0;
		}
		else{timerM++;}
	}
	public void minWait()
	{
		try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
