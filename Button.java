package game;
import java.awt.event.*;
import javax.swing.*;
public class Button extends JButton implements ActionListener
{
	ImageIcon image1, image2;
	boolean check;  // true = 뒷면  false = 앞면 
	int i = 0; //선택한 카드 번째수 
	Button[] btn = new Button[2];  // 버튼 
	String name;  //카드 이름 
	String[] checkarr = new String[2]; //2개의 카드 이름 배열 
	int score = 0; //맞춘 카드 쌍 개수 
	int num;
	
	
	public Button(String n, ImageIcon image,ImageIcon back)
	{
		image1 = image;
		image2 = back;
		check = true;
		name = n;
		returnImage();
		addActionListener(this);
	}
	
	public String clickButton() // 앞면 보여주기 
	{
		if(check)
		{
			setIcon(image1);
			check=false;
			return name;
		}
		return null;
	}
	
	public void returnImage() // 뒷면 보여주기 
	{
		setIcon(image2);
		check=true;
	}
	
	public void cardcheck() // 카드가 같은지 체크 
	{
		if(checkarr[0] == checkarr[1])
		{
			score++;
			i = 0;
		}
		else
		{
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			btn[num].returnImage();
			btn[num].returnImage();
			i = 0;
		}
	}
	
	public boolean scorecheck()  //전부 맞췄는지 
	{
		if(score == 15)
			return true;
		else
			return false;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		btn[num] = (Button)e.getSource();
		checkarr[i] = btn[num].clickButton();
		
		if(checkarr[i] == null)
			return;
		if(i==1)
		{
			cardcheck();
			boolean gameend = scorecheck();
			if(gameend)
				return;//끝났을 때 상황 
		}
		i++;
	}
}
	
