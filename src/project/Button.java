package project;

import javax.swing.*;
import javax.swing.ImageIcon;

public class Button extends JButton
{
	private ImageIcon front, back;
	private boolean backCheck;  // true = �޸�  false = �ո�  
	private String name;  //ī�� �̸� 
	
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
	
	public void turnImage() // ī�������
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
	
	public boolean cardcheck(Button other) // ī�尡 ������ üũ 
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