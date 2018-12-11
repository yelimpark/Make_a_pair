package project;

import javax.swing.*;
import javax.swing.ImageIcon;

public class Button extends JButton
{
	ImageIcon front, back;
	boolean backCheck;  // true = 뒷면  false = 앞면  
	String name;  //카드 이름 
	
	public Button(String n, ImageIcon InFront,ImageIcon Inback)
	{
		front = InFront;
		back = Inback;
		backCheck = true;
		name = n;
		setIcon(back);
	}
	
	
	public void turnImage() // 카드뒤집기
	{
		if (backCheck)
		{
			setIcon(front);
			setEnabled(false);
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
			this.turnImage();
			other.turnImage();
			return false;
		}
	}

}
