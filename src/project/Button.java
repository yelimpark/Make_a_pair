package project;

import javax.swing.*;
import javax.swing.ImageIcon;

public class Button extends JButton
{
	private ImageIcon front, back;
	private boolean backCheck;  // true = 뒷면  false = 앞면  
	private String name;  //카드 이름 
	
	public Button(String n, ImageIcon argFront,ImageIcon argback)
	{
		front = argFront;
		back = argback;
		backCheck = true;
		name = n;
		setIcon(back);
	}
	
	public String getName() {return name;}
	
	public boolean getBackcheck() {return backCheck;}
	
	public void turnImage() // 카드뒤집기
	{
		if (backCheck)
		{
			setIcon(front);
			backCheck=false;
		}
		else
		{
			setIcon(back);
			backCheck=true;
		}
	}
	
	public boolean cardcheck(Button other) // 카드가 같은지 체크 
	{
		if(this.name.equals(other.getName()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void turnCards(Button B1,Button B2)
	{
		Thread Pause = new Thread( new Runnable(){
            @Override
            public void run() {
				try {
					Thread.sleep(1000);
					B1.turnImage();
					B2.turnImage();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
		});
		Pause.start();
	}
	
	public void firstLook(Button b)
	{
		Thread Pause = new Thread( new Runnable(){
            @Override
            public void run() {
				try {
					Thread.sleep(8000);
					b.turnImage();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
		});
		Pause.start();
	}
	
}