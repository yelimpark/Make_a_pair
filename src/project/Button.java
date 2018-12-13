package project;

import javax.swing.*;
import javax.swing.ImageIcon;

public class Button extends JButton
{
	private ImageIcon front, back;
	private boolean backCheck;  // true = 뒷면  false = 앞면  
	private String name;  //카드 이름 
	
	public Button(String n, ImageIcon InFront,ImageIcon Inback)
	{
		front = InFront;
		back = Inback;
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
		if(this.name == other.name)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}